package ar.utn.ba.ddsi;

import ar.utn.ba.ddsi.models.RegistroClimatico;
import ar.utn.ba.ddsi.models.TipoAlerta;

public interface AlertaService {
    TipoAlerta verificarCondiciones(RegistroClimatico registro);
    void procesarAlerta(TipoAlerta nivel, String mensaje);
}
