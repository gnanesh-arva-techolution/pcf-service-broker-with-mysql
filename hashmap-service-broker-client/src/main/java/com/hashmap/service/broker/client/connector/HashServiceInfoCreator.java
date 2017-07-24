package com.hashmap.service.broker.client.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import java.util.Map;

/**
 * @author Gnanesh Arva
 */

public class HashServiceInfoCreator extends CloudFoundryServiceInfoCreator<HashServiceInfo> {

    Logger logger = LoggerFactory.getLogger(HashServiceInfoCreator.class);

    public HashServiceInfoCreator() {
        super(new Tags("hashmap-service"));
        logger.info("In HashServiceInfoCreator constructor...");
    }

    @Override
    public HashServiceInfo createServiceInfo(Map<String, Object> serviceData) {
        final Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");
        logger.info("In HashServiceInfoCreator createServiceInfo method,  credentials : " + credentials);
        final String id = (String) serviceData.get("name");
        final String uri = (String) credentials.get("uri");
        final String username = (String) credentials.get("username");
        final String password = (String) credentials.get("password");

        return new HashServiceInfo(id, uri, username, password);
    }

    @Override
    public boolean accept(Map<String, Object> serviceData) {
        final Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");
        logger.info("In HashServiceInfoCreator accept method,  credentials : " + credentials);
        final String uri = (String) credentials.get("uri");
        final String username = (String) credentials.get("username");
        final String password = (String) credentials.get("password");
        return username != null &&
                password != null &&
                uri != null;
    }
}
