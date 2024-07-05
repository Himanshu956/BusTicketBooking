package com.wipro.bus.service;

import com.wipro.bus.entities.BusOperator;
import java.util.List;

public interface BusOperatorService {
    BusOperator loginBusOperator(String email, String password);
    
    //schedule methode...
}
