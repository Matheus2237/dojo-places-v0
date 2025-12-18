package br.com.alura.dojoplaces.viacep;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViacepController {

    private final ViaCepService viaCepService;

    public ViacepController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<PlaceAutoCompletionDTO> findCep(@PathVariable String cep) {
        return ResponseEntity.ok(viaCepService.consultarCep(cep));
    }
}
