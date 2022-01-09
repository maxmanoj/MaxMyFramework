package org.CallRestAPI;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class CallRestAPI {

    public static Response CallGetAPI (String url) {

        Response response = given().relaxedHTTPSValidation()
                .get(url);

        return response;
    }

    public static Response CallPostAPI (String URL, JSONObject RequestBody){

        System.out.println(" Request body is --->"+ RequestBody);

        Response response = given().relaxedHTTPSValidation()
                .headers("Content-Type", "application/json")
                .body(RequestBody).when()
                .post(URL);

        return response;
    }

}
