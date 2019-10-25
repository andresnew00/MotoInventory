package com.trilogy.motorcycleservice.controller;

import com.trilogy.motorcycleservice.dao.MotorcycleDao;
import com.trilogy.motorcycleservice.model.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/motorcycles")
public class MotorcycleController {

    @Autowired
    MotorcycleDao motorcycleDao;

    @PostMapping
    public Motorcycle createMotorcycle(@RequestBody @Valid Motorcycle motorcycle){
        return motorcycleDao.save(motorcycle);
    }

    @GetMapping("/{id}")
    public Motorcycle readMotorcycle(@PathVariable int id){
        return motorcycleDao.getOne(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public void updateMotorcycle(@PathVariable int id, @RequestBody Motorcycle motorcycle){
        motorcycleDao.save(motorcycle);
    }

    @DeleteMapping("/{id}")
    public void deleteMotorcycle(@PathVariable int id){
        motorcycleDao.deleteById(Long.valueOf(id));
    }

    @GetMapping
    public List<Motorcycle> getAllMotorcycles() {
        return motorcycleDao.getAllMotorcycles();
    }



}
