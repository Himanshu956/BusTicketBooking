package com.wipro.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.bus.entities.Administrator;
import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.entities.User;
import com.wipro.bus.service.AdministratorService;
import com.wipro.bus.service.BusOperatorService;
import com.wipro.bus.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {

	
	
    @Autowired
    private AdministratorService administratorService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BusOperatorService busOperatorService;

    @PostMapping("/register")
    public ResponseEntity<Administrator> registerAdministrator(@Valid @RequestBody Administrator administrator) {
        try {
            Administrator registeredAdministrator = administratorService.registerAdministrator(administrator);
            return ResponseEntity.ok(registeredAdministrator);
        } catch (RuntimeException e) {
            // Log the error for debugging purposes
            // e.g., log.error("Error registering administrator: ", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Administrator> loginAdministrator(@RequestParam String email, @RequestParam String password) {
        try {
            Administrator administrator = administratorService.loginAdministrator(email, password);
            return ResponseEntity.ok(administrator);
        } catch (RuntimeException e) {
            // Log the error for debugging purposes
            // e.g., log.error("Error logging in administrator: ", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/bus-operators")
    public ResponseEntity<BusOperator> addBusOperator(@Valid @RequestBody BusOperator busOperator) {
        try {
            BusOperator addedBusOperator = administratorService.addBusOperator(busOperator);
            return ResponseEntity.ok(addedBusOperator);
        } catch (RuntimeException e) {
            // Log the error for debugging purposes
            // e.g., log.error("Error adding bus operator: ", e);
            return ResponseEntity.badRequest().body(null);
        }
    }



    @DeleteMapping("/deleteBusOperator")
    public ResponseEntity<Void> deleteBusOperator(@RequestParam String email) {
        try {
            boolean isDeleted = busOperatorService.deleteBusOperator(email);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            // Log the error for debugging purposes
            // e.g., log.error("Error deleting bus operator: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/deleteUser")
    public ResponseEntity<Void> deleteUser(@RequestParam String email) {
        try {
            boolean isDeleted = userService.deleteUserByEmail(email);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            // Log the error for debugging purposes
            // e.g., log.error("Error deleting user: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

