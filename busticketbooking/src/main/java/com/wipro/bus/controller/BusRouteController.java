package com.wipro.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.bus.entities.BusRoute;
import com.wipro.bus.service.BusRouteService;

import java.util.List;

@RestController
@RequestMapping("/api/busRoutes")
public class BusRouteController {

    @Autowired
    private BusRouteService busRouteService;

    @PostMapping("/add")
    public ResponseEntity<BusRoute> addBusRoute(@RequestBody BusRoute busRoute) {
        BusRoute addedBusRoute = busRouteService.addBusRoute(busRoute);
        return ResponseEntity.ok(addedBusRoute);
    }

    @PutMapping("/update")
    public ResponseEntity<BusRoute> updateBusRoute(@RequestBody BusRoute busRoute) {
        BusRoute updatedBusRoute = busRouteService.updateBusRoute(busRoute);
        return ResponseEntity.ok(updatedBusRoute);
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<BusRoute> getBusRouteById(@PathVariable Long routeId) {
        BusRoute busRoute = busRouteService.getBusRouteById(routeId);
        if (busRoute != null) {
            return ResponseEntity.ok(busRoute);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<BusRoute>> getAllBusRoutes() {
        List<BusRoute> busRoutes = busRouteService.getAllBusRoutes();
        return ResponseEntity.ok(busRoutes);
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<Void> deleteBusRoute(@PathVariable Long routeId) {
        busRouteService.deleteBusRoute(routeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<BusRoute>> searchBusRoutes(@RequestParam String origin, @RequestParam String destination) {
        List<BusRoute> busRoutes = busRouteService.searchBusRoutes(origin, destination);
        return ResponseEntity.ok(busRoutes);
    }
}
