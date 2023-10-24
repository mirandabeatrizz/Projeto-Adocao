package com.example.registrationlogindemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class AuthRestController { //informação e dados, integraçao

    @RequestMapping("/set-preference")
    public String setPreference(HttpServletResponse response) {
        Cookie preferenceCookie = new Cookie("preference", "darkMode");
        preferenceCookie.setMaxAge(30 * 24 * 60 * 60); // Define a expiração do cookie (30 dias)
        response.addCookie(preferenceCookie);
        return "Preferencias definidas!";
    }

    @RequestMapping("/get-preference")
    public String dashboard(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("preference".equals(cookie.getName())) {
                    String preference = cookie.getValue();
                    return preference;
                }
            }
        }
        return "Não existe cookies";
    }
}
