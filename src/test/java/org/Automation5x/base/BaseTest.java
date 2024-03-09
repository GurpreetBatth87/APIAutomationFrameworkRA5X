package org.Automation5x.base;

import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.Automation5x.Action.AssertActions;
import org.Automation5x.endpoints.APIConstants;
import org.Automation5x.modules.PayloadManager;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public RequestSpecification requestSpecification;

    public AssertActions assertActions;

    public PayloadManager payloadManager;

    public JsonPath jsonpath;

    public Response response;

    public ValidatableResponse validatableResponse;

    @BeforeMethod(alwaysRun = true)
    public void setConfig(){
        System.out.println("I am able to run");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification=RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON);

//        requestSpecification = new RequestSpecBuilder()
//                .setBasePath(APIConstants.BASE_URL)
//                .addHeader("Content-Type","application/json")
//                .build().log().all();
    }


public String getToken() throws JsonProcessingException {
        requestSpecification= RestAssured.given().baseUri(APIConstants.BASE_URL).basePath("/auth");

        String payload = payloadManager.setToken();
        response =  requestSpecification.contentType(ContentType.JSON)

        .body(payload).when().post();
        jsonpath = new JsonPath(response.asString());
        return jsonpath.getString("token");
}

}
