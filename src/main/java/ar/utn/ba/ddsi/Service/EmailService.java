package ar.utn.ba.ddsi.Service;

import ar.utn.ba.ddsi.dto.MensajeEnviadoResponse;
import ar.utn.ba.ddsi.models.RegistroClimatico;

public interface EmailService {
    MensajeEnviadoResponse enviarAlerta(String asunto, RegistroClimatico detalleClima);
}
