package com.troy.saferadmin;

public class ordermodel {


    public ordermodel(String adult, String children, String details, String email, String food, String hotelorder, String name, String time, String nights, String phone) {
        this.adult = adult;
        this.children = children;
        this.details = details;
        this.email = email;
        this.food = food;
        this.hotelorder = hotelorder;
        this.name = name;
        this.time = time;
        this.nights = nights;
        this.phone = phone;
    }



    public String getFood() {
        return food;
    }

    public String getHotelorder() {
        return hotelorder;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getNights() {
        return nights;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdult() {
        return adult;
    }

    public String getChildren() {
        return children;
    }

    public String getDetails() {
        return details;
    }

    public String getEmail() {
        return email;
    }

    public ordermodel() {
    }

    String hotelorder;
    String name;
    String time;
    String nights;
    String phone;
    String adult;
    String children;
    String details;
    String food;
    String email;
}
