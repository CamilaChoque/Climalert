package ar.utn.ba.ddsi.Service.Impl;

import ar.utn.ba.ddsi.Service.EmailService;
import ar.utn.ba.ddsi.models.RegistroClimatico;

public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }
    public void enviarAlerta(String asunto, RegistroClimatico registro){

    }
}
