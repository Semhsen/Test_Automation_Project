package test;

import com.BaseTest;
import com.Home;
import org.junit.Test;
public class N11Test extends BaseTest{

    @Test
    public void successtest() {

        new Home(driver).callLoginPage().n11test("semsenn@gmail.com", "a1234a");

    }

}
