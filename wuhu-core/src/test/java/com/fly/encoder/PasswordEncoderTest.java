package com.fly.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        System.out.println(bcryptEncode("123456"));
        System.out.println(bcryptEncode("123123"));
        System.out.println(bcryptEncode("admin"));
        System.out.println(bcryptEncode("root"));
    }
    public static String bcryptEncode(String password){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePwd = encoder.encode(password);
        return password+":{bcrypt}"+encodePwd;
    }
}
