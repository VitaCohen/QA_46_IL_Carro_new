package rest;

import api_rest.AuthenticationController;
import dto.RegistrationBodyDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class LoginTestsRest extends AuthenticationController {

    RegistrationBodyDto user;

    @BeforeClass
    public void registrationUser() {
        int i = new Random().nextInt(1000);
        user = RegistrationBodyDto.builder()
                .username("mursik" + i + "@gmail.com")
                .password("Password123!")
                .firstName("Mursik")
                .lastName("Mur").build();
        System.out.println("result registration --> "
                + registrationLogin(user, REGISTRATION_URL).getStatusCode());
    }

    @Test
    public void loginPositiveTest() {
        Assert.assertEquals(registrationLogin(user, LOGIN_URL)
                .getStatusCode(), 200);
    }

    @Test
    public void loginNegativeTest_WrongPassword() {
        user.setPassword("password123!");
        Response response = registrationLogin(user, LOGIN_URL);
        Assert.assertEquals(response.getStatusCode(), 401);


    }

    @Test
    public void loginNegativeTest_WrongEmail() {
        user.setUsername("user_name@mail.com");
        Response response = registrationLogin(user, LOGIN_URL);
        System.out.println(response.getBody().print());
        Assert.assertEquals(response.getStatusCode(), 401);
    }

}
