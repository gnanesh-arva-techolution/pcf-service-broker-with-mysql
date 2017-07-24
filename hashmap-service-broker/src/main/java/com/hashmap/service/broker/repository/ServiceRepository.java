package com.hashmap.service.broker.repository;

import com.hashmap.service.broker.model.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gnanesh Arva
 */
@Repository
public interface ServiceRepository extends CrudRepository<Service, String> {

}
