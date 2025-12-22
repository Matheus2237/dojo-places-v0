package br.com.alura.dojoplaces.place.web;

import br.com.alura.dojoplaces.place.domain.Place;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterPlaceForm {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotBlank(message = "Code is required")
    @Pattern(
            regexp = "^[a-zA-Z0-9]+$",
            message = "Code must not contain any special char or white spaces"
    )
    private String code;

    @NotBlank(message = "Cep is required")
    private String cep;

    @NotBlank(message = "Neighborhood is required")
    @Size(max = 100, message = "Neighborhood must be at most 100 characters")
    private String neighborhood;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must be at most 100 characters")
    private String city;

    public RegisterPlaceForm() {
    }

    public RegisterPlaceForm(String name, String code, String cep, String neighborhood, String city) {
        this.name = name;
        this.code = code;
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Place toEntity() {
        return new Place(name, code, cep, neighborhood, city);
    }
}