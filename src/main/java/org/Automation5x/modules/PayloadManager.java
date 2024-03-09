package org.Automation5x.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.Automation5x.payloads.Auth;
import org.Automation5x.payloads.Booking;
import org.Automation5x.payloads.Bookingdates;

public class PayloadManager {
    ObjectMapper bjectMapper;
    //JAVA -- >JSON

    public String createPayload(){
        Faker faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname("Brown");
        booking.setTotalprice(555);
        booking.setDepositpaid(true);
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-05-20");
        bookingdates.setCheckout("2024-05-26");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking);

        //Object -- > JSOn Styring (GSON);++
        Gson gson= new Gson();
        String JsonStringBooking = gson.toJson(booking);
        System.out.println(JsonStringBooking);

        return JsonStringBooking;


    }
    public Booking JsonToObjectPut(String jsonString) throws JsonProcessingException {
        bjectMapper = new ObjectMapper();
        Booking bookingresponse = bjectMapper.readValue(jsonString,Booking.class);
    return bookingresponse;
    }

    public String setToken() throws JsonProcessingException {
        ObjectMapper bjectMapper = new ObjectMapper();
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");


        return bjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(auth);

    }
    public String UpdatePayload(){
        Faker faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname("Gurpreet");
        booking.setLastname("Brown");
        booking.setTotalprice(555);
        booking.setDepositpaid(true);
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-05-20");
        bookingdates.setCheckout("2024-05-26");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking);

        //Object -- > JSOn Styring (GSON);++
        Gson gson= new Gson();
        String JsonStringBooking = gson.toJson(booking);
        System.out.println(JsonStringBooking);

        return JsonStringBooking;


    }

}
