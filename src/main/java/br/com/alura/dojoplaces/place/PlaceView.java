package br.com.alura.dojoplaces.place;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlaceView {

    private final Long id;
    private final String name;
    private final String code;
    private final LocalDateTime creationDate;
    private final LocalDateTime lastUpdate;

    public PlaceView(Long id, String name, String code, LocalDateTime creationDate, LocalDateTime lastUpdate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    public static PlaceView fromPlace(Place place) {
        return new PlaceView(place.getId(), place.getName(), place.getCode(), place.getCreatedAt(), place.getUpdatedAt());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getFormattedCreationDate() {
        if(creationDate == null) return "";
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(creationDate);
    }

    public String getFormattedDaysSinceLastUpdate() {
        long days = lastUpdate == null
                ? 0
                : Duration.between(lastUpdate, LocalDateTime.now()).toDays();

        if (days < 0) {
            days = 0;
        }

        return days == 1
                ? "1 dia atrás"
                : days + " dias atrás";
    }
}
