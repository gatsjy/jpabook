package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Gatsjy on 2020-10-26
 * Blog : https://blog.naver.com/gkswndks123
 * Github : https://github.com/gatsjy
 */
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{

            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();
            Member member = order.getMember();
            // 위의 방식으로 설계가 들어가야 한다는 말이다...
            // 현재 방식은 객체 설계를 테이블 설계에 맞춘 방식
            // 테이블의 외래키를 객체에 그대로 가져옴..
            // 객체 그래프탐색이 불가능
            // 참조가 없으므로 UML도 잘못됨..
            // 일단 JPA와 디비를 둘이 떨어질 수 없는 관계인 것이다.
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
