package ar.utn.ba.ddsi.models;

import lombok.Getter;

import java.util.UUID;
import java.util.regex.Pattern;

public class Email {
    @Getter
    private String id;
    @Getter
    private String email;

    //para validar el formato
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );

    public Email(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Error: '" + email + "' tiene un formato inválido.");
        }
        this.id = UUID.randomUUID().toString();
        this.email = email;
    }
    public Email(String id, String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Error: '" + email + "' tiene un formato inválido.");
        }
        this.id = id;
        this.email = email;
    }

}
