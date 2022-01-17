package com.example.getinline.controller.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: kbs
 */
@RequestMapping("/api")
@RestController
public class APIPlaceController {
    @GetMapping("/places")
    public List<String> getPlaces() {
        return List.of("event1", "event2");
    }

    @PostMapping("/places")
    public Boolean createPlace() {
        return true;
    }

    @GetMapping("/places/{placeId}")
    public String getPlace(@PathVariable Integer placeId) {
        return "place " + placeId;
    }

    @PutMapping("/places/{placeId}")
    public Boolean modifyPlace(@PathVariable Integer placeId) {
        return true;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean removePlace(@PathVariable Integer placeId) {
        return true;
    }
}
