package com.example.liststreet.api;

import com.example.liststreet.seeder.Applicationseeder;
import com.example.liststreet.seeder.DistrictSeeder;
import com.example.liststreet.seeder.StreetSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Generated;

@RestController
@RequestMapping(path = "seed/generate")
public class seedApi {
    @Autowired
    DistrictSeeder districtSeeder;
    @Autowired
    StreetSeeder streetSeeder;
    @RequestMapping(method = RequestMethod.GET)
    public void Generate(){
        System.out.printf("---------Start Seed DATA------------");
        districtSeeder.generatedistrict();
        streetSeeder.generateStreet();
        System.out.printf("---------End Seed DATA------------");
    }


}
