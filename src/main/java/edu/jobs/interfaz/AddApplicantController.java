package edu.jobs.interfaz;

import edu.jobs.mundo.Aspirante;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addApplicant")
public class AddApplicantController
{
    @PostMapping
    public String processApplicant(Aspirante aspirante)
    {
        System.out.println(aspirante.getName());

        return "redirect:/";
    }
}
