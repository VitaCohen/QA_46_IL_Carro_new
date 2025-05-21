package interfaces;

import com.google.gson.Gson;

public interface BaseApi {

    String BASE_URL = "https://ilcarro-backend.herokuapp.com";

    String BASE_URL_HTTP = "http://ilcarro-backend.herokuapp.com";
    String REGISTRATION_URL = "/v1/user/registration/usernamepassword";
    String LOGIN_URL = "/v1/user/login/usernamepassword";

    String ADD_NEW_CAR_URL = "/v1/cars";
    String GET_USER_CAR_URL = "/v1/cars/my";
    String DELETE_CAR_URL = "/v1/cars/";

    //Gson GSON = new Gson();

}
