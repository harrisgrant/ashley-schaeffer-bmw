package com.claim.ashleyschaefferbmw.repository;

import com.claim.ashleyschaefferbmw.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

   List<Vehicle> findAll();
   Vehicle findVehicleByVinNum(Long vinNum);
   List<Vehicle> findVehicleByMake(String make);
   List<Vehicle> findVehicleByModel(String model);
   List<Vehicle> findVehicleByYear(Integer year);
    }

