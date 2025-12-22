package br.com.alura.dojoplaces.viacep.service;

import br.com.alura.dojoplaces.viacep.dto.PlaceAutoCompletionDTO;
import br.com.alura.dojoplaces.viacep.dto.ViaCepResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    private final RestTemplate restTemplate;

    public ViaCepService() {
        this.restTemplate = new RestTemplate();
    }

    public PlaceAutoCompletionDTO consultarCep(String possibleCep) {
        String url = "https://viacep.com.br/ws/" + possibleCep + "/json/";
        ViaCepResponse viaCepResponse = restTemplate.getForObject(url, ViaCepResponse.class);
        String cep = viaCepResponse.getCep();
        String neighborhood = viaCepResponse.getBairro();
        String city = viaCepResponse.getLocalidade();
        return new PlaceAutoCompletionDTO(cep, neighborhood, city);
    }
}