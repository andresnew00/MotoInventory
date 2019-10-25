package com.trilogy.motorcycleservice.dao;

import com.trilogy.motorcycleservice.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorcycleDao extends JpaRepository<Motorcycle, Long> {
    List<Motorcycle> getAllMotorcycles();

}
