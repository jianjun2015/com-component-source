package rsa.sign;

import org.apache.commons.codec.binary.Base64;
import rsa.encrypt.RSAEncryptUtil;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA 签名：签名就是你做了任何事，都抵赖不了。
 * Created by wangjianjun on 2017/10/13.
 */
public class RsaSignUtil {

    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     * RSA签名
     * @param content 待签名数据
     * @param privateKey 商户私钥
     * @param encode 字符集编码
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String encode)
    {
        try
        {
            PKCS8EncodedKeySpec priPKCS8    = new PKCS8EncodedKeySpec( Base64.decodeBase64(privateKey) );

            KeyFactory keyf                 = KeyFactory.getInstance("RSA");
            PrivateKey priKey               = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update( content.getBytes(encode));

            byte[] signed = signature.sign();

            return new String(Base64.encodeBase64(signed));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static String sign(String content, String privateKey)
    {
        try
        {
            PKCS8EncodedKeySpec priPKCS8    = new PKCS8EncodedKeySpec( Base64.decodeBase64(privateKey) );
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update( content.getBytes());
            byte[] signed = signature.sign();
            return new String(Base64.encodeBase64(signed));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * RSA验签名检查
     * @param content 待签名数据
     * @param sign 签名值
     * @param publicKey 分配给开发商公钥
     * @param encode 字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey,String encode)
    {
        try
        {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decodeBase64(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update( content.getBytes(encode) );

            boolean bverify = signature.verify( Base64.decodeBase64(sign) );
            return bverify;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean doCheck(String content, String sign, String publicKey)
    {
        try
        {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decodeBase64(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update( content.getBytes() );

            boolean bverify = signature.verify( Base64.decodeBase64(sign) );
            return bverify;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        String content = "welcome to HAHA!";

        String filePath = "C:/RSA";
        RSAEncryptUtil.genKeyPair(filePath);

        String publicKeyString = RSAEncryptUtil.loadPublicKeyByFile(filePath);
        String privateKeyString = RSAEncryptUtil.loadPrivateKeyByFile(filePath);

        RSAPublicKey publicKey = RSAEncryptUtil.loadPublicKeyByStr(publicKeyString);
        RSAPrivateKey privateKey = RSAEncryptUtil.loadPrivateKeyByStr(privateKeyString);

        byte[] textE = RSAEncryptUtil.encrypt(publicKey, content.getBytes());
        String sign = sign(new String(textE), privateKeyString, "utf-8");
        boolean checkTrue = doCheck(new String(textE), sign, publicKeyString);

        if (checkTrue){
            String textD = new String(RSAEncryptUtil.decrypt(privateKey,textE));
            System.out.println(textD);
        }else {
            System.out.println("签名验证不通过");
        }


    }
}
