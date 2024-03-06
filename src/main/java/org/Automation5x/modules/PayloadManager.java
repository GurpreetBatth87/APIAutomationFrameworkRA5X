package org.Automation5x.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.Automation5x.payloads.Booking;
import org.Automation5x.payloads.Bookingdates;

public class PayloadManager {
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

}
