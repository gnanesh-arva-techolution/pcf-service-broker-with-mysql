package com.hashmap.service.broker.repository;

import com.hashmap.service.broker.model.ServiceBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Gnanesh Arva
 */
@Repository
public interface ServiceBindingRepository extends CrudRepository<ServiceBinding, String> {

}
