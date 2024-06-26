package com.example.jpa;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    @PersistenceUnit
    EntityManagerFactory emf;

    @PersistenceContext
    EntityManager em;

    @GetMapping
    public void createMember() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setUserId("M1");
        member.setUserName("회원1");
        em.persist(member);
        tx.commit();
    }

    @GetMapping("/find")
    public void findMember() {
        EntityManager em = emf.createEntityManager();
        Member member1 = em.find(Member.class, "M1");
        System.out.println("member1 = " + member1);

        Member member2 = em.find(Member.class, "M2");
        System.out.println("member2 = " + member2);
    }

    @GetMapping("/update")
    public void updateMember() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = em.find(Member.class, "M1");
        member.setUserName("바뀐회원1");
        tx.commit();
    }

    @GetMapping("/flushmode")
    public void changeFlushMode() {
        EntityManager em = emf.createEntityManager();
        em.setFlushMode(FlushModeType.AUTO);
    }

    @GetMapping("/pk_identity")
    public void pk_identity(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setUserName("TEST");
        em.persist(member);
        System.out.println("member.getId() = " + member.getId());
        tx.commit();
    }
}

