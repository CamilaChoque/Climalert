package ar.utn.ba.ddsi.repositories.inMemory;

import ar.utn.ba.ddsi.models.Email;
import java.util.List;

public class EmailInMemoryStore {
    private final List<EmailModel> destinatariosModel = List.of(
            new EmailModel("1", "admin@clima.com"),
            new EmailModel("2", "emergencias@clima.com"),
            new EmailModel("3", "meteorologia@clima.com")
    );

    List<Email> obtenerDestinatarios(){
        List<Email> destinatarios = destinatariosModel.stream().map(this::toDomain).toList();
        return destinatarios;
    }
    private EmailModel toModel(Email email) {
        return new EmailModel(
                email.getId(),
                email.getEmail()
        );
    }

    private static class EmailModel {
        private String id;
        private String email;

        private EmailModel(String id,String email) {
            this.id=id;
            this.email=email;
        }
    }

    private Email toDomain(EmailModel model) {
        return new Email(
                model.id,
                model.email
        );
    }
}
