/**
 *
 */
package com.hashmap.service.broker.client.config;

import com.hashmap.service.broker.client.connector.HashServiceInfo;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Gnanesh Arva
 */
@Configuration
@EnableAutoConfiguration
public class ServiceBrokerClientAutoConfig {

    Logger logger = LoggerFactory.getLogger(ServiceBrokerClientAutoConfig.class);

    @Bean
    public Cloud createCloud() {
        return new CloudFactory().getCloud();
    }

    @Bean
    public HashServiceInfo haashServiceInfo() {
        final List<ServiceInfo> serviceInfos = createCloud().getServiceInfos();
        logger.info("In HashServiceInfoCreator haashServiceInfo method,  serviceInfos : " + serviceInfos);
        for (ServiceInfo serviceInfo : serviceInfos) {
            logger.info("Service name : " + serviceInfo.getId());
            if (serviceInfo instanceof HashServiceInfo) {
                return (HashServiceInfo) serviceInfo;
            }
        }
        throw new RuntimeException("Unable to find bound HashBroker instance!");
    }

    @Bean
    RestTemplate restTemplate() {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(haashServiceInfo().getUsername(), haashServiceInfo().getPassword()));
        httpClient.setCredentialsProvider(credentialsProvider);
        ClientHttpRequestFactory reqFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(reqFactory);
    }
}
