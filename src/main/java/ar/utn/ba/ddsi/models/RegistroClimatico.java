package ar.utn.ba.ddsi.models;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistroClimatico {
    @Getter
    private String id;
    @Getter
    private LocalDateTime fecha;
    @Getter
    private Double temperatura;
    @Getter
    private int humedad;

    public RegistroClimatico(LocalDateTime fecha,Double temperatura, int humedad) {
        this.id= UUID.randomUUID().toString();
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.fecha = fecha;
    }
    public RegistroClimatico(String id,LocalDateTime fecha,Double temperatura, int humedad) {
        this.id=id;
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.fecha = fecha;
    }
}
