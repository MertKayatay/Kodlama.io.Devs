package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologiesRepository extends JpaRepository<ProgrammingTechnology, Integer> {

}
