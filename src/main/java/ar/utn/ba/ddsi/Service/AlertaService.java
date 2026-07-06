package ar.utn.ba.ddsi.Service;

import ar.utn.ba.ddsi.models.RegistroClimatico;

public interface AlertaService {
    void verificarCondiciones(RegistroClimatico registro);
}
