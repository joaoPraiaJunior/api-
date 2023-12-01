package med.voll.api.model.infra.exception.security;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {
    public String gerarToken() {
        try {
            var algoritmo = Algorithm.HMAC256(secret: "secret");
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token");
        }
    }
}
