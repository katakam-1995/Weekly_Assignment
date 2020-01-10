package com.otsi.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-employee")
public interface RolesService {

}
