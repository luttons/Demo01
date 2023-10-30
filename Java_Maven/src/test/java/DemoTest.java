import com.lutton.Demo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName：DemoTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class DemoTest {
    @Test
    public void testHello() {
        Demo d = new Demo();
        String ret = d.hello("xiaosi");
        Assert.assertEquals("Helloxiaosi", ret);


    }
}