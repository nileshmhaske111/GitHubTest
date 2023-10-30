package com.employeaap.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employeaap.entity.Employee;
import com.employeaap.repository.EmployeeRepo;
import com.employeaap.response.AddressResponse;
import com.employeaap.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper mapper;
	
//	@Autowired
//	private WebClient webClient;

	@Autowired
	private RestTemplate restTemplate; 

	public EmployeeResponse getEmployeeById(int id) {

		Optional<Employee> employee = employeeRepo.findById(id);
		EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
		
//		AddressResponse addressResponse = webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();
	AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8081/address-service/address/{id}", AddressResponse.class, id); 
        employeeResponse.setAddressResponse(addressResponse); 
		return employeeResponse;
	}
}
