package br.com.helpdesk.repository;

import br.com.helpdesk.entity.ChangeStatus;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {

    Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);
}
