package nwt.orders.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.lang.Nullable;

@EntityScan
@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Nullable
    private Long rentalId;
    @Nullable
    private Long transactionNumber;
    @Nullable
    private double price;
    @Nullable
    private double discount;
    @Nullable
    private Date dateCreated;

    public Receipt(){

    }

    public Long getId() {
        return id;
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

    public Long getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(Long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Receipt(Long rentalId, Long transactionNumber, double price, double discount, Date dateCreated) {
        this.rentalId = rentalId;
        this.transactionNumber = transactionNumber;
        this.price = price;
        this.discount = discount;
        this.dateCreated = dateCreated;
    }
}