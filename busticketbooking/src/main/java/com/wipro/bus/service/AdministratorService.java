package com.wipro.bus.service;

import com.wipro.bus.entities.Administrator;
import java.util.List;

public interface AdministratorService {
    Administrator registerAdministrator(Administrator administrator);
    Administrator loginAdministrator(String email, String password);

}
