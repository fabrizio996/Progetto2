package it.sincrono.crm.contratto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.crm.contratto.services.ContrattoService;
import it.sincrono.crm.domain.entities.Contratto;
import it.sincrono.crm.responses.GenericListResponse;
import it.sincrono.crm.responses.GenericResponse;
import it.sincrono.crm.responses.Status;

@RestController
public class ContrattoController {
	@Autowired
	private ContrattoService service;

	@RequestMapping(value = "/crmcontratti", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericListResponse<Contratto>> getAll() {
		HttpEntity<GenericListResponse<Contratto>> entity;
		GenericListResponse<Contratto> response = new GenericListResponse<>();

		response.setList(service.findAll());
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}

	@RequestMapping(value = "/crmcontratti/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericResponse<Contratto>> getOne(@PathVariable("id") Integer id) {
		HttpEntity<GenericResponse<Contratto>> entity;
		GenericResponse<Contratto> response = new GenericResponse<>();

		response.setObject(service.findOne(id));
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}

	@RequestMapping(value = "/crmcontratti", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody HttpEntity<Status> insertOne(@RequestBody Contratto contratto) {
		HttpEntity<Status> entity;

		service.insert(contratto);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}

	@RequestMapping(value = "/crmcontratti", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody HttpEntity<Status> updateOne(@RequestBody Contratto contratto) {
		HttpEntity<Status> entity;

		service.update(contratto);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}

	@RequestMapping(value = "/crmcontratti/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody HttpEntity<Status> deleteOne(@PathVariable("id") Integer id) {
		HttpEntity<Status> entity;

		service.delete(id);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}
}
