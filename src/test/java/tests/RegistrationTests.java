package tests;

import dto.UserDtoLombok;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SearchPage;

import java.util.Random;

public class RegistrationTests extends AppManager {

    RegistrationPage registrationPage;

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000)+ 1000;
        UserDtoLombok user = UserDtoLombok.builder().firstName("Bob")
                .lastName("Vays")
                .username(i + "bob_vays@gmail.com")
                .password("123456Aa!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.isPopMessagePresent("You are logged in success"));

    }

}
