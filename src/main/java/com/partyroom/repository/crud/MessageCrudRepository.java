package com.partyroom.repository.crud;

import com.partyroom.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {

}
