package org.eagle.util;

import java.io.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import org.springframework.core.io.ClassPathResource;

/**
 * @author ：songjian
 * @date ：Created in 2022/6/20 11:26
 */
public class RSAUtil {
    private static final String KEY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static final char  DUSH = '-';

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data 加密数据
     * @param privateKey 私钥
     */
    public static String sign(byte[] data, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance(KEY_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data);
        return encryptBase64(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data 加密数据
     * @param privateKey 私钥
     * @param sign 数字签名
     * @return 校验成功返回true 失败返回false
     */
    public static boolean verify(byte[] data, PrivateKey privateKey, String sign) throws Exception {
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data);
        return signature.verify(decryptBase64(sign));
    }

    /**
     * 私钥解密
     *
     * @param data 密文
     * @param privateKey 私钥
     */
    public static byte[] decryptByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 用公钥解密
     *
     * @param data 密文
     * @param publicKey 公钥
     */
    public static byte[] decryptByPublicKey(byte[] data, PublicKey publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 用公钥加密
     *
     * @param data 明文
     * @param publicKey 公钥
     */
    public static byte[] encryptByPublicKey(byte[] data, PublicKey publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 用私钥加密
     *
     * @param data 明文
     * @param privateKey 私钥
     */
    public static byte[] encryptByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    public static PrivateKey getPrivateKeyFromPem() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(getFileInputStream("private_key.pem")));

        br.readLine();
        String s;
        String str = "";
        s = br.readLine();
        while (s.charAt(0) != DUSH) {
            str += s + "\r";
            s = br.readLine();
        }
        Base64.Decoder decoder = Base64.getMimeDecoder();
        final byte[] b = decoder.decode(str);

        // 生成私匙
        KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(b);
        PrivateKey privateKey = kf.generatePrivate(keySpec);
        return privateKey;
    }

    public static InputStream getFileInputStream(String filename) throws Exception{
        ClassPathResource classPathResource = new ClassPathResource(filename);
        return classPathResource.getInputStream();
    }

    public static PublicKey getPublicKeyFromPem() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(getFileInputStream("public_key.pem")));

        String s = br.readLine();
        String str = "";
        s = br.readLine();
        while (s.charAt(0) != DUSH) {
            str += s + "\r";
            s = br.readLine();
        }
        Base64.Decoder decoder = Base64.getMimeDecoder();
        byte[] b = decoder.decode(str);

        KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(b);
        PublicKey pubKey = kf.generatePublic(keySpec);
        return pubKey;
    }

    public static byte[] decryptBase64(String key) throws Exception {
        return Base64.getDecoder().decode(key);
    }

    public static String encryptBase64(byte[] key) throws Exception {
        return Base64.getEncoder().encodeToString(key);
    }

    /**
     * 解密算法
     * @param cryptograph    密文
     * @return
     * @throws Exception
     */
    public static String decrypt(String cryptograph) throws Exception {

        KeyFactory keyf = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = getPrivateKeyFromPem();

        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance(keyf.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] b1 = decoder.decode(cryptograph);

        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }

    /**
     * 加密方法
     * @param source 源数据
     * @return
     * @throws Exception
     */
    public static String encrypt(String source) throws Exception {

        // RSA算法
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        // 取公钥匙对象
        PublicKey publicKey = getPublicKeyFromPem();
        // 得到Cipher对象来实现对源数据的RSA加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] b = source.getBytes();
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);

        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(b1);
    }


    public static void main(String[] args) throws Exception {
        // 要加密的字符串
        String source = "Lop.1234";
        System.out.println("准备用公钥加密的字符串为：" + source);
        // 生成的密文
        String cryptograph = RSAUtil.encrypt(source);
        System.out.print("用公钥加密后的结果为:" + cryptograph);
        System.out.println();
        // 解密密文
        String target = RSAUtil.decrypt(cryptograph);
        System.out.println("用私钥解密后的字符串为：" + target);
        System.out.println();

    }
}
