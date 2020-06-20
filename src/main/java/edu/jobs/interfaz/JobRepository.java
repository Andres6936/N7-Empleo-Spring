package edu.jobs.interfaz;

import edu.jobs.mundo.Aspirante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Aspirante, Long>
{
    List<Aspirante> findByName(String name);
}
