package com.yclooper.springredis;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by chen on 2019/11/26.
 */
public class ResUtils {


    public static void main(String[] args) throws Exception{
        KeyPair keyPair = getKeyPair(1024);
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("privateKey=====>" + new String(Base64.getEncoder().encode(privateKey.getEncoded())));
        System.out.println("publicKey=====>" + new String(Base64.getEncoder().encode(publicKey.getEncoded())));


        String msg = "123456789abcdef12345";

        byte[] encrpt = encrpt(msg.getBytes(), publicKey);

        System.out.println(">>>>>>>加密后的数据是：" +  new String(encrpt));

        System.out.println(">>>>>>>解密之后的数据是：" + new String(decrpt(encrpt,privateKey)));
    }


    public static KeyPair getKeyPair(int keyLength) throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024,new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    //加密
    public static byte[] encrpt(byte[] content,PublicKey publicKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    //解密
    public static byte[] decrpt(byte[] content,PrivateKey privateKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }

    //将base64编码后的公钥字符串转成PublicKey实例
    public static PublicKey getPublicKey(String publicKey) throws Exception{
        byte[ ] keyBytes=Base64.getDecoder().decode(publicKey.getBytes());
        X509EncodedKeySpec keySpec=new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory= KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    //将base64编码后的私钥字符串转成PrivateKey实例
    public static PrivateKey getPrivateKey(String privateKey) throws Exception{
        byte[ ] keyBytes=Base64.getDecoder().decode(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec=new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }


    //将base64编码后的公钥字符串转成PublicKey实例
    public static PublicKey getPublicKey(String modulusStr, String exponentStr) throws Exception{
        BigInteger modulus=new BigInteger(modulusStr);
        BigInteger exponent=new BigInteger(exponentStr);
        RSAPublicKeySpec publicKeySpec=new RSAPublicKeySpec(modulus, exponent);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(publicKeySpec);
    }

    //将base64编码后的私钥字符串转成PrivateKey实例
    public static PrivateKey getPrivateKey(String modulusStr, String exponentStr) throws Exception{
        BigInteger modulus=new BigInteger(modulusStr);
        BigInteger exponent=new BigInteger(exponentStr);
        RSAPrivateKeySpec privateKeySpec=new RSAPrivateKeySpec(modulus, exponent);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(privateKeySpec);
    }


}
