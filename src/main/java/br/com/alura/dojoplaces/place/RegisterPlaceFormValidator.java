package br.com.alura.dojoplaces.place;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterPlaceFormValidator implements Validator {

    private final PlaceRepository placeRepository;

    public RegisterPlaceFormValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterPlaceForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof RegisterPlaceForm form
                && placeRepository.existsByCode(form.getCode())) {
            errors.rejectValue("code", null, "A place with the same code already exists.");
        }
    }
}
