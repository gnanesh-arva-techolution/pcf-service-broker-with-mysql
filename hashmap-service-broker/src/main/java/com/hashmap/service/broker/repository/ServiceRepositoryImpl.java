package com.hashmap.service.broker.repository;

import com.hashmap.service.broker.model.Plan;
import com.hashmap.service.broker.model.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceRepositoryImpl implements ServiceRepository {

    private static final List<Service> services = new ArrayList<>();

    static {
        Service service = new Service();
        service.setId("3");
        service.setName("hashmap-service-3");
        service.setDescription("This is a hashmap service for Cloud Foundry.");
        service.setBindable(true);
        Plan plan = new Plan();
        plan.setId("3");
        plan.setName("basic");
        plan.setDescription("Basic plan.");
        Set<Plan> plans = new HashSet<>();
        plans.add(plan);
        service.setPlans(plans);
        services.add(service);
    }

    private Logger logger = LoggerFactory.getLogger(ServiceRepositoryImpl.class);

    @Override
    public List<Service> findAll() {
        logger.info("In findAll services : " + services);
        System.out.println("In findAll services : " + services);
        return services;
    }

    @Override
    public boolean exists(String id) {
        for (Service service : services) {
            logger.info("In exists : " + service + " , id : " + id);
            System.out.println("In exists : " + service + " , id : " + id);
            if (service.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(String id) {
        Service serviceToRemove = null;
        for (Service service : services) {
            if (service.getId().equalsIgnoreCase(id)) {
                serviceToRemove = service;
                break;
            }
        }
        if (serviceToRemove != null) {
            services.remove(serviceToRemove);
        }
    }
}
