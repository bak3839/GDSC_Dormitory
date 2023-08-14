package com.example.GDSC_Dormitory.repository;

import com.example.GDSC_Dormitory.domain.Detail;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DetailRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Detail detail) {
        System.out.println(detail.getWakeup());
        em.persist(detail);
    }

    public Detail findOne(Long id) {
        return em.find(Detail.class, id);
    }
}
