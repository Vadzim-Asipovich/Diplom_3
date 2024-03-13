package stellarburgers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseHttpClient {

    private static RequestSpecification baseRequest(String accessToken) {
        return new RequestSpecBuilder()
                .setBaseUri(URL.HOST)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", accessToken)
                .build();
    }

    protected static Response doPostRequest(String path, User body) {
        return given()
                .spec(baseRequest(""))
                .body(body)
                .post(path)
                .thenReturn();
    }

    protected static Response doDeleteRequest(String path, String accessToken) {
        return given()
                .spec(baseRequest(accessToken))
                .delete(path)
                .thenReturn();
    }
}