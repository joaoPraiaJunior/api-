package med.voll.api.model.entity.paciente;

import med.voll.api.model.entity.endereco.Endereco;

public record DadosDetalhamentoPaciente(
    Long id,
    String nome,
    String telefone,
    Endereco endereco
) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(
            paciente.id(),
            paciente.nome(),
            paciente.telefone(),
            paciente.endereco()
        );
    }
    
}
