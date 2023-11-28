package med.voll.api.model.entity.endereco;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "O logradouro não pode ser vazio")
        String logradouro,

        @NotBlank(message = "O bairro não pode ser vazio")
        String bairro,

        @NotBlank(message = "O CEP não pode ser vazio")
        @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos")
        String cep,
        @NotBlank(message = "A cidade não pode ser vazia")
        String cidade,

        @NotBlank(message = "O estado não pode ser vazio")
        String uf,
        
        String complemento,
        String numero) {
}
