package com.partyroom.service;

import com.partyroom.model.Partyroom;
import com.partyroom.repositoryy.PartyroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartyroomService {

    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> getAll() {
        return partyroomRepository.getAll();
    }

    public Optional<Partyroom> getPartyroom(int id) {
        return partyroomRepository.getPartyroom(id);
    }

    public Partyroom save(Partyroom pr) {
        if (pr.getId() == null) {
            return partyroomRepository.save(pr);
        } else {
            Optional<Partyroom> e = partyroomRepository.getPartyroom(pr.getId());
            if (e.isEmpty()) {
                return partyroomRepository.save(pr);
            } else {
                return pr;
            }
        }
    }
    
    public boolean deletePartyroom(int id){
        Optional<Partyroom> miPr = partyroomRepository.getPartyroom(id);
        
        if (miPr.isEmpty()){
            return false;
        }else{
            partyroomRepository.delete(miPr.get());
            return true;
        }
    }
    
    public Partyroom updatePartyroom(Partyroom pr){
        if (pr.getId()!=null){
            Optional<Partyroom> prom = partyroomRepository.getPartyroom(pr.getId());
            
            if (!prom.isEmpty()){
               if (pr.getName()!=null){
                   prom.get().setName(pr.getName());
               }
               if (pr.getDescription()!=null){
                   prom.get().setDescription(pr.getDescription());
               }
               if (pr.getOwner()!=null){
                   prom.get().setOwner(pr.getOwner());
               }
               if (pr.getCapacity()!=null){
                   prom.get().setCapacity(pr.getCapacity());
               }
               if (pr.getCategory() != null){
                   prom.get().setCategory(pr.getCategory());
               }
               return partyroomRepository.save(prom.get());
            }else{
               return pr;
            }
        }
        return pr;     
    }
}
