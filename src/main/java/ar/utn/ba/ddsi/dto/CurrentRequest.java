package ar.utn.ba.ddsi.dto;

public record CurrentRequest (
        String last_updated,
        Double temp_c,
        int humidity
){

}
