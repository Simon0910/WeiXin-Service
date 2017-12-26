/**
 * 
 */
package com.young.minico.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.EnumMap;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.young.minico.weixin.controller.qrcode.DecodeImgZxing;

/**
 * @Name EncodeImgZingLogoTest
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月12日 下午4:44:16
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class EncodeImgZingLogoTest {
      
    public void testWriteToFile() {  
//        String contents = "http://blog.csdn.net/typa01_kk";  
//        String format = "jpeg"; //***此处如果格式为"gif"，则logo图片为黑色，其他格式ok  
//        //生成二维码  
//        File logoImg = new File("D:"+File.separator+"logo.jpg");  
//        File img = new File("D:"+File.separator+"csdn.jpg");  
//        EncodeImgZxing.writeToFile(contents, format, img);  
////      //添加logo图片  
//        File img1 = new File("D:"+File.separator+"csdnlogo.jpg");  
//        EncodeImgZingLogo.writeToFile(img, logoImg, format, img1);  
    	File img = new File("D:/test1.jpg");  
        //解析二维码  
        String content = DecodeImgZxing.decodeImg(img);  
        System.out.println(content);   
    	File img1 = new File("D:/test.png");  
        //解析二维码  
        String content1 = DecodeImgZxing.decodeImg(img1);  
        System.out.println(content1); 
    }  
    @Test  
    public void readfile() throws Exception {   
    	File img = new File("D:/test.jpg");  
        BufferedImage image = ImageIO.read(img);  
        EnumMap<DecodeHintType, Object> hints = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);  
        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");  
        LuminanceSource source = new BufferedImageLuminanceSource(image);  
        Binarizer binarizer = new HybridBinarizer(source);  
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
        MultiFormatReader reader = new MultiFormatReader();  
        Result result = reader.decode(binaryBitmap, hints);  
        System.out.println(result.getText()); 
        
        
    	File img1 = new File("D:/test1.jpg"); 
        BufferedImage image1 = ImageIO.read(img1);    
        LuminanceSource source1 = new BufferedImageLuminanceSource(image1);  
        Binarizer binarizer1 = new HybridBinarizer(source1);  
        BinaryBitmap binaryBitmap1 = new BinaryBitmap(binarizer1);  
        MultiFormatReader reader1 = new MultiFormatReader();  
        Result result1 = reader1.decode(binaryBitmap1, hints);   
        System.out.println(result1.getText()); 
    }  
}
