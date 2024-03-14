package stellarburgers;

import io.restassured.response.Response;

public class RegisterAPI extends BaseHttpClient{
    private static final String apiPath = "/api/auth/register";
    public static Response registerUser(User user) {
        return doPostRequest(apiPath, user);
    }
}
