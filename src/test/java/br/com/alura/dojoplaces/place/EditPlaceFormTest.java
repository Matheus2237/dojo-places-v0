package br.com.alura.dojoplaces.place;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditPlaceFormTest {

    @Nested
    class UpdatePlace {

        @Test
        void should_update_place_with_form_data() {
            Place place = new Place("Old Name", "OLD123", "Old Neighborhood", "Old City");
            place.setId(1L);

            String newName = "New Name";
            String newCode =  "NEW456";
            String newNeighborhood = "New Neighborhood";
            String newCity = "New City";
            EditPlaceForm form = new EditPlaceForm(1L, newName, newCode, newNeighborhood, newCity);

            form.updatePlace(place);

            assertEquals(newName, place.getName());
            assertEquals(newCode, place.getCode());
            assertEquals(newNeighborhood, place.getNeighborhood());
            assertEquals(newCity, place.getCity());
            assertNotNull(place.getUpdatedAt());
        }
    }
}