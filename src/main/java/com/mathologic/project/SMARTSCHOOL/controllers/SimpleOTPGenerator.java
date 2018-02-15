package com.mathologic.project.SMARTSCHOOL.controllers;

import java.io.Serializable;
import java.util.Random;

public class SimpleOTPGenerator implements Serializable {

    static char[] OTP(int len){

        String numbers = "0123456789";
        Random rndm_method = new Random();

        char[] otp = new char[len];

        for (int i = 0; i < len; i++) {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
    }

}
