/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class OrderDetailDTO {

    private int detailID;
    private int orderID;
    private int roomID;
    private Date checkin;
    private Date checkout;
    private int numOfDate;
    private double price;

    public OrderDetailDTO(int detailID, int orderID, int roomID, Date checkin, Date checkout, int numOfDate, double price) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.roomID = roomID;
        this.checkin = checkin;
        this.checkout = checkout;
        this.numOfDate = numOfDate;
        this.price = price;
    }

    public OrderDetailDTO(int detailID, int orderID, int roomID, double price) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.roomID = roomID;
        this.price = price;
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

    public int getNumOfDate() {
        return numOfDate;
    }

    public void setNumOfDate(int numOfDate) {
        this.numOfDate = numOfDate;
    }

    public OrderDetailDTO() {
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
