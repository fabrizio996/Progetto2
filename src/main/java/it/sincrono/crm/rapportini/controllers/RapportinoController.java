package it.sincrono.crm.rapportini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.crm.domain.entities.Rapportino;
import it.sincrono.crm.rapportini.services.RapportinoService;
import it.sincrono.crm.responses.GenericListResponse;
import it.sincrono.crm.responses.GenericResponse;
import it.sincrono.crm.responses.Status;

@RestController
public class RapportinoController {
	@Autowired
	private RapportinoService service;

	@RequestMapping(value = "/crmrapportini", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericListResponse<Rapportino>> getAll() {
		HttpEntity<GenericListResponse<Rapportino>> entity;
		GenericListResponse<Rapportino> response = new GenericListResponse<>();

		response.setList(service.findAll());
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}

	@RequestMapping(value = "/crmrapportini/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericResponse<Rapportino>> getOne(@PathVariable("id") Integer id) {
		HttpEntity<GenericResponse<Rapportino>> entity;
		GenericResponse<Rapportino> response = new GenericResponse<>();

		response.setObject(service.findOne(id));
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}

	@RequestMapping(value = "/crmrapportini", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody HttpEntity<Status> insertOne(@RequestBody Rapportino rapportino) {
		HttpEntity<Status> entity;

		service.insertOne(rapportino);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}

	@RequestMapping(value = "/crmrapportini/stipendio/{id}/{mese}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericResponse<Double>> getOne(@PathVariable("id") Integer id,
			@PathVariable("mese") Integer mese) {
		HttpEntity<GenericResponse<Double>> entity;
		GenericResponse<Double> response = new GenericResponse<>();

		response.setObject(service.calcolaStipendio(id, mese));
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}
}
