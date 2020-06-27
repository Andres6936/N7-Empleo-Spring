package edu.jobs.interfaz;

import edu.jobs.mundo.Aspirante;
import edu.jobs.mundo.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantService
{
    @Autowired
    JobRepository repository;

    @RequestMapping("/save")
    public String process()
    {
        repository.save(new Aspirante(
                "Pilar Duque", Profession.COUNTER,
                10, 36, "2145500",
                "img/Bill-Clinton.jpg"));

        repository.save(new Aspirante("Carlos Méndez", Profession.SOFTWARE_ENGINEER,
                5, 31, "2669966",
                "img/Christopher-Nolan.jpg"));

        repository.save(new Aspirante("Andrés Pérez", Profession.ADMINISTRATOR,
                1, 25, "4296831",
                "img/Gordon-Ramsay.jpg"));

        repository.save(new Aspirante("Marcela Otero", Profession.ADMINISTRATOR,
                3, 29, "2174157",
                "img/Jennifer-Lawrence.jpg"));

        repository.save(new Aspirante("Jorge Campos", Profession.SOFTWARE_ENGINEER,
                8, 40, "2774589",
                "img/Kevin-Spacey.jpg"));

        repository.save(new Aspirante("Ana Rojas", Profession.ECONOMIST,
                1, 22, "3526478",
                "img/Kate-Mara.jpg"));

        repository.save(new Aspirante("Juan Rodríguez", Profession.INDUSTRIAL_ENGINEER,
                6, 32, "4158877",
                "img/Liam-Neeson.jpg"));

        return "successful";
    }

    public Aspirante getApplicantByName(String name)
    {
        return repository.findByName(name);
    }

    public Aspirante getApplicantById(long id)
    {
        return repository.findById(id).get();
    }
}
