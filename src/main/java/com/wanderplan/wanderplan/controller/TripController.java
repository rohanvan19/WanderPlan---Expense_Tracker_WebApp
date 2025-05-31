package com.wanderplan.wanderplan.controller;

import com.wanderplan.wanderplan.dto.TripDTO;
import com.wanderplan.wanderplan.model.Trip;
import com.wanderplan.wanderplan.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public String listTrips(Model model) {
        List<TripDTO> trips = tripService.getAllTrips();
        model.addAttribute("trips", trips);
        return "trip/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("trip", new TripDTO());
        return "trip/form";
    }

    @PostMapping
    public String createTrip(@ModelAttribute TripDTO tripDTO) {
        tripService.createTrip(tripDTO);
        return "redirect:/trips";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Trip trip = tripService.findById(id);
        TripDTO tripDTO = tripService.convertToDTO(trip);
        model.addAttribute("trip", tripDTO);
        return "trip/form";
    }

    @PostMapping("/update/{id}")
    public String updateTrip(@PathVariable Long id, @ModelAttribute TripDTO tripDTO) {
        tripService.updateTrip(id, tripDTO);
        return "redirect:/trips";
    }

//    @GetMapping("/delete/{id}")
//    public String deleteTrip(@PathVariable Long id) {
//        tripService.deleteTrip(id);
//        return "redirect:/trips";
//    }
}