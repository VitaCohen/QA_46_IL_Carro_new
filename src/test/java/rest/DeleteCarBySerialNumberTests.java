package rest;

import api_rest.CarController;
import dto.CarDto;
import dto.CarsDto;
import dto.CarDto;
import dto.ErrorMessageDtoString;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DeleteCarBySerialNumberTests extends CarController {

    SoftAssert softAssert = new SoftAssert();
    CarsDto carsDto;

    @BeforeClass
    public void getUsersCarsBeforeDelete() {
        Response response = getUserCars();
        if (response.getStatusCode() == 200) {
            carsDto = response.getBody()
                    .as(CarsDto.class);
            response.getBody().print();
        } else
            System.out.println("get status code is not 200 --> " + response.getStatusCode());

    }

    @Test
    public void deleteCarPositiveTest() {
        if (carsDto.getCars().length != 0){
            String serialNumber = carsDto.getCars()[0].getSerialNumber();
            Response response = deleteCarBySerialNumber(serialNumber);
            Assert.assertEquals(response.getStatusCode(), 200);
        }else
            Assert.fail("user don't have cars");
    }

    @Test
    public void deleteCarNegativeTest_WrongSerialNumber() {
        Response response = deleteCarBySerialNumber("serialNumber");
        softAssert.assertEquals(response.getStatusCode(), 400);
        ErrorMessageDtoString errorMessageDtoString
                = response.getBody().as(ErrorMessageDtoString.class);
        System.out.println(errorMessageDtoString);
        softAssert.assertEquals(errorMessageDtoString.getMessage(),
                "Car with serial number serialNumber not found");
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request");
        softAssert.assertAll();

    }

}
