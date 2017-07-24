package com.hashmap.service.broker.repository;

import com.hashmap.service.broker.model.ServiceBinding;


/**
 * @author Gnanesh Arva
 */
//@Repository
public interface ServiceBindingRepository/* extends CrudRepository<ServiceBinding,String>*/ {

    boolean exists(String id);

    ServiceBinding findOne(String id);

    void save(ServiceBinding serviceBinding);

    void delete(String id);
}
