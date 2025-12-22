package br.com.alura.dojoplaces.viacep.dto;

public class PlaceAutoCompletionDTO {

    public String cep;
    public String neighborhood;
    public String city;

    public PlaceAutoCompletionDTO(String cep, String neighborhood, String city) {
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
