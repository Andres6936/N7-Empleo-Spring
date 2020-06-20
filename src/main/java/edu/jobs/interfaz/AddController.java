package edu.jobs.interfaz;

import edu.jobs.mundo.Profession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add")
public class AddController
{
    @GetMapping
    public String showAddPage(Model model)
    {
        model.addAttribute("professions", Profession.values());

        return "add";
    }
}
