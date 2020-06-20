package edu.jobs.interfaz;

import edu.jobs.mundo.Aspirante;
import edu.jobs.mundo.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController
{
    @Autowired
    JobRepository repository;

    @RequestMapping("/save")
    public String process()
    {
        repository.save(new Aspirante(
                "Pilar Duque", Profession.COUNTER,
                10, 36, "2145500",
                "static/img/Bill-Clinton.jpg"));

        return "successful";
    }
}
