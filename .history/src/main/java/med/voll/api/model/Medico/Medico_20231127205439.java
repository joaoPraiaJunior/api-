package med.voll.api.model.Medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.controller.Especialidade;

@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String crm;

        @Enumerated(EnumType.STRING)
        private Especialidade especialidade;

        @Embedded
        private Endereco endereco;
}
