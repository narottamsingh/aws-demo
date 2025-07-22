package com.bce.awsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetadataController {

  @Autowired
  private MetadataService metadataService;

  @GetMapping("/region")
  public String getRegion() {
    try {
      return metadataService.getRegion();
    } catch (Exception e) {
      return "NOT ABLE TO FETCH REGION " + e.getMessage();
    }
  }

  @GetMapping("/availability-zone")
  public String getAvailabilityZone() {
    try {
      return metadataService.getAvailabilityZone();
    } catch (Exception e) {
      return "NOT ABLE TO FETCH AVALABILITY ZONE  " + e.getMessage();
    }
  }
}