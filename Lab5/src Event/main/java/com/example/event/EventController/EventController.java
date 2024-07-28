package com.example.event.EventController;


import com.example.event.ApiResponse.ApiResponse;
import com.example.event.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/event")
public class EventController {



    ArrayList<Event> events = new ArrayList<>();




    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event){

        events.set(index, event);

        return new ApiResponse("The event has been updated successfully", "200");


    }


    @PostMapping("/post")
    public ApiResponse postEvent(@RequestBody Event event){


        events.add(event);

        return new ApiResponse("The event is added succesfully", "200");
    }


    @GetMapping("/search/{id}")
    public ArrayList<Event> getEventsById(@PathVariable String id) {


        ArrayList<Event> searchEvents = new ArrayList<>();

        for (Event event : events) {
            if (event.getId().equals(id)) {
                searchEvents.add(event);
            }

        }
        return searchEvents;
    }


    @PutMapping("/change/{index}/{capacity}")
    public ApiResponse changeCapacity(@PathVariable int index,@PathVariable int capacity) {

        events.get(index).setCapacity(capacity);

        return new ApiResponse("The event has been updated successfully", "200");

    }


    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }



    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index){
        events.remove(index);


        return new ApiResponse("The event is deleted successfully", "200");


    }


}
