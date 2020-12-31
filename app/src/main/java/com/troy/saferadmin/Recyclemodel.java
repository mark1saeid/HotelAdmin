package com.troy.saferadmin;
public class Recyclemodel {

    String hotelname;
    String bednum;
    String price;
    String stars;
    String place;
    String imege;

    String food;
    String pools;
    String desc;
    String image1;
    String image2;
    String image3;

    public String getId() {
        return id;
    }

    String id;
    public Recyclemodel(String hotelname, String bednum, String price, String stars, String place, String imege, String food, String pools, String desc, String image1, String image2, String image3 , String id) {
        this.hotelname = hotelname;
        this.bednum = bednum;
        this.price = price;
        this.stars = stars;
        this.place = place;
        this.imege = imege;
        this.food = food;
        this.pools = pools;
        this.desc = desc;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.id = id;
    }



    public String getFood() { return food; }
    public String getPools() { return pools; }
    public String getDesc() { return desc; }
    public String getImage1() { return image1; }
    public String getImage2() { return image2; }
    public String getImage3() { return image3; }
    public String getImege() {
        return imege;
    }
    public String getHotelname() {
        return hotelname;
    }
    public String getBednum() {
        return bednum;
    }
    public String getPrice() {
        return price;
    }
    public String getStars() {
        return stars;
    }
    public String getPlace() {
        return place;
    }




    public Recyclemodel() {
    }










}
