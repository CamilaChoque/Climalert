package ar.utn.ba.ddsi.Service;

import ar.utn.ba.ddsi.dto.ClimaResponse;
import ar.utn.ba.ddsi.dto.CurrentResponse;
import ar.utn.ba.ddsi.models.RegistroClimatico;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class ClimaServiceImpl implements ClimaService{
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("$weather.api.url")
    private String urlBase;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.location}")
    private String ubicacion;

    public RegistroClimatico obtenerClimaActual(){
        String urlCompleta = String.format("%s?key=%s&q=%s", urlBase, apiKey, ubicacion);
        try {
            ClimaResponse response = restTemplate.getForObject(urlCompleta, ClimaResponse.class);

            if (response != null && response.current() != null) {
                CurrentResponse currentResponse = response.current();

                return new RegistroClimatico(
                        LocalDateTime.now(),
                        currentResponse.temp_c(),
                        currentResponse.humidity()
                );
            }
        } catch (Exception e) {
            System.err.println("Error al consultar el servicio de clima externo: " + e.getMessage());
        }
        return null;
    }
}
