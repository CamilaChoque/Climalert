package ar.utn.ba.ddsi.Service.Impl;

import ar.utn.ba.ddsi.Service.EmailService;
import ar.utn.ba.ddsi.dto.MensajeEnviadoResponse;
import ar.utn.ba.ddsi.models.Email;
import ar.utn.ba.ddsi.models.RegistroClimatico;
import ar.utn.ba.ddsi.repositories.EmailRepository;

import java.time.LocalDateTime;
import java.util.List;

public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public MensajeEnviadoResponse enviarAlerta(String asunto, RegistroClimatico registro){
        List<Email> destinatarios = emailRepository.obtenerDestinatarios();
        String mensaje = armarMensaje(registro);
        destinatarios.stream().forEach(d->{
                System.out.println("Enviando correo a: " + d.getEmail());
                    d.recibirAlerta(asunto,mensaje);
            }
        );

        return new MensajeEnviadoResponse(
                asunto,
                "Mensajes enviados correctamente",
                LocalDateTime.now()
        );
    }
    private String armarMensaje(RegistroClimatico registro){
        return String.format("""              
                    Detalle del Clima detectado
                    Fecha y Hora: %s,
                    Temperatura: %.1f °C
                    Humedad: %d%%
            """,
                registro.getFecha(),
                registro.getTemperatura(),
                registro.getHumedad()
        );
    }
}
