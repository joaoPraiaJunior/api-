package med.voll.api.model.entity.endereco;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "O logradouro não pode ser vazio")
        String logradouro,

        @NotBlank

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String cidade,

        @NotBlank
        String uf,
        
        String complemento,
        String numero) {
}
