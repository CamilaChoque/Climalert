package ar.utn.ba.ddsi.Service.Impl;

import ar.utn.ba.ddsi.Service.EmailService;

public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }
    public void enviarAlerta(String asunto,String detalleClima){

    }
}
