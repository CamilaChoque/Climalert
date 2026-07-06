package ar.utn.ba.ddsi.repositories;

import ar.utn.ba.ddsi.models.Email;

import java.util.List;

public interface EmailRepository {
    List<Email> obtenerDestinatarios();
}
