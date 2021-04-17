/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class RoomDTO implements Serializable {
    private int roomID;
    private String name;
    private String description;
    private String typeID;
    private String img;
    private boolean status;
    private boolean Rented;
    private double price;
    private int max;
    private Date checkin;
    private Date checkout;

    public RoomDTO() {
    }

    public RoomDTO(int roomID, String name, String description, String typeID, String img, boolean status, boolean Rented, double price, int max, Date checkin, Date checkout) {
        this.roomID = roomID;
        this.name = name;
        this.description = description;
        this.typeID = typeID;
        this.img = img;
        this.status = status;
        this.Rented = Rented;
        this.price = price;
        this.max = max;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    
    public RoomDTO(String name, String description, String typeID, String img, double price, int max) {
        this.name = name;
        this.description = description;
        this.typeID = typeID;
        this.img = img;
        this.price = price;
        this.max = max;
    }
    
    public RoomDTO(int roomID, String name, String description, String typeID, String img, boolean status, boolean Rented, double price, int max) {
        this.roomID = roomID;
        this.name = name;
        this.description = description;
        this.typeID = typeID;
        this.img = img;
        this.status = status;
        this.Rented = Rented;
        this.price = price;
        this.max = max;
    }

    public RoomDTO(int roomID, String name, String description, String typeID, String img, boolean status, double price, int max) {
        this.roomID = roomID;
        this.name = name;
        this.description = description;
        this.typeID = typeID;
        this.img = img;
        this.status = status;
        this.price = price;
        this.max = max;
    }
    

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    
    public boolean isRented() {
        return Rented;
    }

    public void setRented(boolean Rented) {
        this.Rented = Rented;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String décription) {
        this.description = décription;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

}
