package br.com.alura.dojoplaces.exception;

public class PlaceNotFoundException extends RuntimeException {

    public PlaceNotFoundException() {
        super("Lugar desejado não foi encontrado");
    }
}