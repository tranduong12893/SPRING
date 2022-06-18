package com.example.liststreet.api;

import com.example.liststreet.entity.Street;
import com.example.liststreet.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/streets")
public class streetApi {
    @Autowired
    StreetService streetService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Street>> getList(){
        return ResponseEntity.ok(streetService.findAll());
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<Street> optionalStreet = streetService.findById(id);
        if(!optionalStreet.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalStreet.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> save(@RequestBody Street street){
        return ResponseEntity.ok(streetService.save(street));
    }
}
