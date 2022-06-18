package com.example.liststreet.seeder;

import com.example.liststreet.entity.District;
import com.example.liststreet.entity.Street;
import com.example.liststreet.entity.enums.StreetStatus;
import com.example.liststreet.repository.StreetRepository;
import com.example.liststreet.util.NumberUtil;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class StreetSeeder {
    public static final int NUMBER_OF_STREET = 50;
    public static List<Street> streets;
    @Autowired
    StreetRepository streetRepository;

    public void generateStreet(){
        log.debug("----------------seeding product-------------------------");
        streetRepository.deleteAll();
        log.debug("----------------clear product-------------------------");

        Faker faker = new Faker();
        streets = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STREET; i++) {
            int randomUserIndex = NumberUtil.getRandomNumber(0, DistrictSeeder.districts.size() - 1);
            District district = DistrictSeeder.districts.get(randomUserIndex);
            streetRepository.save(Street.builder()
                    .id(UUID.randomUUID().toString())
                    .streetName(faker.name().name())
                    .districtId(district.getId())
                    .foundingDate(faker.date().birthday())
                    .description(faker.lorem().sentence(150))
                    .status(StreetStatus.USING)
                    .build());
        }
        log.debug("----------------End seeding product-------------------------");
    }
}
