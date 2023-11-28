package med.voll.api.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank(message = "Nome é obrigatório")
        String nome, 
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email, 
        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{4,6}", message = "CRM inválido")
        String crm, 
        @NotNull(message = "Especialidade é obrigatória")
        Especialidade especialidade,
        DadosEndereco endereco) {

}
