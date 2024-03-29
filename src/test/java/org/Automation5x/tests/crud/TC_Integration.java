package org.Automation5x.tests.crud;

import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.Automation5x.base.BaseTest;
import org.Automation5x.endpoints.APIConstants;
import org.Automation5x.payloads.Booking;
import org.Automation5x.payloads.Bookingresponse;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MATCHER;


public class TC_Integration extends BaseTest {
    String token;
    String bookingid;
    //create a booking
    //Update the booking with token and booking ID - how to pass the variBLES FROM ONE TREST TO ANOTHER
    //1.AUTH -api KEYS
    //cOOKINGH  vbased Auth Side.
    //auth 2.0 - Method how you use the Auth 2.0
//Delete Also


    //Get a Token
    //  @Test(groups = "P0")
//    public void getToken(){
////         token = getToken();
//        System.out.println(token);
//        System.out.println("_____________________Gurpreet");

    //  assertThat("Gurpreet").isEqualTo("Gurpreet");


    //}


    //Create a Booking
    @Test(groups = "P0")
    public void testCreateBooking() throws JsonProcessingException {
        token = getToken();
        System.out.println(token);
        assertThat(token).isNotNull().isNotEmpty();

        requestSpecification.basePath(APIConstants.CREATE_PDATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        jsonpath = jsonpath.from(response.asString());
        validatableResponse.statusCode(200);
        bookingid = jsonpath.getString("bookingid");
        //  Bookingresponse bookingresponse = payloadManager.JsonToObject(response.asString());
        System.out.println("JSON Booking ID : " + bookingid);

    }


    //Update the booking with token and booking ID
    @Test(groups = "P0", dependsOnMethods = {"testCreateBooking"})
    public void testCreateAndZUpdateBooking() throws JsonProcessingException {
        System.out.println("Create and update booking --->" + token);
        System.out.println(" JSON Create and update booking --->" + bookingid);

        // token = getToken();
        System.out.println(token);
        assertThat(token).isNotNull().isNotEmpty();

        requestSpecification.basePath(APIConstants.CREATE_PDATE_BOOKING + "/" + bookingid);
        response = RestAssured.given().spec(requestSpecification).cookie("token", token)
                .when().body(payloadManager.UpdatePayload()).put();
        validatableResponse = response.then().log().all();
        Booking bookingresponse = payloadManager.JsonToObjectPut(response.asString());

        assertThat(bookingresponse.getFirstname()).isEqualTo("Gurpreet").isNotNull();
        //
        // validatableResponse.body("firstname",MATCHER.hashCode("Gurpreet"));
//        jsonpath =jsonpath.from(response.asString());
//        validatableResponse.statusCode(200);
//        bookingid= jsonpath.getString("bookingid");
//        //  Bookingresponse bookingresponse = payloadManager.JsonToObject(response.asString());
//        System.out.println("JSON Booking ID : " + bookingid);


        //assertThat("Gurpreet").isEqualTo("Gurpreet");
    }

    //Delete Also
    @Test(groups = "P0", dependsOnMethods = {"testCreateAndZUpdateBooking"})
    public void testDeleteCreateBooking() {
        System.out.println("Create and Delete booking --->" + token);

        requestSpecification.basePath(APIConstants.CREATE_PDATE_BOOKING + "/" + bookingid).cookie("token", token);
        validatableResponse = RestAssured.given().spec(requestSpecification).auth().basic("admin", "password123")
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);

    }

    @Test(groups = "P0", dependsOnMethods = {"testDeleteCreateBooking"})
    public void testDeleteCreateBookingbyget() {

        requestSpecification.basePath(APIConstants.CREATE_PDATE_BOOKING + "/" + bookingid);
        response = RestAssured.given().spec(requestSpecification)
                        .when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);


    }
}
