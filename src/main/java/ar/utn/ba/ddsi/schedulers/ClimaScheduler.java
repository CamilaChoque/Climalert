package ar.utn.ba.ddsi.schedulers;

import ar.utn.ba.ddsi.Service.AlertaService;
import ar.utn.ba.ddsi.Service.ClimaService;
import ar.utn.ba.ddsi.models.RegistroClimatico;
import ar.utn.ba.ddsi.repositories.ClimaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {
    private ClimaService climaService;
    private ClimaRepository climaRepository;
    private AlertaService alertaService;

    public ClimaScheduler(ClimaService climaService, ClimaRepository climaRepository, AlertaService alertaService) {
        this.climaService = climaService;
        this.climaRepository = climaRepository;
        this.alertaService = alertaService;
    }

    @Scheduled(fixedRate = 300000) //ms a min
    public void registrarClima(){
        RegistroClimatico climaActual = climaService.obtenerClimaActual(); //pedido al servicio externo
        if(climaActual!=null){
            climaRepository.guardar(climaActual);
        }
    }

    @Scheduled(fixedRate = 50000) //ms a min
    public void analizarRegistro(){
        RegistroClimatico ultimoRegistro = climaRepository.obtenerUltimo();
        if(ultimoRegistro!=null){
            alertaService.verificarCondiciones(ultimoRegistro);
        }
    }

}
