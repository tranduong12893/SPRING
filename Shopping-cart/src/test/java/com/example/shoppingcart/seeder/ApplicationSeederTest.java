package com.example.shoppingcart.seeder;

import com.example.shoppingcart.ShoppingCartApplication;
import com.example.shoppingcart.entity.config.H2JpaConfig;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShoppingCartApplication.class, H2JpaConfig.class})
@ActiveProfiles("test")
class ApplicationSeederTest {


    @Test
    void run() {
        Faker faker = new Faker();
        for (int i = 0; i< 10; i++){
            System.out.println(faker.address().country());
        }
    }
}