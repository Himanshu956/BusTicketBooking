package com.wipro.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.service.BusOperatorService;

import java.util.List;

@RestController
@RequestMapping("/api/busOperators")
public class BusOperatorController {

    @Autowired
    private BusOperatorService busOperatorService;

    @PostMapping("/login")
    public ResponseEntity<BusOperator> loginBusOperator(@RequestParam String email, @RequestParam String password) {
        try {
            BusOperator busOperator = busOperatorService.loginBusOperator(email, password);
            return ResponseEntity.ok(busOperator);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    
}
