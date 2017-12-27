/**
 * 
 */
package com.young.weixin.concat.controller.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.EnumMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * @Name EncodeImgZxing
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月12日 下午4:42:46
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
@SuppressWarnings("deprecation")
public class EncodeImgZxing {
	//二维码颜色  
    private static final int BLACK = 0xFF000000;//0xFFFF0000，红色  
    //二维码背景色  
    private static final int WHITE = 0xFFFFFFFF;//0xFF0000FF，蓝色  
    //注：二维码颜色色差大，扫描快，但如果"BLACK'设置为黑色外其他颜色，可能无法扫描  
    //二维码图片宽度  
    private static final int width = 300;  
    //二维码图片高度  
    private static final int height = 300;  
    //二维码格式参数  
    private static final EnumMap<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);  
    static{  
        /*二维码的纠错级别(排错率),4个级别： 
         L (7%)、 
         M (15%)、 
         Q (25%)、 
         H (30%)(最高H) 
         纠错信息同样存储在二维码中，纠错级别越高，纠错信息占用的空间越多，那么能存储的有用讯息就越少；共有四级； 
         选择M，扫描速度快。 
         */  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
        // 二维码边界空白大小 1,2,3,4 (4为默认,最大)  
        hints.put(EncodeHintType.MARGIN, 1);  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        hints.put(EncodeHintType.MAX_SIZE, 350);  
        hints.put(EncodeHintType.MIN_SIZE, 150);  
    }  
    /** 
     * 绘制二维码 
     * @param contents 二维码内容   
     * @return image 二维码图片 
     * */  
    public static BufferedImage encodeImg(String contents){  
        BufferedImage image = null;  
        try{  
            BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);  
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            int width = matrix.getWidth();  
            int height = matrix.getHeight();  
            for(int x = 0; x < width; x++){  
                for(int y =0;y < height; y++){  
                    image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);  
                }  
            }  
        }catch(Exception e){  
            System.out.println("生成二维码失败"+e.getMessage());  
        }  
        return image;  
    }  
      
    /** 
     * 二维码输出到文件 
     *  @param contents 二维码内容 
     * @param format 图片格式 
     * @param file 输出文件 
     * */  
    public static void writeToFile(String contents,String format,File file){  
        BufferedImage image = encodeImg(contents);  
        try {  
            ImageIO.write(image, format, file);  
        } catch (IOException e) {  
            System.out.println("二维码写入文件失败"+e.getMessage());  
        }  
    }  
    /** 
     * 二维码流式输出 
     *  @param contents 二维码内容 
     * @param format 图片格式 
     * @param stream 输出流 
     * */  
    public static void writeToStream(String contents,String format,OutputStream stream){  
        BufferedImage image = encodeImg(contents);  
        try {  
            ImageIO.write(image, format, stream);  
        } catch (IOException e) {  
            System.out.println("二维码写入流失败"+e.getMessage());  
        }  
    }  
}
