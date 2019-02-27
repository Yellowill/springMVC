package com.allianz.pa.common.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;

public class DesEncodeUtil {
    private static final String KEY="AZCN-ZM";
    private static final String AZCN_SHORTURL_KEY="AZCNSU";

    /**
     * 根据参数生成KEY
     *
     * @param strKey
     */
    public static Key getKey(String strKey) {
        try {
            KeyGenerator _generator = KeyGenerator.getInstance("DES");
            _generator.init(new SecureRandom(strKey.getBytes()));
            Key key = _generator.generateKey();
            _generator = null;
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密String明文输入,String密文输出
     *
     * @param strMing
     * @return
     */
    public static String getEncString(String strMing, Key key) {
        byte[] byteMi = null;
        byte[] byteMing = null;
        String strMi = "";
     //   BASE64Encoder base64en = new BASE64Encoder();
        try {
            byteMing = strMing.getBytes("UTF8");
            byteMi = getEncCode(byteMing, key);
            return new String(Base64.encodeBase64URLSafe(byteMi),"UTF-8");
          //  strMi = base64en.encode(byteMi);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         //   base64en = null;
            byteMing = null;
            byteMi = null;
        }
        return strMi;
    }

    /**
     * 解密 以String密文输入,String明文输出
     *
     * @param strMi
     * @return
     */
    public static String getDesString(String strMi, Key key) {
        if(null == strMi || "".equals(strMi)) {
            return null;
        }
        
      //  BASE64Decoder base64De = new BASE64Decoder();
        byte[] byteMing = null;
        byte[] byteMi = null;
        String strMing = "";
        try {
           // byteMi = base64De.decodeBuffer(strMi);
           byteMi = Base64.decodeBase64(strMi.getBytes("UTF-8"));
            byteMing = getDesCode(byteMi, key);
            strMing = new String(byteMing, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // base64De = null;
            byteMing = null;
            byteMi = null;
        }
        return strMing;
    }

    /**
     * 加密以byte[]明文输入,byte[]密文输出
     *
     * @param byteS
     * @return
     */
    private static byte[] getEncCode(byte[] byteS, Key key) {
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byteFina = cipher.doFinal(byteS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * 解密以byte[]密文输入,以byte[]明文输出
     *
     * @param byteD
     * @return
     */
    private static byte[] getDesCode(byte[] byteD, Key key) {
        Cipher cipher;
        byte[] byteFina = null;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byteFina = cipher.doFinal(byteD);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;

    }
    
    /**
     * 生成密匙
     * @return
     */
    public static String getEncString(String str){
        return getEncString(str, getKey(KEY));
    }
    
    /**
     * 把String 类型的密文解密
     * @return
     */
    public static String getDesString(String str){
        return getDesString(str, getKey(KEY));
    } 
    /**
     * 生成密匙
     * @return
     */
    public static String getEncStringWithKey(String str,String key){
        return getEncString(str, getKey(key));
    }
    
    /**
     * 把String 类型的密文解密
     * @return
     */
    public static String getDesStringWithKey(String str,String key){
        return getDesString(str, getKey(key));
    } 
    public static void main(String[] args) {
        // 生成密匙
        String strEnc = getEncString("Tj23!JT8");
        // 加密字符串,返回String的密文
        System.out.println("enCode =" + strEnc);

        String strDes = getDesString(strEnc);
        // 把String 类型的密文解密
        System.out.println("deCode=" + strDes);
        
        System.out.println("contract_id enc= " +getEncStringWithKey("8830109",AZCN_SHORTURL_KEY));
        System.out.println("contract_id des= " +getDesStringWithKey("1EjVGlQYN9U",AZCN_SHORTURL_KEY));

    }
}
