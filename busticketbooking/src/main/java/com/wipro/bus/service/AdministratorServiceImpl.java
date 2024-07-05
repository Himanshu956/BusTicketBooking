package com.wipro.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.Administrator;
import com.wipro.bus.repository.AdministratorRepository;
import com.wipro.bus.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public Administrator registerAdministrator(Administrator administrator) {
        if (administratorRepository.findByEmail(administrator.getEmail()) != null) {
            throw new RuntimeException("Administrator already exists with this email");
        }
        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator loginAdministrator(String email, String password) {
        Administrator administrator = administratorRepository.findByEmail(email);
        if (administrator != null && administrator.getPassword().equals(password)) {
            return administrator;
        }
        throw new RuntimeException("Invalid email or password");
    }

}
