package rest;

import api_rest.CarController;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUsersCarsTests extends CarController {

    @Test
    public void getUserCarsPositiveTest(){
        Assert.assertEquals(getUserCars().getStatusCode(), 200);

    }

    @Test
    public void getUserCarsNegativeTest_WrongUrl(){
        Response response = getUsersCars_WrongUrl(LOGIN_URL);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 403);

    }


}
