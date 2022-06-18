package com.example.liststreet.api;

import com.example.liststreet.entity.District;
import com.example.liststreet.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/districts")
public class districtApi {
    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<District>> getList(){
        return ResponseEntity.ok(districtService.findAll());
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<District> optionalUser = districtService.findById(id);
        if(!optionalUser.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalUser.get());
    }


}
