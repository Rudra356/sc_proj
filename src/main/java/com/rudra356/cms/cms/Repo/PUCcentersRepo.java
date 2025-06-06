package com.rudra356.cms.cms.Repo;

import com.rudra356.cms.cms.Entity.PUCcenters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PUCcentersRepo extends MongoRepository<PUCcenters, String> {
    Optional<PUCcenters> findByCenterName(String name);
    Optional<PUCcenters> deleteCenterByCenterName(String name);

}
