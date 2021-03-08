package io.grpc.examples.manualflowcontrol;

/**
 * @author: tk (soulmate.tangk at gmail dot com)
 * @date: 2021/3/8
 */
public class LargeMessageConstants {
    public static void main(String[] args) {
        System.out.println(STRING_1024_3.getBytes().length);
    }

    public static final String STRING_1024 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaa";
    public static final byte[] BYTES_1024 = STRING_1024.getBytes();
    public static final byte[] BYTES_1024_2 = new StringBuilder().append(STRING_1024).append(STRING_1024).toString().getBytes();
    public static final String STRING_1024_2 = STRING_1024 + STRING_1024;
    public static final String STRING_1024_3 = STRING_1024_2 + STRING_1024;
    public static final String STRING_1024_4 = STRING_1024_2 + STRING_1024_2;
    public static final String STRING_1024_5 = STRING_1024_3 + STRING_1024_2;
    public static final String STRING_1024_6 = STRING_1024_3 + STRING_1024_3;
    public static final String STRING_1024_7 = STRING_1024_3 + STRING_1024_4;
    public static final String STRING_1024_8 = STRING_1024_7 + STRING_1024;
    public static final String STRING_1024_9 = STRING_1024_7 + STRING_1024_2;
    public static final String STRING_1024_10 = STRING_1024_9 + STRING_1024;
    public static final String STRING_1024_20 = STRING_1024_10 + STRING_1024_10;
    public static final String STRING_1024_40 = STRING_1024_20 + STRING_1024_20;
    public static final byte[] BYTES_1024_40 = new StringBuilder(STRING_1024_40).toString().getBytes();
    public static final byte[] BYTES_1024_80 = new StringBuilder(STRING_1024_40).append(STRING_1024_40).toString().getBytes();
    public static final byte[] BYTES_1024_160 = new StringBuilder(STRING_1024_40)
            .append(STRING_1024_40)
            .append(STRING_1024_40)
            .append(STRING_1024_40)
            .toString().getBytes();
    public static final byte[] BYTES_1024_320 = new StringBuilder(STRING_1024_40)
            .append(STRING_1024_40)
            .append(STRING_1024_40)
            .append(STRING_1024_40)
            .append(STRING_1024_40)
            .append(STRING_1024_40)
            .append(STRING_1024_40)
            .append(STRING_1024_40)
            .toString().getBytes();
    //public static final String STRING_1024_80 = STRING_1024_40 + STRING_1024_40;
//    public static final String STRING_1024_160 = STRING_1024_80 + STRING_1024_80;
}
