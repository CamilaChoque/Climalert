package ar.utn.ba.ddsi.models;

import lombok.Getter;

import java.time.LocalDateTime;

public class RegistroClimatico {
    @Getter
    private String id;
    @Getter
    private LocalDateTime fecha;
    @Getter
    private Double temperatura;
    @Getter
    private Double humedad;

    public RegistroClimatico(String id,LocalDateTime fecha,Double temperatura, Double humedad) {
        this.id=id;
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.fecha = fecha;
    }
}
