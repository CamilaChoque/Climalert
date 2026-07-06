package ar.utn.ba.ddsi.dto;

import java.time.LocalDateTime;

public record MensajeEnviadoResponse(
        String asunto,
        String desc,
        LocalDateTime fechaEnvio
) {
}
