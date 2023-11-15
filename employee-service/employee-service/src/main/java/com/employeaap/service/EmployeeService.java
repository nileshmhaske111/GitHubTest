package com.employeaap.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeaap.entity.Employee;
import com.employeaap.feignclient.AddressClient;
import com.employeaap.repository.EmployeeRepo;
import com.employeaap.response.AddressResponse;
import com.employeaap.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper mapper;

//	communication using webclient
//	@Autowired
//	private WebClient webClient;

// Communication using rest template
//	@Autowired
//	private RestTemplate restTemplate; 

// Communication using feign client
	@Autowired
	private AddressClient addressClient;

	public EmployeeResponse getEmployeeById(int id) {

		Optional<Employee> employee = employeeRepo.findById(id);
		EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
//	Using Webclient		
//		AddressResponse addressResponse = webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();

//	Using RestTemplate
//		AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8081/address-service/address/{id}", AddressResponse.class, id);
//		employeeResponse.setAddressResponse(addressResponse); 
		
//	Using Feign client
		ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
		employeeResponse.setAddressResponse(addressResponse.getBody()); 
		return employeeResponse;
	}
}
