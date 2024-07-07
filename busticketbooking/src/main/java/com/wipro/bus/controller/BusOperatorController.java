package com.wipro.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.bus.dto.BusOperatorDTO;
import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.service.BusOperatorService;
import com.wipro.bus.service.BusScheduleService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/busOperator")
public class BusOperatorController {

    @Autowired
    private BusOperatorService busOperatorService;

    @Autowired
    private BusScheduleService busScheduleService;

    // Endpoint for Bus Operator login
    @PostMapping("/login")
    public ResponseEntity<BusOperator> loginBusOperator(
            @RequestParam String email,
            @RequestParam String password) {
        try {
            BusOperator busOperator = busOperatorService.loginBusOperator(email, password);
            return ResponseEntity.ok(busOperator);
        } catch (RuntimeException e) {
            // Log the error (optional)
            // log.error("Error logging in bus operator: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }



    // Endpoint to create a new Bus Schedule
    @PostMapping("/createSchedule")
    public ResponseEntity<BusSchedule> createBusSchedule(
            @Valid @RequestBody BusSchedule busSchedule) {
        try {
            BusSchedule createdBusSchedule = busScheduleService.createBusSchedule(busSchedule);
            return ResponseEntity.ok(createdBusSchedule);
        } catch (RuntimeException e) {
            // Log the error (optional)
            // log.error("Error creating bus schedule: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Helper method to convert BusOperatorDTO to BusOperator entity
    private BusOperator convertDTOToEntity(BusOperatorDTO busOperatorDTO) {
        BusOperator busOperator = new BusOperator();
        busOperator.setOperatorId(busOperatorDTO.getOperatorId());
        busOperator.setName(busOperatorDTO.getName());
        busOperator.setEmail(busOperatorDTO.getEmail());
        busOperator.setPassword(busOperatorDTO.getPassword());
        busOperator.setPhoneNumber(busOperatorDTO.getPhoneNumber());
        return busOperator;
    }
}


