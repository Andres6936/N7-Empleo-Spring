package edu.jobs.interfaz;

import edu.jobs.mundo.Aspirante;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Aspirante, Long>
{
    Aspirante findByName(String name);
}
