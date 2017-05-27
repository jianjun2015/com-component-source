package component.encode_password;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.*;
import org.apache.shiro.util.ByteSource;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;

/**
 * Created by wangjianjun on 2017/5/27.
 */
public class EncodeDeCodeTest {

    @Test
    public void test_64(){

        String  str = "hello";
        String base64Encode = Base64.encodeToString(str.getBytes());
        String str2 = Base64.decodeToString(base64Encode);

        System.out.println(base64Encode);
        System.out.println(str2);

        Assert.assertEquals(str,str2);
    }

    @Test
    public void test_16(){

        String  str = "hello";
        String base16Encode = Hex.encodeToString(str.getBytes());
        String str2 = new String(Hex.decode(base16Encode.getBytes()));

        System.out.println(base16Encode);
        System.out.println(str2);

        Assert.assertEquals(str,str2);
    }

    //不可逆算法
    @Test
    public void tesh_hash(){

        String str = "hello";
        String salt = "123";

        String md5 = new Md5Hash(str,salt).toString();
        String shal = new Sha256Hash(str,salt).toString();
        String simpleHash = new SimpleHash("SHA-1",str,salt).toString();

        System.out.println(md5);
        System.out.println(shal);
        System.out.println(simpleHash);
    }

    @Test
    public void testHashService(){

        DefaultHashService hashService = new DefaultHashService();

        hashService.setHashAlgorithmName("SHA-512");
        hashService.setPrivateSalt(new SimpleHash("123"));
        hashService.setGeneratePublicSalt(true);
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        hashService.setHashIterations(1);

        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("MD5")
                .setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123"))
                .setIterations(1)
                .build();

        String hex = hashService.computeHash(request).toHex();
        System.out.println(hex);
    }

    @Test
    public void test_random(){

        SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        randomNumberGenerator.setSeed("123".getBytes());

        String hex = randomNumberGenerator.nextBytes().toHex();
        System.out.println(hex);
    }

    //对称加密算法
    @Test
    public void test_AES(){

        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128);//设置key长度

        String text = "hello";

        Key key = aesCipherService.generateNewKey();

        //加密
        String encrpText = aesCipherService.encrypt(text.getBytes(),key.getEncoded()).toHex();

        //解密
        String deText = new String(aesCipherService.decrypt(Hex.decode(encrpText),key.getEncoded()).getBytes());

        System.out.println(encrpText);
        System.out.println(deText);

        Assert.assertEquals(text,deText);
    }
}
