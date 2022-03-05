package com.example.hotelreview.Model;

public class AllDetail {
    int id,price;
    String name,city,rating,number,address,venuetype,facility,about,mainimage,bgimage,images;

    public AllDetail(int id, int price, String name, String city, String rating, String number, String address, String venuetype, String facility, String about, String mainimage, String bgimage, String images) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.city = city;
        this.rating = rating;
        this.number = number;
        this.address = address;
        this.venuetype = venuetype;
        this.facility = facility;
        this.about = about;
        this.mainimage = mainimage;
        this.bgimage = bgimage;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVenuetype() {
        return venuetype;
    }

    public void setVenuetype(String venuetype) {
        this.venuetype = venuetype;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getMainimage() {
        return mainimage;
    }

    public void setMainimage(String mainimage) {
        this.mainimage = mainimage;
    }

    public String getBgimage() {
        return bgimage;
    }

    public void setBgimage(String bgimage) {
        this.bgimage = bgimage;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
