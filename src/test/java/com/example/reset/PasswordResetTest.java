package com.example.reset;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordResetTest {

    @Test
    void testInvalidResetAttempt() {
        PasswordResetController controller = new PasswordResetController();
        controller.requestOtp("user@test.com");

        // Use wrong OTP "999999" to trigger failure
        assertThrows(IllegalArgumentException.class, () -> {
            controller.resetPassword("user@test.com", "999999", "newPass");
        });
    }
}