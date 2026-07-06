package ar.utn.ba.ddsi.dto;

public record CurrentResponse(
        String last_updated,
        Double temp_c,
        int humidity
){

}
