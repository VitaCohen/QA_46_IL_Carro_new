package tests;

import dto.UserDtoLombok;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;

public class LoginTests extends AppManager {
LoginPage loginPage;

@BeforeMethod
    public void goToLoginPage(){
    new SearchPage(getDriver()).clickBtnLogin();
}
@Test
    public void loginPositiveTest(){
    UserDtoLombok user = UserDtoLombok.builder()
            .username("bob_vays@gamil.com")
            .password("123456Aa!")
            .build();
    loginPage = new LoginPage(getDriver());
    loginPage.typeLoginForm(user);
    loginPage.clickBtnYalla();
    Assert.assertTrue(loginPage.isPopMessagePresent("Logged in success"));
}

    @Test
    public void loginNegativeTest_EmptyPassword(){
        UserDtoLombok user = UserDtoLombok.builder()
                .username("bob_vays@gamil.com")
                .password("")
                .build();
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.isPopMessagePresent("Logged or Pasword incorrect"));
    }
    @Test
    public void loginNegitiveTest_wrongEmail(){
        UserDtoLombok user = UserDtoLombok.builder()
                .username("bob_vays_gamil.com")
                .password("123456Aa!")
                .build();
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        //loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.validateErroeMessage("It'snot look like email"));
    }


}
