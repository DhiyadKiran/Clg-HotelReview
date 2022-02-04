package com.example.hotelreview.Model;

import android.media.Rating;

public class HomeHotel {
  private   int HotelImage ;
  private  String HotelName,HotelRatingNumber;
  private Float  HotelRating;

  public HomeHotel(int hotelImage, String hotelName, Float hotelRating, String hotelRatingNumber) {
    HotelImage = hotelImage;
    HotelRatingNumber = hotelRatingNumber;
    HotelName = hotelName;
    HotelRating = hotelRating;
  }

  public int getHotelImage() {
    return HotelImage;
  }

  public void setHotelImage(int hotelImage) {
    HotelImage = hotelImage;
  }

  public String getHotelRatingNumber() {
    return HotelRatingNumber;
  }

  public void setHotelRatingNumber(String hotelRatingNumber) {
    HotelRatingNumber = hotelRatingNumber;
  }

  public String getHotelName() {
    return HotelName;
  }

  public void setHotelName(String hotelName) {
    HotelName = hotelName;
  }

  public Float getHotelRating() {
    return HotelRating;
  }

  public void setHotelRating(Float hotelRating) {
    HotelRating = hotelRating;
  }
}
