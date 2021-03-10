package io.grpc.examples.manualflowcontrol;

import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

/**
 * @author: tk (soulmate.tangk at gmail dot com)
 * @date: 2021/2/23
 */
public class MyClientResponseObserver implements ClientResponseObserver<HelloRequest, HelloReply> {
    private static final Logger logger =
            Logger.getLogger(MyClientResponseObserver.class.getName());

    private final CountDownLatch done;
    private final int currentIndex;
    ClientCallStreamObserver<HelloRequest> requestStream;

    public MyClientResponseObserver(CountDownLatch done, int currentIndex) {
        this.done = done;
        this.currentIndex = currentIndex;
    }

    @Override
    public void beforeStart(final ClientCallStreamObserver<HelloRequest> requestStream) {
        this.requestStream = requestStream;
        // Set up manual flow control for the response stream. It feels backwards to configure the response
        // stream's flow control using the request stream's observer, but this is the way it is.
        requestStream.disableAutoRequestWithInitial(1);

        // Set up a back-pressure-aware producer for the request stream. The onReadyHandler will be invoked
        // when the consuming side has enough buffer space to receive more messages.
        //
        // Messages are serialized into a transport-specific transmit buffer. Depending on the size of this buffer,
        // MANY messages may be buffered, however, they haven't yet been sent to the server. The server must call
        // request() to pull a buffered message from the client.
        //
        // Note: the onReadyHandler's invocation is serialized on the same thread pool as the incoming
        // StreamObserver's onNext(), onError(), and onComplete() handlers. Blocking the onReadyHandler will prevent
        // additional messages from being processed by the incoming StreamObserver. The onReadyHandler must return
        // in a timely manner or else message processing throughput will suffer.
        requestStream.setOnReadyHandler(new Runnable() {
            @Override
            public void run() {
                // Start generating values from where we left off on a non-gRPC thread.
                while (requestStream.isReady()) {
                    String s = "发送" + currentIndex + new String(new byte[1024 * 25]);
                    HelloRequest request = HelloRequest.newBuilder().setName(s).build();
                    requestStream.onNext(request);
                    requestStream.onCompleted();
                }
            }
        });
    }

    @Override
    public void onNext(HelloReply value) {
        logger.info("receive from server<-- " + value.getMessage() + "====current index=" + currentIndex);
        // Signal the sender to send one message.
        requestStream.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        done.countDown();
    }

    @Override
    public void onCompleted() {
        logger.info("All Done");
        done.countDown();
    }
}
