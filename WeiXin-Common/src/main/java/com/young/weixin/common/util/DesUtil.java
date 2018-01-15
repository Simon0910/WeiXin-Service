package com.young.weixin.common.util;

import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class DesUtil {
    private final static String HEX = "0123456789ABCDEF";
    private final static String TRANSFORMATION = "DES/CBC/PKCS5Padding";//DES是加密方式 CBC是工作模式 PKCS5Padding是填充模式
    private final static String ALGORITHM = "DES";//DES是加密方式
    private static final String SHA1PRNG = "SHA1PRNG";//// SHA1PRNG 强随机种子算法, 要区别4.2以上版本的调用方法


    /**
     * Implementation of Provider for SecureRandom. The implementation     supports the
     * "SHA1PRNG" algorithm described in JavaTM Cryptography Architecture, API
     * Specification & Reference
     */
    public final static class CryptoProvider extends Provider {
        public CryptoProvider() {
            super("Crypto", 1.0, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG","org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    /*
 * 生成随机数，可以当做动态的密钥 加密和解密的密钥必须一致，不然将不能解密
 */
    public static String generateKey() {
        try {
            SecureRandom localSecureRandom = SecureRandom.getInstance(SHA1PRNG);
            byte[] bytes_key = new byte[20];
            localSecureRandom.nextBytes(bytes_key);
            String str_key = toHex(bytes_key);
            return str_key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //二进制转字符
    public static String toHex(byte[] buf) {
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }




    // 对密钥进行处理
    private static Key getRawKey(String key) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
        //for android
        SecureRandom sr = null;
        // 在4.2以上版本中，SecureRandom获取方式发生了改变
//        if (android.os.Build.VERSION.SDK_INT >= 17) {
//            sr = SecureRandom.getInstance("SHA1PRNG", new CryptoProvider());
//        } else {
            sr = SecureRandom.getInstance(SHA1PRNG);
//        }
        // for Java
        // secureRandom = SecureRandom.getInstance(SHA1PRNG);
        sr.setSeed(key.getBytes());
        kgen.init(56, sr); //DES固定格式为64bits，即8bytes。
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        return new SecretKeySpec(raw, ALGORITHM);
    }
    // 对密钥进行处理
//    private static Key getRawKey(String key) throws Exception {
//        DESKeySpec dks = new DESKeySpec(key.getBytes());
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
//        return keyFactory.generateSecret(dks);
//    }



    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     * @param key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     */
    public static String encode(String ips,String key, String data) {
        if(data == null ||data.isEmpty())
            return null;
        return encode(ips,key, data.getBytes());
    }


    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     * @param key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     */
    public static String encode(String ips,String key, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            IvParameterSpec iv = new IvParameterSpec(ips.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, getRawKey(key), iv);
            byte[] bytes = cipher.doFinal(data);
            return Base64.encode(bytes);
        } catch (Exception e) {
            return null;
        }
    }




    /**
     * 获取编码后的值
     *
     * @param key
     * @param data
     * @return
     */
    public static String decode(String ips, String key, String data) {
        return decode(ips,key, Base64.decode(data));
    }

    /**
     * DES算法，解密
     *
     * @param data 待解密字符串
     * @param key  解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     */
    public static String decode(String ips,String key, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            IvParameterSpec iv = new IvParameterSpec(ips.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, getRawKey(key), iv);
            byte[] original = cipher.doFinal(data);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            return null;
        }
    }


    // 向量    
    private final static String iv = "01234567";    
    // 加解密统一使用的编码方式    
    private final static String encoding = "utf-8";  
    /**  
     * 3DES加密  
     *   
     * @param plainText 普通文本  
     * @return  
     * @throws Exception   
     */    
    public static String encode(String plainText,String secretKey)  {    
        try {
            Key deskey = null;    
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());    
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");    
            deskey = keyfactory.generateSecret(spec);    
        
            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");    
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());    
            cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);    
            byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));    
            return Base64.encode(encryptData); 
        } catch (Exception e) {
            return null;
        }   
    }    
    
    /**  
     * 3DES解密  
     *   
     * @param encryptText 加密文本  
     * @return  
     * @throws Exception  
     */    
    public static String decode(String encryptText,String secretKey) {       
        try {
            Key deskey = null;    
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());    
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");    
            deskey = keyfactory.generateSecret(spec);    
            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");    
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());    
            cipher.init(Cipher.DECRYPT_MODE, deskey, ips);    
        
            byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));    
        
            return new String(decryptData, encoding);  
        } catch (Exception e) {
            return null;
        }     
    }   
    public static void main(String[] args)
    {
        String ips = "53621486";
        String key = "146939c640684386b2776e1ad090baf4cfc1693dce114274b9e663e5a5c69ad48b990a8abb394c25a8b4dee488c512fd99bbab89fee8445bbef464f75bdc7b69";
        String data = "18281545661-360-500";
        String enStr = Des3Util.encode(ips ,key,data);
        System.out.println(enStr);
        String deStr = Des3Util.decode(ips ,key,enStr);
        System.out.println(deStr);
        
        enStr = Des3Util.encode(data,key);
        System.out.println(enStr);
        deStr = Des3Util.decode(enStr,key);
        System.out.println(deStr);
    }
//    public static void main(String[] args)
//    {
//        String ips = "53621486";
//        String key = "146939c640684386b2776e1ad090baf4cfc1693dce114274b9e663e5a5c69ad48b990a8abb394c25a8b4dee488c512fd99bbab89fee8445bbef464f75bdc7b69";
//        String data = "18281545661-360-500";
//        String enStr = DesUtil.encode(ips ,key,data);
//        System.out.println(enStr);
//        String deStr = DesUtil.decode(ips ,key,enStr);
//        System.out.println(deStr);
//    }
}
