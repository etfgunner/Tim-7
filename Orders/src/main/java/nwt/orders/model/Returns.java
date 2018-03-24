package nwt.orders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

import java.util.Date;

@Entity
public class Returns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Nullable
    private Long rentalId;
    @Nullable
    private Date dateReturn;
    @Nullable
    private String reason;

    public Long getId() {
        return id;
    }

    public Returns() {
    }

    public Returns(Long rentalId, Date dateReturn, String reason) {
        this.rentalId = rentalId;
        this.dateReturn = dateReturn;
        this.reason = reason;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}