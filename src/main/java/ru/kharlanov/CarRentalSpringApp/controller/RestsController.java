package ru.kharlanov.CarRentalSpringApp.controller;

import org.springframework.web.bind.annotation.*;
import ru.kharlanov.CarRentalSpringApp.Exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rest")
public class RestsController {
    private int counter = 4;

    public List<Map<String, String>> restRequest = new ArrayList<Map<String, String>>() {{
       add(new HashMap<String, String>() {{ put("id", "1"); put("text", "First message"); }});
       add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Second message"); }});
       add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Third message"); }});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return restRequest;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getMessage(id);
    }

    private Map<String, String> getMessage(@PathVariable String id) {
        return restRequest.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));

        restRequest.add(message);

        return message;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDb = getMessage(id);

        messageFromDb.putAll(message);
        messageFromDb.put("id", id);

        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> message = getMessage(id);

        restRequest.remove(message);
    }
}
