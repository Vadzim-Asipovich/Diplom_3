package stellarburgers;

public class UserAPI extends BaseHttpClient{
    private final static String apiPath = "/api/auth/user";
    public static void deleteUser(String accessToken) {
        doDeleteRequest(apiPath, accessToken);
    }
}
