package pl.piotrcz.newSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.piotrcz.newSpring.models.SimpleBean;

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

    @RequestMapping(value = "/", method = RequestMethod.GET )
//    @ResponseBody
    public String mainGet(Model model){
        model.addAttribute("someString", "Pochodze z controllera");
        return "index";
    }

}
