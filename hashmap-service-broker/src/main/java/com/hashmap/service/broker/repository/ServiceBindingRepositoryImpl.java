package com.hashmap.service.broker.repository;

import com.hashmap.service.broker.model.ServiceBinding;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceBindingRepositoryImpl implements ServiceBindingRepository {

    private static final List<ServiceBinding> serviceBindings = new ArrayList<>();

    @Override
    public boolean exists(String id) {
        for (ServiceBinding serviceBinding : serviceBindings) {
            if (serviceBinding.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ServiceBinding findOne(String id) {
        for (ServiceBinding serviceBinding : serviceBindings) {
            if (serviceBinding.getId().equalsIgnoreCase(id)) {
                return serviceBinding;
            }
        }
        return null;
    }

    @Override
    public void save(ServiceBinding serviceBinding) {
        serviceBindings.add(serviceBinding);
    }

    @Override
    public void delete(String id) {
        ServiceBinding serviceBindingToRemove = null;
        for (ServiceBinding serviceBinding : serviceBindings) {
            if (serviceBinding.getId().equalsIgnoreCase(id)) {
                serviceBindingToRemove = serviceBinding;
            }
        }
        if (serviceBindingToRemove != null) {
            serviceBindings.remove(serviceBindingToRemove);
        }
    }
}
