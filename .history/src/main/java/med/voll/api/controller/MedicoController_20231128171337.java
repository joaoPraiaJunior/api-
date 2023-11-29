package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.entity.medico.DadosCadastroMedico;
import med.voll.api.model.entity.medico.Medico;
import med.voll.api.model.repositories.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {


    @GetMapping
    ResponseEntity<String> listar() {
        return ResponseEntity.ok("Listando médicos");
    }


    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    ResponseEntity<String> cadastrar(@Valid @RequestBody DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
        return ResponseEntity.ok("Médico cadastrado com sucesso");
    }

}
