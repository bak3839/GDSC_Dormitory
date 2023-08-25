package com.example.GDSC_Dormitory.repository;

import com.example.GDSC_Dormitory.domain.Member;
import com.example.GDSC_Dormitory.domain.Savelist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SavelistRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Savelist savelist) {
        em.persist(savelist);
    }

    public List<Long> findIdList(Long id) {
        return em.createQuery("select s.member2.id from Savelist s where s.member1.id = :id", Long.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Member> findMyList(Long id) {
        return em.createQuery("select s.member2 from Savelist s where s.member1.id = :id", Member.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Member> findOtherList(Long id) {
        return em.createQuery("select s.member1 from Savelist s where s.member2.id = :id", Member.class)
                .setParameter("id", id)
                .getResultList();
    }
}
