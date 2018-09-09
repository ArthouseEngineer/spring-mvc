package springmvc.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springmvc.model.Developer;

@Controller
public class DeveloperController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "developer", method = RequestMethod.GET)
    public ModelAndView developer() {
        return new ModelAndView("developer", "command", new Developer());
    }

    @RequestMapping(value = "/addDeveloper", method = RequestMethod.POST)
    public String addDeveloper(@ModelAttribute("mvc-dispatcher") Developer developer, ModelMap model) {

        model.addAttribute("id", developer.getId());
        model.addAttribute("name", developer.getName());
        model.addAttribute("specialty", developer.getSpecialty());
        model.addAttribute("experience", developer.getExperience());

        return "result";
    }
}
