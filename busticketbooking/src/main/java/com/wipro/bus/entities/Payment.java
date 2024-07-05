package com.wipro.bus.entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Long bookingId;
    private String paymentMode;
    private double paymentAmount;
    private String paymentStatus;
    private Date paymentDate;
    
    
//    @OneToOne
//    @JoinColumn(name = "bookingId")
//    private Booking booking;

    // Default constructor
    public Payment() {
    }
    

    // Parameterized constructor
    public Payment(Long bookingId, String paymentMode, double paymentAmount, String paymentStatus, Date paymentDate) {
        this.bookingId = bookingId;
        this.paymentMode = paymentMode;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    // Getters and setters
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}