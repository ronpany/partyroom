package com.partyroom.repositoryy;

import com.partyroom.model.Partyroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.partyroom.repository.crud.PartyroomCrudRepository;

@Repository
public class PartyroomRepository {
    @Autowired
    private PartyroomCrudRepository partyroomCrudRepository;

    public List<Partyroom> getAll(){
        return (List<Partyroom>) partyroomCrudRepository.findAll();
    }

    public Optional<Partyroom> getPartyroom(int id){
        return partyroomCrudRepository.findById(id);
    }

    public Partyroom save(Partyroom pr){
        return partyroomCrudRepository.save(pr);
    }
    
    public void delete(Partyroom pr){
        partyroomCrudRepository.delete(pr);
    }
}
