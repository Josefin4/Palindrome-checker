package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
public class Palindrome {

    @GetMapping("/palindrome")
    public String checkingPalindromes(@RequestParam(name="name", required = false, defaultValue = "") String s, Model model) {
        List<String> values = Arrays.asList(s.split("\\s"));

        HashMap<String, Boolean> potentialPalindromes = new HashMap<>();
        for (String string : values) {
            potentialPalindromes.put(string, isPalindrome(string.toLowerCase()));
        }

        model.addAttribute("elements", potentialPalindromes);

        return "greeting";


    }

    private static boolean isPalindrome(String name) {
        StringBuffer stringBuffer = new StringBuffer(name);
        return stringBuffer.reverse().toString().equals(name);
    }



    }
