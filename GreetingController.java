package com.example.handlingformsubmission;
//File imports within the Greeting form
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//Controller method to handle the HTTPS requests.
//Primary class for greeting controller on webpage.
@Controller
public class GreetingController {
    //Get mapping method getting the specific requests.
    @GetMapping("/greeting")
    //Adds the populated Greeting object to the model
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
    //Post mapping method to handle the post request.
    @PostMapping("/greeting")
    //Adds the populated Greeting object to the model
    //Adds a date format exception to restrict user in invalid entry.
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        String inputDate = greeting.getDate();
        //date formater
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        // Date expectations using the try and catch blocks/
        try {
            LocalDate.parse(inputDate, formatter);
            model.addAttribute("greeting", greeting);
            return "result";
            //Catch the exception
        } catch (DateTimeParseException e) {
            model.addAttribute("errorMessage", "Invalid date.");
            model.addAttribute("greeting", greeting);
            return "greeting";
        }
    }
}
