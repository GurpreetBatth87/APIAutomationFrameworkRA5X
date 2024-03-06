package org.Automation5x.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
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

    @BeforeMethod
    public void setConfig(){
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBasePath(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();
    }




}
