package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Gatsjy on 2020-10-26
 * Blog : https://blog.naver.com/gkswndks123
 * Github : https://github.com/gatsjy
 */

@Entity
@Table(name ="ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name ="ORDER_ID")
    private Long id;

    @Column(name="MEMBER_ID")
    private Long memberId;

    private Member member;

    public Member getMember() {
        return member;
    }

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}