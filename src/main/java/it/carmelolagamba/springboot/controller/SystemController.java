package it.carmelolagamba.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.carmelolagamba.springboot.config.ApplicationProperties;
import it.carmelolagamba.springboot.config.SecretsProperties;
import it.carmelolagamba.springboot.dto.system.InfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "System Information")
public class SystemController {

	@Autowired
	private ApplicationProperties config;

	@Autowired
	private SecretsProperties secretsProperties;

	@ApiOperation(value = "Alive test")
	@RequestMapping(method = RequestMethod.GET, path = "/ping")
	public String ping() {
		return "pong";
	}

	@ApiOperation(value = "Get system info")
	@RequestMapping(method = RequestMethod.GET, path = "/info")
	public InfoDto info() {

		InfoDto infoDto = new InfoDto();

		infoDto.setEnvironment(config.getEnvironment());
		infoDto.setName(config.getName());
		infoDto.setUrl(config.getUrl());
		infoDto.setPort(config.getPort());

		return infoDto;
	}


	@ApiOperation(value = "Get secrets")
	@RequestMapping(method = RequestMethod.GET, path = "/secrets")
	public String secrets() {
		return secretsProperties.getUsername()+":"+secretsProperties.getPassword();
	}

}


//curl --resolve "scaffold.carmelolg.io:80:$( minikube ip )" -i http://scaffold.carmelolg.io/info