package ar.utn.ba.ddsi;

import ar.utn.ba.ddsi.models.RegistroClimatico;
import ar.utn.ba.ddsi.models.TipoAlerta;
import ar.utn.ba.ddsi.repositories.ClimaRepository;

public class AlertaServiceImpl implements AlertaService {
    private ClimaRepository climaRepository;

    public TipoAlerta verificarCondiciones(RegistroClimatico registro){
        climaRepository.guardar(registro);
        if(registro.getTemperatura()>35 && registro.getHumedad()>35){
            procesarAlerta(TipoAlerta.ROJO,"Advertencia: se registra condición crítica climática");
            return TipoAlerta.ROJO;
        }
        return TipoAlerta.VERDE;
    }
    void procesarAlerta(TipoAlerta nivel, String mensaje){

    }

}
