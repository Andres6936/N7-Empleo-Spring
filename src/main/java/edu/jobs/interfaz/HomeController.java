package edu.jobs.interfaz;

import edu.jobs.mundo.Aspirante;
import edu.jobs.mundo.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController
{
    @Autowired
    ApplicantService applicantService;

    @GetMapping("/show/{id}")
    public String showApplicant(Model model, @PathVariable("id") long id)
    {
        model.addAttribute("applicant", applicantService.getApplicantById(id));

        return "home";
    }

    @GetMapping
    public String showHomepage(Model model)
    {
        model.addAttribute("applicant", new Aspirante(
                "Joan", Profession.SOFTWARE_ENGINEER, 4, 22,
                "319 656 9458", "img/Kevin-Spacey.jpg"));

        return "home";
    }
}
