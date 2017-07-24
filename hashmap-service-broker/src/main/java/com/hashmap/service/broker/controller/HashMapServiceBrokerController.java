/**
 *
 */
package com.hashmap.service.broker.controller;

import com.hashmap.service.broker.service.HashMapBrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gnanesh Arva
 * <p>
 * This controller holds the end points to which application (client) requests for putting and getting entries in custom hash map.
 */
@RestController
public class HashMapServiceBrokerController {

    Logger logger = LoggerFactory.getLogger(HashMapServiceBrokerController.class);

    @Autowired
    private HashMapBrokerService mapBrokerService;

    /**
     * @param instanceId
     * @param key
     * @return
     */
    @RequestMapping(value = "/hash/{instanceId}/{key}", method = RequestMethod.GET)
    public ResponseEntity<Object> get(@PathVariable("instanceId") String instanceId, @PathVariable("key") String key) {
        logger.info("In get. instanceId : " + instanceId + "   ,  key : " + key);
        final Object response = mapBrokerService.get(instanceId, key);
        logger.info("In get. response : " + response);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("{}", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @param instanceId
     * @param key
     * @param value
     * @return
     */
    @RequestMapping(value = "/hash/{instanceId}/{key}", method = RequestMethod.PUT)
    public ResponseEntity<String> put(@PathVariable("instanceId") String instanceId, @PathVariable("key") String key,
                                      @RequestBody String value) {
        mapBrokerService.put(instanceId, key, value);
        logger.info("In put. iId  : " + instanceId + " , key : " + key + " , value : " + value);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    /**
     * @param instanceId
     * @param key
     * @return
     */
    @RequestMapping(value = "/hash/{instanceId}/{key}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("instanceId") String instanceId,
                                         @PathVariable("key") String key) {
        final Object response = mapBrokerService.get(instanceId, key);
        if (response != null) {
            mapBrokerService.delete(instanceId, key);
            return new ResponseEntity<>("{}", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{}", HttpStatus.GONE);
        }
    }

}
