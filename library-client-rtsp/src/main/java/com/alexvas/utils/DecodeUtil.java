package com.alexvas.utils;


import java.util.Arrays;

public class DecodeUtil {
    private static final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static String byteArrayToHexString(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;

        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }

        return new String(hexChars);
    }


    /*AVCodec avcodec = new AVCodec();
    AVCodecContext videoCodecContext = new AVCodecContext();

    public IplImage decodeFromVideo(byte[] data, long timeStamp) {
        avcodec.av_init_packet(reveivedVideoPacket); // Empty AVPacket
        *//*
         * Determine if the frame is a Data Frame or Key. IFrame 1 = PFrame 0 = Key
         * Frame
         *//*
        byte frameFlag = data[1];
        byte[] subData = Arrays.copyOfRange(data, 5, data.length);

        BytePointer videoData = new BytePointer(subData);
        if (frameFlag == 0) {
            avcodec.AVCodec codec = avcodec
                    .avcodec_find_decoder(avcodec.AV_CODEC_ID_H264);
            if (codec != null) {
                videoCodecContext = null;
                videoCodecContext = avcodec.avcodec_alloc_context3(codec);
                videoCodecContext.width(320);
                videoCodecContext.height(240);
                videoCodecContext.pix_fmt(avutil.AV_PIX_FMT_YUV420P);
                videoCodecContext.codec_type(avutil.AVMEDIA_TYPE_VIDEO);
                videoCodecContext.extradata(videoData);
                videoCodecContext.extradata_size(videoData.capacity());

                videoCodecContext.flags2(videoCodecContext.flags2()
                        | avcodec.CODEC_FLAG2_CHUNKS);
                avcodec.avcodec_open2(videoCodecContext, codec,
                        (PointerPointer) null);

                if ((videoCodecContext.time_base().num() > 1000)
                        && (videoCodecContext.time_base().den() == 1)) {
                    videoCodecContext.time_base().den(1000);
                }
            } else {
                Log.e("test", "Codec could not be opened");
            }
        }

        if ((decodedPicture = avcodec.avcodec_alloc_frame()) != null) {
            if ((processedPicture = avcodec.avcodec_alloc_frame()) != null) {
                int width = getImageWidth() > 0 ? getImageWidth()
                        : videoCodecContext.width();
                int height = getImageHeight() > 0 ? getImageHeight()
                        : videoCodecContext.height();

                switch (imageMode) {
                    case COLOR:
                    case GRAY:
                        int fmt = 3;
                        int size = avcodec.avpicture_get_size(fmt, width, height);
                        processPictureBuffer = new BytePointer(
                                avutil.av_malloc(size));
                        avcodec.avpicture_fill(new AVPicture(processedPicture),
                                processPictureBuffer, fmt, width, height);
                        returnImageFrame = opencv_core.IplImage.createHeader(320,
                                240, 8, 1);
                        break;
                    case RAW:
                        processPictureBuffer = null;
                        returnImageFrame = opencv_core.IplImage.createHeader(320,
                                240, 8, 1);
                        break;
                    default:
                        Log.d("showit",
                                "At default of swith case 1.$SwitchMap$com$googlecode$javacv$FrameGrabber$ImageMode[ imageMode.ordinal()]");
                }

                reveivedVideoPacket.data(videoData);
                reveivedVideoPacket.size(videoData.capacity());

                reveivedVideoPacket.pts(timeStamp);
                videoCodecContext.pix_fmt(avutil.AV_PIX_FMT_YUV420P);
                decodedFrameLength = avcodec.avcodec_decode_video2(videoCodecContext,
                        decodedPicture, isVideoDecoded, reveivedVideoPacket);

                if ((decodedFrameLength >= 0) && (isVideoDecoded[0] != 0)) {
 .... Process image same as javacv .....
                }*/
}
