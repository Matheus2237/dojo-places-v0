package br.com.alura.dojoplaces.place;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterPlaceFormValidatorTest {

    @Mock
    private PlaceRepository placeRepository;
    private RegisterPlaceFormValidator validator;

    @BeforeEach
    void setUp() {
        validator = new RegisterPlaceFormValidator(placeRepository);
    }

    @Nested
    class Supports {

        @Test
        void should_return_true_when_class_is_register_place_form() {
            boolean supports = validator.supports(RegisterPlaceForm.class);
            assertTrue(supports);
        }
    }

    @Nested
    class Validate {

        @Test
        void should_add_error_when_code_already_exists() {
            RegisterPlaceForm form = new RegisterPlaceForm();
            form.setCode("ABC123");
            Errors errors = new BeanPropertyBindingResult(form, "registerPlaceForm");

            when(placeRepository.existsByCode("ABC123")).thenReturn(true);

            validator.validate(form, errors);

            assertTrue(errors.hasErrors());
            assertEquals(1, errors.getErrorCount());
            assertNotNull(errors.getFieldError("code"));
            assertEquals("Um lugar com o mesmo código já existe.", errors.getFieldError("code").getDefaultMessage());
        }

        @Test
        void should_not_add_error_when_code_does_not_exist() {
            RegisterPlaceForm form = new RegisterPlaceForm();
            form.setCode("XYZ789");
            Errors errors = new BeanPropertyBindingResult(form, "registerPlaceForm");

            when(placeRepository.existsByCode("XYZ789")).thenReturn(false);

            validator.validate(form, errors);

            assertFalse(errors.hasErrors());
            assertEquals(0, errors.getErrorCount());
        }

        @Test
        void should_not_add_error_when_target_is_not_register_place_form() {
            String notAForm = "not a form";
            Errors errors = new BeanPropertyBindingResult(notAForm, "notAForm");

            validator.validate(notAForm, errors);

            assertFalse(errors.hasErrors());
            assertEquals(0, errors.getErrorCount());
        }
    }
}