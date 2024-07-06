package com.wipro.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.Booking;
import com.wipro.bus.entities.User;
import com.wipro.bus.exception.EmailAlreadyExistsException;
import com.wipro.bus.repository.BookingRepository;
import com.wipro.bus.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private EntityManager entityManager;
	
    @Override
    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new EmailAlreadyExistsException("Email already exists: " + user.getEmail());
        }
        user.setUserId(null);
        return userRepository.save(user);
    }
    
    @Override
    public User loginUser(String email, String password) {
        // Find user by email
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid email or password");
    }

	@Override
	public User updateProfile(User user) {
		// Update user profile
        return userRepository.save(user);
	}

	@Override
	public List<Booking> viewBookingHistory(Long userId) {
		// Retrieve booking history for the user
        return bookingRepository.findByUserId(userId);
	}

	@Override
	public boolean cancelBooking(Long bookingId) {
		// Find booking by ID
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) {
            bookingRepository.delete(booking);
            return true;
        }
        return false;
	}
	
	@Transactional
	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		 Optional<User> userOptional = userRepository.deleteByEmail(email);
	        if (userOptional.isPresent()) {
	            userRepository.deleteByEmail(email);
	            userRepository.resetAutoIncrement();  // Reset auto-increment value

	            return true;
	        }
	        return false;
	}

	

}
