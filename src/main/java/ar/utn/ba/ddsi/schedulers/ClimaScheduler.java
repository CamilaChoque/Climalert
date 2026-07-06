package ar.utn.ba.ddsi.schedulers;

import ar.utn.ba.ddsi.Service.ClimaService;
import ar.utn.ba.ddsi.models.RegistroClimatico;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {
    private ClimaService climaService;

    public ClimaScheduler(ClimaService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 300000) //ms a min
    //llamada de wheateAPI

}
