package it.sincrono.crm.tipologiche.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.crm.domain.entities.Provincia;
import it.sincrono.crm.responses.GenericListResponse;
import it.sincrono.crm.responses.GenericResponse;
import it.sincrono.crm.responses.Status;
import it.sincrono.crm.tipologiche.services.ProvinciaService;

@RestController
public class ProvinciaController {
	@Autowired
	private ProvinciaService service;

	@RequestMapping(value = "/crmtipologiche/province", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericListResponse<Provincia>> getAll() {
		HttpEntity<GenericListResponse<Provincia>> entity;
		GenericListResponse<Provincia> response = new GenericListResponse<>();

		response.setList(service.getAll());
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}

	@RequestMapping(value = "/crmtipologiche/province/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericResponse<Provincia>> getOne(@PathVariable("id") Integer id) {
		HttpEntity<GenericResponse<Provincia>> entity;
		GenericResponse<Provincia> response = new GenericResponse<>();

		response.setObject(service.getOne(id));
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}

	@RequestMapping(value = "/crmtipologiche/province", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody HttpEntity<Status> insertOne(@RequestBody Provincia provincia) {
		HttpEntity<Status> entity;

		service.insertOne(provincia);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}

	@RequestMapping(value = "/crmtipologiche/province", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody HttpEntity<Status> updateOne(@RequestBody Provincia provincia) {
		HttpEntity<Status> entity;

		service.updateOne(provincia);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}

	@RequestMapping(value = "/crmtipologiche/province/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody HttpEntity<Status> deleteOne(@PathVariable("id") Integer id) {
		HttpEntity<Status> entity;

		service.deleteOne(id);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}
}