package com.wanderplan.wanderplan.controller;

import com.wanderplan.wanderplan.model.Destination;
import com.wanderplan.wanderplan.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public String listDestinations(Model model) {
        List<Destination> destinations = destinationService.getAllDestinations();
        model.addAttribute("destinations", destinations);
        return "destination/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("destination", new Destination());
        return "destination/form";
    }

    @PostMapping
    public String createDestination(@ModelAttribute Destination destination) {
        destinationService.createDestination(destination);
        return "redirect:/destinations";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Destination destination = destinationService.getDestinationById(id);
        model.addAttribute("destination", destination);
        return "destination/form";
    }

    @PostMapping("/update/{id}")
    public String updateDestination(@PathVariable Long id, @ModelAttribute Destination destination) {
        destinationService.updateDestination(id, destination);
        return "redirect:/destinations";
    }

    @GetMapping("/delete/{id}")
    public String deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return "redirect:/destinations";
    }
}
