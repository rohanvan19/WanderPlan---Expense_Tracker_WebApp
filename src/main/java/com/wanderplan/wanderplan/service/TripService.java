//package com.wanderplan.wanderplan.service;
//
//import com.wanderplan.wanderplan.dto.TripDTO;
//import com.wanderplan.wanderplan.model.Trip;
//import com.wanderplan.wanderplan.model.User;
//import com.wanderplan.wanderplan.repository.TripRepository;
//import com.wanderplan.wanderplan.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TripService {
//
//    private final TripRepository tripRepository;
//    private final UserRepository userRepository;  // Inject UserRepository
//
//    public TripService(TripRepository tripRepository, UserRepository userRepository) {
//        this.tripRepository = tripRepository;
//        this.userRepository = userRepository;
//    }
//
//    public Trip findById(Long id) {
//        return tripRepository.findById(id).orElse(null);
//    }
//
//    public TripDTO convertToDTO(Trip trip) {
//        if (trip == null) return null;
//
//        Long userId = trip.getUser() != null ? trip.getUser().getUserId() : null;
//
//        return new TripDTO(
//                trip.getId(),
//                trip.getDestination(),
//                trip.getStartDate(),
//                trip.getEndDate(),
//                userId
//        );
//    }
//
//    public Trip createTrip(TripDTO tripDTO) {
//        Trip trip = new Trip();
//        trip.setDestination(tripDTO.getDestination());
//        trip.setStartDate(tripDTO.getStartDate());
//        trip.setEndDate(tripDTO.getEndDate());
//
//        // Fetch user by userId from DTO, or throw if user not found
//        User user = userRepository.findById(tripDTO.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + tripDTO.getUserId()));
//        trip.setUser(user);
//
//        return tripRepository.save(trip);
//    }
//
//    public Trip updateTrip(Long id, TripDTO tripDTO) {
//        Trip existingTrip = tripRepository.findById(id).orElse(null);
//        if (existingTrip == null) {
//            return null;
//        }
//
//        existingTrip.setDestination(tripDTO.getDestination());
//        existingTrip.setStartDate(tripDTO.getStartDate());
//        existingTrip.setEndDate(tripDTO.getEndDate());
//
//        User user = userRepository.findById(tripDTO.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + tripDTO.getUserId()));
//        existingTrip.setUser(user);
//
//        return tripRepository.save(existingTrip);
//    }
//}

package com.wanderplan.wanderplan.service;

import com.wanderplan.wanderplan.dto.TripDTO;
import com.wanderplan.wanderplan.model.Trip;
import com.wanderplan.wanderplan.model.User;
import com.wanderplan.wanderplan.repository.TripRepository;
import com.wanderplan.wanderplan.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public TripService(TripRepository tripRepository, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    public Trip findById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public TripDTO convertToDTO(Trip trip) {
        if (trip == null) return null;

        Long userId = trip.getUser() != null ? trip.getUser().getUserId() : null;

        return new TripDTO(
                trip.getId(),
                trip.getDestination(),
                trip.getStartDate(),
                trip.getEndDate(),
                userId
        );
    }

    public List<TripDTO> getAllTrips() {
        return tripRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Trip createTrip(TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setDestination(tripDTO.getDestination());
        trip.setStartDate(tripDTO.getStartDate());
        trip.setEndDate(tripDTO.getEndDate());

        User user = userRepository.findById(tripDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + tripDTO.getUserId()));
        trip.setUser(user);

        return tripRepository.save(trip);
    }

    public Trip updateTrip(Long id, TripDTO tripDTO) {
        Trip existingTrip = tripRepository.findById(id).orElse(null);
        if (existingTrip == null) {
            return null;
        }

        existingTrip.setDestination(tripDTO.getDestination());
        existingTrip.setStartDate(tripDTO.getStartDate());
        existingTrip.setEndDate(tripDTO.getEndDate());

        User user = userRepository.findById(tripDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + tripDTO.getUserId()));
        existingTrip.setUser(user);

        return tripRepository.save(existingTrip);
    }
}
