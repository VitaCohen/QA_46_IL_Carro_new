package rest;

import api_rest.CarController;
import dto.CarDto;
import dto.ErrorMessageDtoString;
import enums.Fuel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class AddNewCarTests extends CarController {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addNewCarPositiveTest(){
        int i = new Random().nextInt(1000)+1000;
        CarDto car = CarDto.builder()
                .serialNumber("456 - "+ i)
                .manufacture("Opel")
                .model("corsa")
                .year("2015")
                .fuel(Fuel.HYBIRD.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(20.5)
                .city("Haifa")
                .build();
        Response response = addNewCar(car);
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertTrue(response.getBody()
                .print().contains("Car added"));
        softAssert.assertAll();

    }
    @Test
    public void addNewCarNegativeTest_WrongAuthorization(){
        int i = new Random().nextInt(1000)+1000;
        CarDto car = CarDto.builder()
                .serialNumber("456 - "+ i)
                .manufacture("Opel")
                .model("corsa")
                .year("2015")
                .fuel(Fuel.HYBIRD.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(20.5)
                .city("Haifa")
                .build();
        Response response = addNewCar_WrongToken(car,
                "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoibXVyemlrMTIzQGdtYWlsLmNvbSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNzQ4Nzk0MDY4LCJpYXQiOjE3NDgxOTQwNjh9.KEFS1LeVD7zbFD3RruAqGceGQEF0VT1P7ONoD");
        softAssert.assertEquals(response.getStatusCode(), 401);
        softAssert.assertTrue(response.getBody()
                .print().contains("JWT signature does not match locally computed signature."));
        softAssert.assertAll();

    } @Test
    public void addNewCarNegativeTest_WrongBodyRequest(){
        CarDto car = CarDto.builder()
                .manufacture("Opel")
                .model("corsa")
                .year("2015")
                .fuel(Fuel.HYBIRD.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(20.5)
                .city("Haifa")
                .build();
        Response response = addNewCar(car);
        ErrorMessageDtoString errorMessageDtoString = response.getBody()
                        .as(ErrorMessageDtoString.class);
        softAssert.assertEquals(response.getStatusCode(), 400);
        System.out.println(errorMessageDtoString.toString());
        softAssert.assertTrue(errorMessageDtoString.getMessage()
                .toString().contains("must not"));
        softAssert.assertTrue(errorMessageDtoString.getError()
                .equals("Bad Request"));
        softAssert.assertAll();

    }


}
