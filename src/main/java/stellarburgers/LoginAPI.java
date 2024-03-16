package stellarburgers;

import io.restassured.response.Response;

public class LoginAPI extends BaseHttpClient{
    private final static String apiPath = "/api/auth/login";
    public static Response loginUser(User user) {
        return doPostRequest(apiPath, user);
    }
}
