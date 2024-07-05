package com.wipro.bus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.repository.BusOperatorRepository;
import com.wipro.bus.service.BusOperatorService;

@Service
public class BusOperatorServiceImpl implements BusOperatorService {

    @Autowired
    private BusOperatorRepository busOperatorRepository;

    @Override
    public BusOperator loginBusOperator(String email, String password) {
        BusOperator busOperator = busOperatorRepository.findByEmail(email);
        if (busOperator != null && busOperator.getPassword().equals(password)) {
            return busOperator;
        }
        throw new RuntimeException("Invalid email or password");
    }

}
