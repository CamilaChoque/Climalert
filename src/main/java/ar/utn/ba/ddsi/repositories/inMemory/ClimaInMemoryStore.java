package ar.utn.ba.ddsi.repositories.inMemory;

import ar.utn.ba.ddsi.models.RegistroClimatico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClimaInMemoryStore {
    private final List<ClimaModel> climas = new ArrayList<>();

    public RegistroClimatico guardar(RegistroClimatico clima) {
        ClimaModel model = toModel(clima);
        climas.add(model);
        return toDomain(model);
    }
    public RegistroClimatico obtenerUltimo(){
        return toDomain(climas.getLast());

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
        private int humedad;

        private ClimaModel(String id,LocalDateTime fecha, Double temperatura, int humedad) {
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
