package com.partyroom.repository.crud;

import com.partyroom.model.Partyroom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartyroomCrudRepository extends CrudRepository<Partyroom,Integer> {

    @Query("SELECT c.capacity, COUNT(c.capacity) from Partyroom AS c group by c.capacity order by COUNT(c.capacity) DESC")
    public List<Object[]> countTotalPartyroomByYear();

}
