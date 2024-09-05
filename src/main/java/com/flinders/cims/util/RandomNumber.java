package com.flinders.cims.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumber {

    public int generateRandomNumber() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
}
