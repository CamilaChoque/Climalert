package ar.utn.ba.ddsi.repositories.inMemory;

import ar.utn.ba.ddsi.models.Email;
import ar.utn.ba.ddsi.repositories.EmailRepository;

import java.util.List;

public class InMemoryEmailRepository implements EmailRepository {
    private final EmailInMemoryStore store;

    public InMemoryEmailRepository(EmailInMemoryStore store) {
        this.store = store;
    }
    @Override
    public List<Email> obtenerDestinatarios(){
        return store.obtenerDestinatarios();
    }

}
