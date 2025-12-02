package br.com.alura.dojoplaces.place;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EditPlaceForm {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    private String name;

    @NotBlank(message = "Código é obrigatório")
    @Pattern(
            regexp = "^[a-zA-Z0-9]+$",
            message = "Código deve conter apenas letras e números, sem espaços ou caracteres especiais"
    )
    private String code;

    @NotBlank(message = "Bairro é obrigatório")
    @Size(max = 100, message = "Bairro deve ter no máximo 100 caracteres")
    private String neighborhood;

    @NotBlank(message = "Cidade é obrigatório")
    @Size(max = 100, message = "Cidade deve ter no máximo 100 caracteres")
    private String city;

    private boolean dirty;

    public EditPlaceForm() {}

    public EditPlaceForm(Long id, String name, String code, String neighborhood, String city) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.neighborhood = neighborhood;
        this.city = city;
        this.dirty = false;
    }

    public static EditPlaceForm from(Place place) {
        return new EditPlaceForm(
                place.getId(),
                place.getName(),
                place.getCode(),
                place.getNeighborhood(),
                place.getCity()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isDirty() {
        return dirty;
    }

    public void markAsDirty() {
        this.dirty = true;
    }

    public void updatePlace(Place place) {
        place.setName(this.name);
        place.setCode(this.code);
        place.setNeighborhood(this.neighborhood);
        place.setCity(this.city);
        place.registerUpdateDate();
    }
}
