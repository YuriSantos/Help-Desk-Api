package br.com.helpdesk.entity;

import br.com.helpdesk.enums.StatusEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class ChangeStatus {

    @Id
    private String id;
    @DBRef
    private Ticket ticket;

    @DBRef
    private User userChange;

    private Date dateChangeStatus;

    private StatusEnum status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUserChange() {
        return userChange;
    }

    public void setUserChange(User userChange) {
        this.userChange = userChange;
    }

    public Date getDataChangeStatus() {
        return dateChangeStatus;
    }

    public void setDataChangeStatus(Date dataChangeStatus) {
        this.dateChangeStatus = dataChangeStatus;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
