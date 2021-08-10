package com.vaas.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes {

    private static final Integer IVSize = 16;
    private static final Integer SecretKeySize = 32;
    private static final String SecretKey = ConfigMap.getValue("ACCESS_TOKEN");
    private static final String Encode = "UTF-8";
    private static final String EncryptAlg = "AES";
    private static final String CipherMode = "AES/CBC/PKCS5Padding";

    public static SecretKeySpec createKey() {
        StringBuilder sb = new StringBuilder(SecretKeySize);
        sb.append(SecretKey);
        if (sb.length() > SecretKeySize) {
            sb.setLength(SecretKeySize);
        }
        if (sb.length() < SecretKeySize) {
            while (sb.length() < SecretKeySize) {
                sb.append(" ");
            }
        }
        try {
            byte[] data = sb.toString().getBytes(Encode);
            return new SecretKeySpec(data, EncryptAlg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static IvParameterSpec createIV() {
        StringBuilder sb = new StringBuilder(IVSize);
        sb.append(SecretKey);
        if (sb.length() > IVSize) {
            sb.setLength(IVSize);
        }
        if (sb.length() < IVSize) {
            while (sb.length() < IVSize) {
                sb.append("0");
            }
        }
        byte[] data = null;
        try {
            data = sb.toString().getBytes(Encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new IvParameterSpec(data);
    }

    // AES 加密
    public static String encrypt(String context) {
        try {
            byte[] content = context.getBytes(Encode);
            SecretKeySpec key = createKey();
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.ENCRYPT_MODE, key, createIV());
            byte[] data = cipher.doFinal(content);
            return Base64.getEncoder().encodeToString(data);
        } catch (Exception ignored) {
        }
        return null;
    }

    // AES 解密
    public static String decrypt(String context) {
        try {
            byte[] data = Base64.getDecoder().decode(context);
            SecretKeySpec key = createKey();
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.DECRYPT_MODE, key, createIV());
            byte[] content = cipher.doFinal(data);
            return new String(content, Encode);
        } catch (Exception ignored) {
        }
        return null;
    }
}
