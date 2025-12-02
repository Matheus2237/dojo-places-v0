package br.com.alura.dojoplaces.place;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EditPlaceFormValidator implements Validator {

    private final PlaceRepository placeRepository;

    public EditPlaceFormValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return EditPlaceForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof EditPlaceForm form) {
            Optional<Place> existingPlace = placeRepository.findByCode(form.getCode());
            if (existingPlace.isPresent() && !existingPlace.get().getId().equals(form.getId())) {
                errors.rejectValue("code", null, "Já existe um local utilizando este código.");
            }
        }
    }
}
