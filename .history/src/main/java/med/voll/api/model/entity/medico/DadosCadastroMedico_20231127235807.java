package med.voll.api.model.entity.medico;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.entity.endereco.DadosEndereco;


public record DadosCadastroMedico(
        @NotBlank(message = "O nome não pode ser vazio")
        String nome,

        @NotBlank(message = "O email não pode ser vazio")
        @Email(message = "O email deve ser válido")
        String email,

        @NotBlank(message = "O telefone não pode ser vazio")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}", message = "O CRM deve conter entre 4 e 6 dígitos")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull @Valid DadosEndereco endereco) {

}
