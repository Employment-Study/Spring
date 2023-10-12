package com.itbank.test1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("hello")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("data","spring!!");
        return mav;
    }

    @GetMapping("hell-mvc")
    public ModelAndView helloMBC(@RequestParam("name") String name){
        ModelAndView mav = new ModelAndView("hello-temmplate");
        mav.addObject("name",name);

        return mav;
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
