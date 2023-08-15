package com.example.GDSC_Dormitory.repository;

import com.example.GDSC_Dormitory.domain.Match;
import com.example.GDSC_Dormitory.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MatchRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Match match) {
        em.persist(match);
    }

    public Match findOne(Long id) {
        return em.find(Match.class, id);
    }

    public List<Match> findAll(Long id) {
        return em.createQuery("select m from Match m where m.id = :id", Match.class)
                .setParameter("id", id)
                .getResultList();
    }
}