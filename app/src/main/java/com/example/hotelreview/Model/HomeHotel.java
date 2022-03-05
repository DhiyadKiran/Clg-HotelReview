package com.example.hotelreview.Model;

import android.media.Rating;

public class HomeHotel {
  String id,name,city,rating,mainimage;

  public HomeHotel(String id, String name, String city, String rating, String mainimage) {
    this.id = id;
    this.name = name;
    this.city = city;
    this.rating = rating;
    this.mainimage = mainimage;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getMainimage() {
    return mainimage;
  }

  public void setMainimage(String mainimage) {
    this.mainimage = mainimage;
  }
}
