package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.Census;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by martin on 08/12/14.
 */
public interface CensusRepository {
    void setEntityManager(EntityManager entityManager);

    List<Census> findAll();
}
