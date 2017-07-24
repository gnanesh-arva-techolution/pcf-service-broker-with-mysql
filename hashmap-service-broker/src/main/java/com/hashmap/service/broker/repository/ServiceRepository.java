package com.hashmap.service.broker.repository;

import com.hashmap.service.broker.model.Service;

import java.util.List;

/**
 * @author Gnanesh Arva
 */
//@Repository
public interface ServiceRepository/* extends CrudRepository<Service, String>*/ {

    List<Service> findAll();

    boolean exists(String id);

    void delete(String id);

}
