package com.raphael.votacoop.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raphael.votacoop.clients.responses.CpfResponse;

@FeignClient(url = "${client.url.cpf-validator}", name="cpf-validator")
public interface CpfClient {

	@RequestMapping (method = RequestMethod.GET, value = "/users/{cpf}")
	CpfResponse getCpf(@PathVariable String cpf);
}
