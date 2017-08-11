package me.anna.NIFB.controllers;

import me.anna.NIFB.models.FizzBuzz;
import me.anna.NIFB.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    // Show Welcome Page
    @GetMapping("/")
    public String showWelcome(Model model)
    {
        String myMessage = "Welcome to The New and Improved Fizz Buzz!";
        model.addAttribute("message", myMessage);
        return "welcome";
    }


    @GetMapping("/play")
    public String startPlay(Model model)
    {
        model.addAttribute("user",new User());
      //  model.addAttribute("fizzbuzz",new FizzBuzz());
        return "play";
    }

    @PostMapping("/play")
   // public String showResult(@Valid @ModelAttribute("user, nifb") User user, FizzBuzz nifb, BindingResult result)
   public String showResult(@Valid @ModelAttribute("user") User user, BindingResult result, @ModelAttribute("fizzbuzz") FizzBuzz fizzbuzz)
//    public String showResult(@Valid @ModelAttribute("user") User user, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "play";
        }

        user.setFizzString(user.getNumber());

        System.out.print("This is a string of numbers; " + user.getFizzString()); //fizzbuzz.setFizzBuzz(user.getNumber()));  //+ user.getFizzString());


        return "result";
    }





}