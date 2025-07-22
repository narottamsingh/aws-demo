package com.bce.awsdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@ComponentScan
@Service
public class MetadataService {

  private static final String METADATA_URL = "http://169.254.169.254/latest/meta-data";

  @Autowired
  private  RestTemplate restTemplate;

  public String getAvailabilityZone() {
    return restTemplate.getForObject(METADATA_URL + "/placement/availability-zone", String.class);
  }

  public String getRegion() {
    String az = getAvailabilityZone();
    return az.substring(0, az.length() - 1); // Strip last character to get region (e.g., "us-east-1a" -> "us-east-1")
  }
}