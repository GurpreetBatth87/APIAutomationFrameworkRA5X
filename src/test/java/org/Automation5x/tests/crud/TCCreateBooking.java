package org.Automation5x.tests.crud;

import io.qameta.allure.Description;
import io.restassured.RestAssured;

import java.lang.* ;

import org.Automation5x.base.BaseTest;
import org.Automation5x.endpoints.APIConstants;
import org.testng.annotations.Test;

public class TCCreateBooking extends BaseTest {
    //Step 1 -- Post
    //URL ---> Base URL + base PAth
    // HEADER
    //BODY
    //Auth-- no

    //Step2
    //Prepare the payload(Object -- > json String)



    //step 3
    //Validation -- Response (JSON String -->object)
    //FirstName
    // Status code
    //Time Respomse
    //@Owner("GURPREET")
    @Description("Verify that the create Booking with the valid payload , Status code 200")
    @Test
    public void testPositivePOSTreq() {
        requestSpecification.basePath(APIConstants.CREATE_PDATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);







    }
}
