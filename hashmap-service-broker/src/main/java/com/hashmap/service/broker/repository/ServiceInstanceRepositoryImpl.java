package com.hashmap.service.broker.repository;

import com.hashmap.service.broker.model.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gnanesh Arva
 */
@Service
public class ServiceInstanceRepositoryImpl implements ServiceInstanceRepository {

    private static final List<ServiceInstance> serviceInstances = new ArrayList<>();

    @Override
    public boolean exists(String id) {
        for (ServiceInstance serviceInstance : serviceInstances) {
            if (serviceInstance.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ServiceInstance findOne(String id) {
        for (ServiceInstance serviceInstance : serviceInstances) {
            if (serviceInstance.getId().equalsIgnoreCase(id)) {
                return serviceInstance;
            }
        }
        return null;
    }

    @Override
    public void save(ServiceInstance serviceInstance) {
        serviceInstances.add(serviceInstance);
    }
}
