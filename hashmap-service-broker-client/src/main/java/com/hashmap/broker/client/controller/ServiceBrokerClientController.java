/**
 *
 */
package com.hashmap.broker.client.controller;

import com.hashmap.service.broker.client.connector.HashServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gnanesh Arva
 * <p>
 * You, the developer should hit these end points from browser or command line to see the response.
 */
@RestController
public class ServiceBrokerClientController {
    Logger logger = LoggerFactory.getLogger(ServiceBrokerClientController.class);

    @Autowired
    private HashServiceInfo hashServiceInfo;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/HashBroker/info")
    public HashServiceInfo info() {
        return hashServiceInfo;
    }

    @RequestMapping(value = "/HashBroker/{key}", method = RequestMethod.PUT)
    public ResponseEntity<String> put(@PathVariable("key") String key, @RequestBody String value) {
        logger.info("In put client controller : URI : " + hashServiceInfo.getUri());
        restTemplate.put(hashServiceInfo.getUri() + "/{key}", value, key);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/HashBroker/{key}", method = RequestMethod.GET)
    public ResponseEntity<String> put(@PathVariable("key") String key) {
        logger.info("In get client controller : URI : " + hashServiceInfo.getUri());
        String response = restTemplate.getForObject(hashServiceInfo.getUri() + "/{key}", String.class, key);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
