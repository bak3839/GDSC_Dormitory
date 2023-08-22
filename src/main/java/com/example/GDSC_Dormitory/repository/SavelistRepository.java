package com.example.GDSC_Dormitory.repository;

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

    public List<Savelist> findMyList(Long id) {
        return em.createQuery("select s from Savelist s where s.member1.id = :id", Savelist.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Savelist> findOtherList(Long id) {
        return em.createQuery("select s from Savelist s where s.member2.id = :id", Savelist.class)
                .setParameter("id", id)
                .getResultList();
    }
}
