package com.example.lab04;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {
    @RequestMapping(path = "/plus/{a}/{b}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("a") double a, @PathVariable("b") double b){
        return a + b;
    }
    @RequestMapping(path = "/minus/{a}/{b}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("a") double a, @PathVariable("b") double b){
        return a - b;
    }
    @RequestMapping(path = "/divide/{a}/{b}", method = RequestMethod.GET)
    public double myDivide(@PathVariable("a") double a, @PathVariable("b") double b)  {
        return a / b;
    }
    @RequestMapping(path = "/multiply/{a}/{b}", method = RequestMethod.GET)
    public double myMulti(@PathVariable("a") double a, @PathVariable("b") double b)  {
        return a * b;
    }
    @RequestMapping(path = "/mod/{a}/{b}", method = RequestMethod.GET)
    public double myMod(@PathVariable("a") double a, @PathVariable("b") double b)  {
        return a % b;
    }
    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestBody Maxie a)  {
        double max = Math.max(a.getA(), a.getB());
        return max + "";
    }
}
