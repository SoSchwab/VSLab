package com.fancyapp.fancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@Controller
public class CarController {


    @Autowired
    CarRepo carRepository;

    @RequestMapping("/car/{id}")
    public String car(@PathVariable String id, Model model){
        model.addAttribute("car", carRepository.findOne(id));
        return "car";
    }

    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public String carsList(Model model){
        model.addAttribute("cars", carRepository.findAll());
        return "website/cars";
    }

    @RequestMapping(value = "/savecar", method = RequestMethod.POST)
    public String saveCar(@RequestParam("licensePlate") String licensePlate, @RequestParam("brand") String brand, HttpServletRequest request) {
        Car car = new Car(licensePlate, brand);
        System.out.println(licensePlate);
        System.out.println(brand);
        carRepository.save(car);
        System.out.println("test");
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
        //return "Saved car " + licensePlate + ", " + brand;
    }


}



