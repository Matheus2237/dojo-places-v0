package br.com.alura.dojoplaces.viacep;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    private final RestTemplate restTemplate;

    public ViaCepService() {
        this.restTemplate = new RestTemplate();
    }

    public PlaceAutoCompletionDTO consultarCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ViaCepResponse viaCepResponse = restTemplate.getForObject(url, ViaCepResponse.class);
        String code = viaCepResponse.getCep();
        String neighborhood = viaCepResponse.getBairro();
        String city = viaCepResponse.getLocalidade();
        return new PlaceAutoCompletionDTO(code, neighborhood, city);
    }
}