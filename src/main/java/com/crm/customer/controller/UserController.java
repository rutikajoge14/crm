package com.crm.customer.controller;

import com.crm.customer.model.User;
import com.crm.customer.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
   private CustomUserDetailsService service;

    @GetMapping
    public String userSecurity(){
        return "User logged in..." +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Basic HTML with Inline CSS</title>\n" +
                "</head>\n" +
                "<body style=\"background-color:#f2f2f2; font-family: Times new roman;\">\n" +
                "\n" +
                "    <div style=\"\n" +
                "        width: 300px;\n" +
                "        margin: 100px auto;\n" +
                "        padding: 20px;\n" +
                "        border: 2px solid #333;\n" +
                "        border-radius: 8px;\n" +
                "        background-color: #ffffff;\n" +
                "        text-align: center;\n" +
                "    \">\n" +
                "        <h2 style=\"color:#333;\">Hello Spring!</h2>\n" +
                "        <p style=\"color:#555;\">\n" +
                "            This is a basic HTML page in Spring boot.\n" +
                "        </p>\n" +
                "    </div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

    @GetMapping("public/about")
public String about(){
        return "About public page...";
    }


    @PostMapping("admin/register")
    public User createUser(@RequestBody User user){
    return service.createUser(user);
    }
}
