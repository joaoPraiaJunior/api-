package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.entity.paciente.DadosCadastroPaciente;
import med.voll.api.model.entity.paciente.Paciente;
import med.voll.api.model.repositories.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    ResponseEntity<String> cadastrar(@Valid @RequestBody DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
        return ResponseEntity.ok("Paciente cadastrado com sucesso");
    }
}
