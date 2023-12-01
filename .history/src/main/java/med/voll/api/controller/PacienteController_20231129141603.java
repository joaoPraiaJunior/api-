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
import med.voll.api.model.entity.paciente.DadosAtualizaPaciente;
import med.voll.api.model.entity.paciente.DadosCadastroPaciente;
import med.voll.api.model.entity.paciente.DadosListagemPaciente;
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

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(
            @PageableDefault(page = 0, size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    ResponseEntity<String> atualizar(@Valid @RequestBody DadosAtualizaPaciente dados) {
        Paciente paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok("Paciente atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    @Transactional
    ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            Paciente paciente = repository.getReferenceById(id);
            paciente.inativar();
            return ResponseEntity.ok("Paciente deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível deletar o paciente");
        }
    }
}
