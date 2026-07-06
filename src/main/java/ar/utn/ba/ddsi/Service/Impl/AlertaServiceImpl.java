package ar.utn.ba.ddsi.Service.Impl;

import ar.utn.ba.ddsi.Service.AlertaService;

import ar.utn.ba.ddsi.Service.EmailService;
import ar.utn.ba.ddsi.models.RegistroClimatico;
import ar.utn.ba.ddsi.repositories.ClimaRepository;

public class AlertaServiceImpl implements AlertaService {
    private ClimaRepository climaRepository;
    private EmailService emailService;
    public void verificarCondiciones(RegistroClimatico registro){
        climaRepository.guardar(registro);
        if(registro.getTemperatura()>35 && registro.getHumedad()>60){
            emailService.enviarAlerta("Advertencia climática",registro);
        }
    }

}
