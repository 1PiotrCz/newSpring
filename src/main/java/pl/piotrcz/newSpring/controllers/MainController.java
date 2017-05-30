package pl.piotrcz.newSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.piotrcz.newSpring.models.Forms.PersonForm;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Created by Piotr Czubkowski on 2017-05-27.
 */
@Controller
public class MainController {

    // Logger logger = Logger.getLogger(MainController.class);

//    @Autowired
//    SimpleBean simpleBean;


//    @RequestMapping("/Piotr")
//    @RequestMapping(value = "/", method = RequestMethod.POST )
//    @ResponseBody
//    public String main(){
//        return "<b>Hello POST</b>";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
    public String mainGet(Model model) {

//        ZonedDateTime now = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris"));

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

    @RequestMapping(value = "/newform", method = RequestMethod.GET)
    public String newform(Model model) {
        model.addAttribute("personObject", new PersonForm());
        return "form";
    }

    @RequestMapping(value = "/newform", method = RequestMethod.POST)
    public String newformPost(@ModelAttribute("personObject") @Valid PersonForm personForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        return "result";
//        return "Przyszla klasa: " + personForm.getName();
    }

//
//    @RequestMapping(value = "/newformcontact", method = RequestMethod.GET)
//    public String newformcontact(Model model) {
//        model.addAttribute("personObject", new PersonForm());
//        return "contact";
//    }
//
//    @RequestMapping(value = "/contact", method = RequestMethod.POST)
//    public String contact(Model model) {
//        model.addAttribute("personObject", new PersonForm());
//        return "contact";
//    }


    private void testBuilder() {
        PersonForm personForm = new PersonForm.Builder("Piotr")
                .lastname("Czubkowski")
                .age(27)
                .email("piotrcz@tlen.pl")
                .number("123-456-789")
                .build();

        personForm.getAge();
        ;
    }

}
