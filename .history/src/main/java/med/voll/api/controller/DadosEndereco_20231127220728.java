package med.voll.api.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "Logradouro é obrigatório")
        String logradouro, 
        @NotBlank(message = "Bairro é obrigatório")
        String bairro, 
        @NotBlank(message = "CEP é obrigatório")
        @Pattern(regexp = "\\d{8}")
        String cep, 
        @NotBlank(message = "Cidade é obrigatório")
        String cidade, 
        @NotBlank(message = "UF é obrigatório")
        String uf, 
        String complemento,
        String numero) {
}
