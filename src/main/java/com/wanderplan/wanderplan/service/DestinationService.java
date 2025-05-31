//package com.wanderplan.wanderplan.service;
//
//import com.wanderplan.wanderplan.model.Destination;
//import com.wanderplan.wanderplan.model.User;
//import com.wanderplan.wanderplan.repository.DestinationRepository;
//import com.wanderplan.wanderplan.repository.UserRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DestinationService {
//
//    @Autowired
//    private DestinationRepository destinationRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public Destination saveDestination(Destination destination) {
//        Long userId = destination.getUser().getUserId();
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
//
//        destination.setUser(user); // Ensure the user object is fully loaded from DB
//        return destinationRepository.save(destination);
//    }
//
//    public Optional<Destination> getDestinationById(Long id) {
//        return destinationRepository.findById(id);
//    }
//
//    public List<Destination> getAllDestinations() {
//        return destinationRepository.findAll();
//    }
//
//    public List<Destination> getDestinationsByUserId(Long userId) {
//        return destinationRepository.findByUserUserId(userId);
//    }
//
//    public void deleteDestination(Long id) {
//        destinationRepository.deleteById(id);
//    }
//}

package com.wanderplan.wanderplan.service;

import com.wanderplan.wanderplan.model.Destination;
import com.wanderplan.wanderplan.model.User;
import com.wanderplan.wanderplan.repository.DestinationRepository;
import com.wanderplan.wanderplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private UserRepository userRepository;

    public Destination createDestination(Destination destination) {
        Long userId = destination.getUser().getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        destination.setUser(user);
        return destinationRepository.save(destination);
    }

    public Destination updateDestination(Long id, Destination updatedDestination) {
        Destination existing = destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found with id: " + id));

        existing.setName(updatedDestination.getName());
        existing.setDescription(updatedDestination.getDescription());
        existing.setLocation(updatedDestination.getLocation());
        existing.setUser(updatedDestination.getUser());

        return destinationRepository.save(existing);
    }

    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found with id: " + id));
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public List<Destination> getDestinationsByUserId(Long userId) {
        return destinationRepository.findByUserUserId(userId);
    }

    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
