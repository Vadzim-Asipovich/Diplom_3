package stellarburgers;

import io.restassured.response.Response;

public class RegisterAPI extends BaseHttpClient{
    private final String apiPath = "/api/auth/register";
    public Response registerUser(User user) {
        return doPostRequest(apiPath, user);
    }
}
