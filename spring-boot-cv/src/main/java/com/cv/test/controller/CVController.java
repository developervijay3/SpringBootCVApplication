package com.cv.test.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cv.test.model.Post;

@Controller
public class CVController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Post post) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addNewPost(@Valid Post post, @RequestParam("myFile") MultipartFile myFile,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        try {
            String content = new String(myFile.getBytes());
            // Removing unwanted characters from the file
            content = content.replaceAll("[^\u0000-\u007F\u0900-\u097f]", "");
            model.addAttribute("firstName", post.getFirstName());
            model.addAttribute("lastName", post.getLastName());
            model.addAttribute("country", post.getCountry());
            model.addAttribute("datetimeField", post.getDatetimeField());
            model.addAttribute("cv", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "result";
    }

}