package com.example.liststreet.seeder;


import com.example.liststreet.entity.District;
import com.example.liststreet.repository.DistrictRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class DistrictSeeder {
    public static final int NUMBER_OF_DISTRICT = 15;
    public static List<District> districts;
    @Autowired
    DistrictRepository districtRepository;

    public void generatedistrict(){
        log.debug("----------------seeding user-------------------------");
        districtRepository.deleteAll();
        log.debug("----------------clear user-------------------------");

        Faker faker = new Faker();
        districts = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_DISTRICT; i++) {
            districtRepository.save(District.builder()
                    .id(UUID.randomUUID().toString())
                    .districtName(faker.name().name())
                    .build());
        }
        log.debug("----------------End seeding user-------------------------");
    }

}
