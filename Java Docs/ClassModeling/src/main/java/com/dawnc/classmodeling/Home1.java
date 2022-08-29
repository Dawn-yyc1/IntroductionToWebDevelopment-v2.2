/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.classmodeling;

/**
 *
 * @author pisce
 */
public class Home1 {

       
    private String latitude;
    private String longitude;
    private Address address;
    
    /*methods
    public void curentLocation (Location location){
        
    }
    
    public void directionsToPlace(Location location){
        
    }
    
    public void roadsToLocation (Location location) {
        
    }
    */


    //getter/setters
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
