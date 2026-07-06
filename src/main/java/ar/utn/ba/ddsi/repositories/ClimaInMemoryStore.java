package ar.utn.ba.ddsi.repositories;

import ar.utn.ba.ddsi.models.RegistroClimatico;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClimaInMemoryStore {
    private final Map<String, ClimaModel> climas = new LinkedHashMap<>();

    public RegistroClimatico guardar(RegistroClimatico clima) {
        ClimaModel model = toModel(clima);
        climas.put(model.id, model);
        return toDomain(model);
    }
    private ClimaModel toModel(RegistroClimatico clima) {
        return new ClimaModel(
                clima.getId(),
                clima.getFecha(),
                clima.getTemperatura(),
                clima.getHumedad()
        );
    }

    private static class ClimaModel {
        private String id;
        private LocalDateTime fecha;
        private Double temperatura;
        private Double humedad;

        private ClimaModel(String id,LocalDateTime fecha, Double temperatura, Double humedad) {
            this.id=id;
            this.fecha=fecha;
            this.temperatura=temperatura;
            this.humedad=humedad;
        }
    }

    private RegistroClimatico toDomain(ClimaModel model) {
        return new RegistroClimatico(
                model.id,
                model.fecha,
                model.temperatura,
                model.humedad
        );
    }
}
