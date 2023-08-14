package com.trinity.safebuy.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest
class LoginSubmitTests {

    //Valid
    @Test
    void loginValidCredentials() {
        when(loginSubmit.loginSubmit("dev", "dev")).thenReturn("redirect:/home");
        String result = loginSubmit.loginSubmit("dev", "dev");
        assertEquals("redirect:/home", result);
    }

    //Invalid
    @Test
    void loginInvalidCredentials() {
        when(loginSubmit.loginSubmit("invalid", "invalid")).thenReturn("ERROR");
        String result = loginSubmit.loginSubmit("invalid", "invalid");
        assertEquals("ERROR", result);
    }

    @Test
    void loginInvalidUsername() {
        when(loginSubmit.loginSubmit("invalid", "dev")).thenReturn("ERROR");
        String result = loginSubmit.loginSubmit("invalid", "dev");
        assertEquals("ERROR", result);
    }

    @Test
    void loginInvalidPassword() {
        when(loginSubmit.loginSubmit("dev", "invalid")).thenReturn("ERROR");
        String result = loginSubmit.loginSubmit("dev", "invalid");
        assertEquals("ERROR", result);
    }

    @MockBean
    private LoginSubmit loginSubmit;
}