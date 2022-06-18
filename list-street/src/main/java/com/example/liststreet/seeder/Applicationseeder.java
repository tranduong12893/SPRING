package com.example.liststreet.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.logging.Logger;

public class Applicationseeder implements CommandLineRunner {
    private static Logger logger = Logger.getLogger(Applicationseeder.class.getSimpleName());
    private boolean createNewSeed = true;
    @Autowired
    StreetSeeder streetSeeder;
    @Autowired
    DistrictSeeder districtSeeder;
    @Autowired
    DistrictSeeder userSeeder;
    public void run(String... args) throws Exception {
        if(createNewSeed){
            districtSeeder.generatedistrict();
            streetSeeder.generateStreet();
        }

    }


}
