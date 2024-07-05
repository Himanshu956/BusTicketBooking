package com.wipro.bus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.BusRoute;
import com.wipro.bus.repository.BusRouteRepository;
import com.wipro.bus.service.BusRouteService;

@Service
public class BusRouteServiceImpl implements BusRouteService {

    @Autowired
    private BusRouteRepository busRouteRepository;

    @Override
    public BusRoute addBusRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public BusRoute updateBusRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public BusRoute getBusRouteById(Long routeId) {
        return busRouteRepository.findById(routeId).orElse(null);
    }

    @Override
    public List<BusRoute> getAllBusRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    public void deleteBusRoute(Long routeId) {
        busRouteRepository.deleteById(routeId);
    }

    @Override
    public List<BusRoute> searchBusRoutes(String origin, String destination) {
        return busRouteRepository.findByOriginAndDestination(origin, destination);
    }
}
