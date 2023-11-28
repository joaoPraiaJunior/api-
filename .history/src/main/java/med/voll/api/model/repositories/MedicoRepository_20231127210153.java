package med.voll.api.model.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.entity.medico.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
    
}
