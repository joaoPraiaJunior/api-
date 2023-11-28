package med.voll.api.controller;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroMedico(
        @NotNull
        String nome, 
        String email, 
        String crm, 
        Especialidade especialidade,
        DadosEndereco endereco) {

}
