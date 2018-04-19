package com.WS.Controllers;

import com.WS.Entity.Event;
import com.WS.Entity.User;
import com.WS.Repository.EventRepository;
import com.WS.Service.SecurityContextService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api/event")
public class EventController {

    private final Logger logger = LoggerFactory.getLogger(IngredientController.class);
    private final EventRepository eventRepository;
    private final SecurityContextService securityContext;
    
    @Autowired
    public EventController(EventRepository eventRepository, SecurityContextService securityContext){
    	this.eventRepository = eventRepository;
    	this.securityContext = securityContext;
    }
    
    @RequestMapping("/saveEvent")
    public void saveEvent(@RequestBody Event event){
        User currentUser = securityContext.currentUser().get();
        event.setUser(currentUser);
        eventRepository.delete(event);
        eventRepository.save(event);
    }
    
    @RequestMapping("/delete")
    public void deleteEvent(@RequestBody Integer id){
    	eventRepository.deleteById(id);
    }
    
    @RequestMapping("/getUserEvents")
    public List<Event> getUserEvents(){
    	User currentUser = securityContext.currentUser().get();
        return eventRepository.findByUser(currentUser);
    }

}
