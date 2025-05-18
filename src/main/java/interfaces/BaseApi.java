package interfaces;

import com.google.gson.Gson;

public interface BaseApi {

    String BASE_URL ="https://ilcarro-backend.herokuapp.com";

    String BASE_URL_HTTP ="http://ilcarro-backend.herokuapp.com";
    String REGISTRATION_URL = "/v1/user/registration/usernamepassword";
    Gson GSON = new Gson();

}
