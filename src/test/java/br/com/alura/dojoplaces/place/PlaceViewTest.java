package br.com.alura.dojoplaces.place;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaceViewTest {

    @Nested
    class GetFormattedCreationDate {

        @Test
        void should_return_empty_when_creation_date_is_null() {
            Place place = new Place();
            place.setCreatedAt(null);
            PlaceView placeView = PlaceView.fromPlace(place);

            String formattedCreationDate = placeView.getFormattedCreationDate();
            assertEquals("", formattedCreationDate);
        }

        @Test
        void should_return_formatted_date_when_date_is_valid() {
            Place place = new Place();
            place.setCreatedAt(LocalDateTime.of(2025, 11, 27, 14, 44));
            PlaceView placeView = PlaceView.fromPlace(place);

            String formattedCreationDate = placeView.getFormattedCreationDate();
            assertEquals("27/11/2025", formattedCreationDate);
        }

        @Test
        void should_return_formatted_date_leading_zeros_when_needed() {
            Place place = new Place();
            place.setCreatedAt(LocalDateTime.of(2025, 1, 5, 17, 38));
            PlaceView placeView = PlaceView.fromPlace(place);

            String formattedCreationDate = placeView.getFormattedCreationDate();
            assertEquals("05/01/2025", formattedCreationDate);
        }
    }

    @Nested
    class GetFormattedDaysSinceLastUpdate {

        @Test
        void should_return_empty_when_last_update_is_null() {
            Place place = new Place();
            place.setUpdatedAt(null);
            PlaceView placeView = PlaceView.fromPlace(place);

            String formatted = placeView.getFormattedDaysSinceLastUpdate();
            assertEquals("0 dias atrás", formatted);
        }

        @Test
        void should_return_zero_days_when_last_update_is_today() {
            Place place = new Place();
            place.setUpdatedAt(LocalDateTime.now());
            PlaceView placeView = PlaceView.fromPlace(place);

            String formatted = placeView.getFormattedDaysSinceLastUpdate();
            assertEquals("0 dias atrás", formatted);
        }

        @Test
        void should_return_one_day_when_last_update_was_yesterday() {
            Place place = new Place();
            place.setUpdatedAt(LocalDateTime.now().minusDays(1));
            PlaceView placeView = PlaceView.fromPlace(place);

            String formatted = placeView.getFormattedDaysSinceLastUpdate();
            assertEquals("1 dia atrás", formatted);
        }

        @Test
        void should_return_days_when_last_update_was_several_days_ago() {
            Place place = new Place();
            place.setUpdatedAt(LocalDateTime.now().minusDays(10));
            PlaceView placeView = PlaceView.fromPlace(place);

            String formatted = placeView.getFormattedDaysSinceLastUpdate();
            assertEquals("10 dias atrás", formatted);
        }

        @Test
        void should_return_zero_days_when_last_update_is_in_the_future() {
            Place place = new Place();
            place.setUpdatedAt(LocalDateTime.now().plusDays(5));
            PlaceView placeView = PlaceView.fromPlace(place);

            String formatted = placeView.getFormattedDaysSinceLastUpdate();
            assertEquals("0 dias atrás", formatted);
        }
    }
}