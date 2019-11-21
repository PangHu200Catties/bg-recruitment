package com.recruitment.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "pay_time")
    private Date payTime;
    @Column(name = "expire_time")
    private Date expireTime;

    private Integer money;
    @Column(name = "order_status")
    private Integer orderStatus;

    private String info1;

    private String info2;

    private String info3;

}