package com.hashmap.service.broker.repository;

import com.hashmap.service.broker.model.ServiceInstance;

/**
 * @author Gnanesh Arva
 */
//@Repository
public interface ServiceInstanceRepository/* extends CrudRepository<ServiceInstance, String>*/ {

    boolean exists(String id);

    ServiceInstance findOne(String id);

    void save(ServiceInstance serviceInstance);


}
