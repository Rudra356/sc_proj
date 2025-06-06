package com.rudra356.cms.cms.Service;

import com.rudra356.cms.cms.Entity.PUCcenters;
import com.rudra356.cms.cms.Repo.PUCcentersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PUCcenterService {

    @Autowired
    private PUCcentersRepo pr;

    public void createCenter(PUCcenters pc) {
        pr.save(pc);
    }

    public List<PUCcenters> getAllCenters() {
        return pr.findAll();
    }

    public PUCcenters getCenterById(String id) {
        return pr.findById(id).orElse(null);
    }

    public Optional<PUCcenters> deleteCenterById(String id) {
        Optional<PUCcenters> center = pr.findById(id);
        center.ifPresent(c -> pr.deleteById(id));
        return center;
    }

    public Optional<PUCcenters> getCenterByCenterName(String centerName) {
        return pr.findByCenterName(centerName);
    }


    public Optional<PUCcenters> deleteCenterByCenterName(String centerName) {
        Optional<PUCcenters> center = pr.findByCenterName(centerName);
        center.ifPresent(c->pr.deleteCenterByCenterName(centerName));
        return center;
    }
}
