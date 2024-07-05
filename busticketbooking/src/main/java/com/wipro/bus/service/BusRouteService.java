package com.wipro.bus.service;

import com.wipro.bus.entities.BusRoute;
import java.util.List;

public interface BusRouteService {
    BusRoute addBusRoute(BusRoute busRoute);
    BusRoute updateBusRoute(BusRoute busRoute);
    BusRoute getBusRouteById(Long routeId);
    List<BusRoute> getAllBusRoutes();
    void deleteBusRoute(Long routeId);
    List<BusRoute> searchBusRoutes(String origin, String destination);
}
