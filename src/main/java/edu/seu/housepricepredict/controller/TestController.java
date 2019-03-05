package edu.seu.housepricepredict.controller;

import edu.seu.housepricepredict.domain.pojo.ValueOfxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {

    @RequestMapping("/barimage")
    public String testbar(){
        return "barimage";
    }

    @RequestMapping("/test")
    public String test(){
        return "linegraphofhistoryprice";
    }

    @RequestMapping("/city")
    public String tocity(){
        return "city";
    }

    @RequestMapping("/ajax")
    @ResponseBody
    public ValueOfxy[] testAjax1(){

        ValueOfxy[] result = new ValueOfxy[5];

        for (int i = 0; i < 5; i++){
            ValueOfxy valueOfxy = new ValueOfxy();
            valueOfxy.setX("" + i);
            valueOfxy.setY1(i);
            valueOfxy.setY2(i + 1);
            result[i] = valueOfxy;
        }

        return result;

    }

    @RequestMapping("/ajax2")
    @ResponseBody
    public String[] testAjax2(){

        String[] result = {"city1"};
//        String result = "city";
        return result;

    }
    @RequestMapping("/ajax3")
    @ResponseBody
    public String[] testAjax3(){
        System.out.println("---------ajax3");
        String[] result = {"city1","city2", "city3"};
//        String result = "city";
        return result;

    }


}
