package stellarburgers;

import io.restassured.response.Response;

public class UserAPI extends BaseHttpClient{
    private final static String apiPath = "/api/auth/user";
    public static Response deleteUser(String accessToken) {
        return doDeleteRequest(apiPath, accessToken);
    }
}
