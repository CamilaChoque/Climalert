package ar.utn.ba.ddsi.repositories;

import ar.utn.ba.ddsi.models.RegistroClimatico;

public interface ClimaRepository {

    RegistroClimatico guardar(RegistroClimatico camion);
    RegistroClimatico obtenerUltimo();

}
