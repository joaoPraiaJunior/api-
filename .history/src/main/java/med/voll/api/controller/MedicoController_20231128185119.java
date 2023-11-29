package med.voll.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.entity.medico.DadosAtualizaMedico;
import med.voll.api.model.entity.medico.DadosCadastroMedico;
import med.voll.api.model.entity.medico.DadosListagemMedico;
import med.voll.api.model.entity.medico.Medico;
import med.voll.api.model.repositories.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {


    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    ResponseEntity<String> cadastrar(@Valid @RequestBody DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
        return ResponseEntity.ok("Médico cadastrado com sucesso");
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort ={"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    ResponseEntity<String> atualizar(@Valid @RequestBody DadosAtualizaMedico dados) {
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
        return ResponseEntity.ok("Médico atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    @Transactional
    ResponseEntity<String> deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Médico deletado com sucesso");
    }
}
