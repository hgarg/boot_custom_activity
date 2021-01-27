package com.boot.custom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @PostMapping("/save")
    public ResponseEntity<String> save (@RequestBody Map<String, Object> payload) {
        System.out.println("in save"+payload.toString());
        return new ResponseEntity<>("Save", HttpStatus.OK);
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish (@RequestBody Map<String, Object> payload) {
        System.out.println("in publish"+payload.toString());
        return new ResponseEntity<>("Publish", HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validate (@RequestBody Map<String, Object> payload) {
        System.out.println("in validate"+payload.toString());
        return new ResponseEntity<>("Validate", HttpStatus.OK);
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stop (@RequestBody Map<String, Object> payload) {
        System.out.println("in stop"+payload.toString());
        return new ResponseEntity<>("Stop", HttpStatus.OK);
    }

    @PostMapping("/execute")
    public ActivityResult execute (@RequestBody ExecutePayload payload) {
        System.out.println("in execute"+payload.toString());
        for (Map<String, String> inArgument : payload.getInArguments()) {
            if(inArgument.containsKey("status") && inArgument.get("status").equals("true")){
                return new ActivityResult("true");
            }
        }
        return new ActivityResult("false");
    }
}
