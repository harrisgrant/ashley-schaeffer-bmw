package com.claim.ashleyschaefferbmw.controller;


import com.claim.ashleyschaefferbmw.entity.Vehicle;
import com.claim.ashleyschaefferbmw.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/vehicles/{vinNum}")
    public Vehicle findVehicleByVinNum(@PathVariable Long vinNum){
        return vehicleService.findVehicleByVinNum(vinNum);

    }

    @GetMapping("/vehicles/make/{make}")
    public Vehicle findVehicleByMake(@PathVariable String make){
        return (Vehicle) vehicleService.findVehicleByMake(make);
    }

    @GetMapping("/vehicles/model/{model}")
    public Vehicle findVehicleByModel(@PathVariable String model){
        return (Vehicle) vehicleService.findVehicleByModel(model);
    }

    @GetMapping("/vehicles/year/{year}")
    public Vehicle findVehicleByYear(@PathVariable Integer year){
        return (Vehicle) vehicleService.findVehicleByYear(year);
    }

    @PostMapping("vehicles/{vinNum}")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle, @PathVariable Long vinNum){
        return vehicleService.addVehicle(vehicle);
    }

    @PutMapping("/vehicles/{vinNum}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long vinNum) {
        return vehicleService.updateVehicle(vehicle, vinNum);
    }

   @DeleteMapping("/vehicles/{vinNum}")
   public Boolean deleteVehicle(@PathVariable Long vinNum) {
        return vehicleService.deleteVehicle(vinNum);
   }


}
