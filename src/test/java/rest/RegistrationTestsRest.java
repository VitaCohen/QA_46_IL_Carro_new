package rest;

import api_rest.AuthenticationController;
import dto.ErrorMessageDtoString;
import dto.RegistrationBodyDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class RegistrationTestsRest extends AuthenticationController {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user =
                RegistrationBodyDto.builder()
                        .username("babi" + i + "@gmail.com")
                        .password("123789Qq!")
                        .firstName("Babi")
                        .lastName("Mur").build();
        Assert.assertEquals(registrationLogin(user,
                REGISTRATION_URL)
                .getStatusCode(), 200);

    }

    @Test
    public void registrationNegativeTest_protocolHTTP_NotSecure() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("mursik" + i + "@gmail.com")
                .password("Password123!")
                .firstName("Mursik")
                .lastName("Mur").build();
        Response response = registrationLoginHTTP(user, REGISTRATION_URL);
        System.out.println(response.print());
        Assert.assertEquals(registrationLoginHTTP(user, REGISTRATION_URL)
                .getStatusCode(), 200);
    }

    @Test
    public void registrationNegativeTest_WrongEmail() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("murik" + i + "gmail.com")
                .password("Password123!")
                .firstName("Mursik")
                .lastName("Mur").build();
        Response response = registrationLogin(user, REGISTRATION_URL);
       softAssert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(), 400);
        ErrorMessageDtoString erroeMessage = response.getBody()
                .as(ErrorMessageDtoString.class);
        softAssert.assertEquals(erroeMessage.getError(), "Bad Request");
        softAssert.assertTrue(erroeMessage.getMessage()
                .toString().contains("well-formed email address"));
        softAssert.assertAll();
    }


}
