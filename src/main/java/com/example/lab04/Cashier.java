package com.example.lab04;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(path = "/getChange/{bank}",  method = RequestMethod.GET)
    public Change getChange(@PathVariable("bank") int bank){
        Change moneypocket = new Change();
        moneypocket.setB1000(bank/1000);
        bank %= 1000;
        moneypocket.setB500(bank/500);
        bank %= 500;
        moneypocket.setB100(bank/100);
        bank %= 100;
        moneypocket.setB20(bank/20);
        bank %= 20;
        moneypocket.setB10(bank/10);
        bank %= 10;
        moneypocket.setB5(bank/5);
        bank %= 5;
        moneypocket.setB1(bank);
        return moneypocket;
    }
}
