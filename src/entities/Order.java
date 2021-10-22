package entities;

import java.util.Date;

import entities.enums.OrderStatus;

public class Order {

    private Integer id;
    private Date moment;
    private Integer status;

    public Order() {

    }

    public Order(Integer id, Date moment, OrderStatus status) {
        super();
        this.id = id;
        this.moment = moment;
        this.status = status.getCod();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getMoment() {
        return moment;
    }
    public void setMoment(Date moment) {
        this.moment = moment;
    }
    public OrderStatus getStatus() {
        return OrderStatus.toEnum(status);
    }
    public void setStatus(OrderStatus status) {
        this.status = status.getCod();
    }

    @Override
    public String toString() {
        return "id: " + id + ", moment:" + moment + ", status:" + status;
    }


}