import org.eagle.util.RSAUtil;
import org.junit.Test;

/**
 * @author ljj
 */
public class MyTest {

    @Test
    public void sign() throws Exception {
        String password = "ameco";
        String encrypt = RSAUtil.encrypt(password);
        final String decrypt = RSAUtil.decrypt(encrypt);

        System.out.println("加密前 ---> " + password);
        System.out.println("加密后 ---> " + encrypt);
        System.out.println("解密后 ---> " + decrypt);
    }
}
