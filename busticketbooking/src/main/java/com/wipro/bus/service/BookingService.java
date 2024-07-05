package com.wipro.bus.service;

import com.wipro.bus.entities.Booking;
import java.util.List;

public interface BookingService {
    Booking makeBooking(Booking booking);
    Booking getBookingById(Long bookingId);
    List<Booking> getAllBookings();
    List<Booking> getBookingsByUserId(Long userId);
    void cancelBooking(Long bookingId);
}
