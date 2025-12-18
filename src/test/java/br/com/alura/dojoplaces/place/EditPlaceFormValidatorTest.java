package br.com.alura.dojoplaces.place;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EditPlaceFormValidatorTest {

    @Mock
    private PlaceRepository placeRepository;

    private EditPlaceFormValidator validator;

    @BeforeEach
    void setUp() {
        validator = new EditPlaceFormValidator(placeRepository);
    }

    @Nested
    class Supports {

        @Test
        void should_return_true_when_class_is_edit_place_form() {
            boolean supports = validator.supports(EditPlaceForm.class);
            assertTrue(supports);
        }
    }

    @Nested
    class Validate {

        @Test
        void should_add_error_when_code_exists_and_belongs_to_different_place() {
            EditPlaceForm form = new EditPlaceForm(1L, "Place A", "ABC123", "11111111", "Neighborhood", "City");
            Errors errors = new BeanPropertyBindingResult(form, "editPlaceForm");

            Place existingPlace = new Place("Some place", "ABC123", "11111111", "Another Neighborhood", "Another City");
            existingPlace.setId(2L);
            when(placeRepository.findByCode("ABC123")).thenReturn(Optional.of(existingPlace));

            validator.validate(form, errors);

            assertTrue(errors.hasErrors());
            assertEquals(1, errors.getErrorCount());
            assertNotNull(errors.getFieldError("code"));
            assertEquals("Já existe um local utilizando este código.", errors.getFieldError("code").getDefaultMessage());
        }

        @Test
        void should_not_add_error_when_code_exists_and_belongs_to_same_place() {
            EditPlaceForm form = new EditPlaceForm(1L, "Place A", "ABC123", "11111111", "Neighborhood", "City");
            Errors errors = new BeanPropertyBindingResult(form, "editPlaceForm");

            Place existingPlace = new Place("Place A", "ABC123", "11111111", "Another Neighborhood", "Another City");
            existingPlace.setId(1L);
            when(placeRepository.findByCode("ABC123")).thenReturn(Optional.of(existingPlace));

            validator.validate(form, errors);

            assertFalse(errors.hasErrors());
            assertEquals(0, errors.getErrorCount());
        }

        @Test
        void should_not_add_error_when_code_does_not_exist() {
            EditPlaceForm form = new EditPlaceForm(1L, "Place A", "XYZ789", "11111111", "Neighborhood", "City");
            Errors errors = new BeanPropertyBindingResult(form, "editPlaceForm");

            when(placeRepository.findByCode("XYZ789")).thenReturn(Optional.empty());

            validator.validate(form, errors);

            assertFalse(errors.hasErrors());
            assertEquals(0, errors.getErrorCount());
        }

        @Test
        void should_not_add_error_when_target_is_not_edit_place_form() {
            String notAForm = "not a form";
            Errors errors = new BeanPropertyBindingResult(notAForm, "notAForm");

            validator.validate(notAForm, errors);

            assertFalse(errors.hasErrors());
            assertEquals(0, errors.getErrorCount());
        }
    }
}