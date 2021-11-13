package com.partyroom.controller;

import com.partyroom.model.Partyroom;
import com.partyroom.service.PartyroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/Partyroom")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PartyroomController {

    @Autowired
    private PartyroomService partyroomService;
    @GetMapping("/all")
    public List<Partyroom> getAll(){
        return partyroomService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Partyroom> getBoat(@PathVariable int id){
        return partyroomService.getPartyroom(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom boat) {
        return partyroomService.save(boat);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deletePartyroom(@PathVariable int id){
        return partyroomService.deletePartyroom(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom updatePartyroom(@RequestBody Partyroom pr){
        return partyroomService.updatePartyroom(pr);
    }
}
