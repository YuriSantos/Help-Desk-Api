package br.com.helpdesk.repository;

import br.com.helpdesk.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TicketRepository extends MongoRepository<Ticket,String> {

    Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String userId);

    Page<Ticket> findByTitleIgnoreCaseContainigAndStatusAndPriorityOrderByDateDesc(
            String title, String status, String priority, Pageable pages
    );

    Page<Ticket> findByTitleIgnoreCaseContainigAndStatusAndPriorityAndUserIdOrderByDateDesc(
            String title, String status, String priority, Pageable pages
    );

    Page<Ticket> findByTitleIgnoreCaseContainigAndStatusAndPriorityAndAssignedUserOrderByDateDesc(
            String title, String status, String priority, Pageable pages
    );

    Page<Ticket> findByNumber(int number, Pageable pages);

}
