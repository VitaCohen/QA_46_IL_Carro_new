package tests;

import dto.RegistrationBodyDto;
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
        RegistrationBodyDto user = RegistrationBodyDto.builder().firstName("Bob")
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

    @Test
    public void registrationNegativeTest_WrongEmail(){
        int i = new Random().nextInt(1000)+ 1000;
        RegistrationBodyDto user = RegistrationBodyDto.builder().firstName("Bob")
                .lastName("Vays")
                .username(i + "bob_vays_gmail.com")
                .password("123456Aa!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        //registrationPage.clickBtnYalla();
        registrationPage.clickBtnYallaWOWait();
        Assert.assertTrue(registrationPage.validateErroeMessage("Wrong email format"));

    }

    @Test
    public void registrationNegativeTest_EmptyLastName(){
        int i = new Random().nextInt(1000)+ 1000;
        RegistrationBodyDto user = RegistrationBodyDto.builder().firstName("Bob")
                .lastName("")
                .username(i + "bob_vays@gmail.com")
                .password("123456Aa!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYallaWOWait();
        // registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.validateErroeMessage("Last name is required"));
    }

    @Test
    public void registrationNegativeTest_SpaceLastName(){
        int i = new Random().nextInt(1000)+ 1000;
        RegistrationBodyDto user = RegistrationBodyDto.builder().firstName("Bob")
                .lastName(" ")
                .username(i + "bob_vays@gmail.com")
                .password("123456Aa!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYallaWOWait();
        Assert.assertTrue(registrationPage.isPopMessagePresent("must not be blank"));
    }

    @Test
    public void registrationNegativeTest_NoCheckBox(){
        int i = new Random().nextInt(1000)+ 1000;
        RegistrationBodyDto user = RegistrationBodyDto.builder().firstName("Bob")
                .lastName("Vays")
                .username(i + "bob_vays@gmail.com")
                .password("123456Aa!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickBtnYallaWOWait();
        //registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.btnYallaDisabled());

    }

}
