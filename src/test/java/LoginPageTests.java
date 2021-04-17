import com.testAutomation.base.BaseTest;
import com.testAutomation.pageObjects.HomePage;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    HomePage homePage = new HomePage();

    @Test(groups= {"Regression"})
    public void validate_login_action(){
        homePage.click_login_button();
    }

    @Test(groups= {"Regression"})
    public void validate_login_action_2(){
        homePage.searchFlight("BLR","DEL");
    }

    @Test(groups= {"Regression"})
    public void validate_login_action_3(){
        homePage.searchFlight("BBI","BLR");
    }
}


