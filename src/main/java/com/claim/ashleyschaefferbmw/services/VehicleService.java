package com.claim.ashleyschaefferbmw.services;

import com.claim.ashleyschaefferbmw.entity.Vehicle;
import com.claim.ashleyschaefferbmw.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    public Vehicle findVehicleByVinNum(Long vinNum){
        return vehicleRepository.findVehicleByVinNum(vinNum);
    }

    public List<Vehicle> findVehicleByMake(String make){
        return vehicleRepository.findVehicleByMake(make);
    }

    public List<Vehicle> findVehicleByModel(String model){
        return vehicleRepository.findVehicleByModel(model);
    }

    public List<Vehicle> findVehicleByYear(Integer year){
        return vehicleRepository.findVehicleByYear(year);
    }

    public Vehicle addVehicle(Vehicle vehicle){
        Vehicle newVehicle = new Vehicle(vehicle.getVinNum(), vehicle.getMake(), vehicle.getModel(), vehicle.getYear());
        return vehicleRepository.save(newVehicle);
    }

    public Vehicle updateVehicle(Vehicle vehicle, Long vinNum) {
        Vehicle updateVehicle = vehicleRepository.findVehicleByVinNum(vinNum);
        if(updateVehicle == null ) {
            return null;
        }
        updateVehicle.setVinNum(vehicle.getVinNum());
        updateVehicle.setMake(vehicle.getMake());
        updateVehicle.setModel(vehicle.getModel());
        updateVehicle.setYear(vehicle.getYear());
        return vehicleRepository.save(vehicle);
    }

    public Boolean deleteVehicle(Long vinNum) {
        Vehicle deleteVehicle = vehicleRepository.findVehicleByVinNum(vinNum);
        if(deleteVehicle != null){
            vehicleRepository.delete(deleteVehicle);
        }
        return true;
    }
}
