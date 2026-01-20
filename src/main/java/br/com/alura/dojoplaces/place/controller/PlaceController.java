package br.com.alura.dojoplaces.place.controller;

import br.com.alura.dojoplaces.exception.PlaceNotFoundException;
import br.com.alura.dojoplaces.place.domain.Place;
import br.com.alura.dojoplaces.place.repository.PlaceRepository;
import br.com.alura.dojoplaces.place.validator.EditPlaceFormValidator;
import br.com.alura.dojoplaces.place.validator.RegisterPlaceFormValidator;
import br.com.alura.dojoplaces.place.web.EditPlaceForm;
import br.com.alura.dojoplaces.place.web.PlaceView;
import br.com.alura.dojoplaces.place.web.RegisterPlaceForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {

    private final PlaceRepository placeRepository;
    private final RegisterPlaceFormValidator registerPlaceFormValidator;
    private final EditPlaceFormValidator editPlaceFormValidator;

    public PlaceController(PlaceRepository placeRepository, RegisterPlaceFormValidator registerPlaceFormValidator, EditPlaceFormValidator editPlaceFormValidator) {
        this.placeRepository = placeRepository;
        this.registerPlaceFormValidator = registerPlaceFormValidator;
        this.editPlaceFormValidator = editPlaceFormValidator;
    }

    @InitBinder("registerPlaceForm")
    public void initBinderCreate(WebDataBinder binder) {
        binder.addValidators(registerPlaceFormValidator);
    }

    @InitBinder("editPlaceForm")
    public void initBinderEdit(WebDataBinder binder) {
        binder.addValidators(editPlaceFormValidator);
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

        return "redirect:/place";
    }

    @GetMapping
    public String list(Model model) {
        List<PlaceView> places = placeRepository.findAll()
                .stream()
                .map(PlaceView::fromPlace)
                .toList();
        model.addAttribute("places", places);
        return "place/viewAllPlaces";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, EditPlaceForm editPlaceForm, Model model) {
        Place place = placeRepository.findById(id).orElseThrow(PlaceNotFoundException::new);

        if (!editPlaceForm.isDirty()) editPlaceForm = EditPlaceForm.from(place);

        model.addAttribute("placeId", id);
        model.addAttribute("editPlaceForm", editPlaceForm);

        return "place/editPlace";
    }

    @PostMapping("/{placeId}/edit")
    public String update(@PathVariable Long placeId, @Valid EditPlaceForm editPlaceForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            editPlaceForm.markAsDirty();
            return edit(placeId, editPlaceForm, model);
        }

        Place place = placeRepository.findById(placeId).orElseThrow(PlaceNotFoundException::new);
        editPlaceForm.updatePlace(place);
        placeRepository.save(place);

        return "redirect:/place";
    }

    @PostMapping("/{placeId}/delete")
    public String delete(@PathVariable Long placeId) {
        Place place = placeRepository.findById(placeId).orElseThrow(PlaceNotFoundException::new);
        placeRepository.delete(place);
        return "redirect:/place";
    }
}
