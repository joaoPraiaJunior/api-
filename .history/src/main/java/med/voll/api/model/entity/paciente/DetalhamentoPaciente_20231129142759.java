package med.voll.api.model.entity.paciente;

import med.voll.api.model.entity.endereco.Endereco;

public record DetalhamentoPaciente(
    Long id,
    String nome,
    String telefone,
    Endereco endereco
) {
    
}
