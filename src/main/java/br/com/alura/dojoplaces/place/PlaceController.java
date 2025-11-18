package br.com.alura.dojoplaces.place;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/place")
public class PlaceController {

    private final PlaceRepository placeRepository;
    private final RegisterPlaceFormValidator registerPlaceFormValidator;

    public PlaceController(PlaceRepository placeRepository, RegisterPlaceFormValidator registerPlaceFormValidator) {
        this.placeRepository = placeRepository;
        this.registerPlaceFormValidator = registerPlaceFormValidator;
    }

    @InitBinder("registerPlaceForm")
    public void initBinderCreate(WebDataBinder binder) {
        binder.addValidators(registerPlaceFormValidator);
    }

    @GetMapping("/create")
    public String create(Model model, RegisterPlaceForm registerPlaceForm) {
        model.addAttribute("registerPlaceForm", registerPlaceForm);
        return "place/createPlace";
    }

    @PostMapping("/create")
    public String register(@Valid RegisterPlaceForm registerPlaceForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return create(model, registerPlaceForm);
        }

        Place place = registerPlaceForm.toEntity();
        placeRepository.save(place);

        return "redirect:/place/create";
    }
}
