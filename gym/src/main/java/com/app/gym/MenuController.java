package com.app.gym;

import com.app.gym.model.Exercise;
import com.app.gym.model.GymSet;
import com.app.gym.service.ExerciseService;
import com.app.gym.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MenuController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/menu")
    public ResponseEntity<?> showMenu() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", "Hello World");
//
//        itemService.insertItem("testing");

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PostMapping("/api/v0/itemAdd")
    public ResponseEntity<?> addSetToRecord(@RequestBody GymSet gymSet) {
        itemService.insertSet(gymSet);
        List<GymSet> sets = itemService.findAll();
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }

    @GetMapping("/api/v0/items")
    public ResponseEntity<?> showRecords() {
        List<GymSet> sets = itemService.findAll();
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }

    @GetMapping("/api/v0/practices")
    public ResponseEntity<?> showPractices() {
        List<Exercise> exercises = exerciseService.findAll();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
}
