package pl.piotrcz.newSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.piotrcz.newSpring.models.SimpleBean;

import java.time.LocalDateTime;

/**
 * Created by Piotr Czubkowski on 2017-05-27.
 */
@Controller
public class MainController {

    @Autowired
    SimpleBean simpleBean;


//    @RequestMapping("/Piotr")
//    @RequestMapping(value = "/", method = RequestMethod.POST )
//    @ResponseBody
//    public String main(){
//        return "<b>Hello POST</b>";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
    public String mainGet(Model model) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Time now" + now.toString());

        if (now.getHour() >= 16) {
            model.addAttribute("someString", "a");
        } else {
            model.addAttribute("someString", "b");
        }
        return "index";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public String data(@RequestParam(value = "name") String name,
                       @RequestParam(value = "lastName") String lastName,
                       @RequestParam(value = "age", required = false) int age) {
        return name + " " + lastName + " Jest " + ((age > 17) ? " pelnoletni" : " niepelnoletni");
    }

}
