package com.example.reset;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/password")
public class PasswordResetController {
    
    private Map<String, String> otpStorage = new HashMap<>();

    @PostMapping("/request-otp")
    public String requestOtp(@RequestParam String email) {
        String otp = "123456"; 
        otpStorage.put(email, otp);
        return "OTP sent to " + email;
    }

    @PostMapping("/reset")
    public String resetPassword(@RequestParam String email, @RequestParam String otp, @RequestParam String newPassword) {
        if (otpStorage.containsKey(email) && otpStorage.get(email).equals(otp)) {
            otpStorage.remove(email);
            return "Password reset successful!";
        }
        throw new IllegalArgumentException("Invalid OTP or Email");
    }
}