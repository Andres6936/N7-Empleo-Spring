package edu.jobs.interfaz;

import edu.jobs.mundo.Aspirante;
import edu.jobs.mundo.Profession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController
{
    @GetMapping
    public String showHomepage(Model model)
    {
        model.addAttribute("applicant", new Aspirante(
                "Joan", Profession.SOFTWARE_ENGINEER, 4, 22,
                "319 656 9458", "img/andres.jpg"));

        return "home";
    }
}
