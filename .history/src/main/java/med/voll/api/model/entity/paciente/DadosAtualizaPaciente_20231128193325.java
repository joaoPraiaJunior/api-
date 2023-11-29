package med.voll.api.model.entity.paciente;

import jakarta.validation.Valid;
import med.voll.api.model.entity.endereco.DadosEndereco;

public record DadosAtualizaPaciente(
    Long id,
    String nome,
    String telefone,
    @Valid DadosEndereco endereco
) {
}