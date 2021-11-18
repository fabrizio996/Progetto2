package it.sincrono.crm.anagrafica.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.crm.anagrafica.services.AnagraficaService;
import it.sincrono.crm.domain.entities.Anagrafica;
import it.sincrono.crm.responses.GenericListResponse;
import it.sincrono.crm.responses.GenericResponse;
import it.sincrono.crm.responses.Status;

@RestController
public class AnagraficaController {
	@Autowired
	private AnagraficaService service;

	@RequestMapping(value = "/crmanagrafiche", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericListResponse<Anagrafica>> getAll() {
		HttpEntity<GenericListResponse<Anagrafica>> entity;
		GenericListResponse<Anagrafica> response = new GenericListResponse<>();

		response.setList(service.getAll());
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}

	@RequestMapping(value = "/crmanagrafiche/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericResponse<Anagrafica>> getOne(@PathVariable("id") Integer id) {
		GenericResponse<Anagrafica> response = new GenericResponse<>();
		Status status = null;
		Anagrafica result = null;

		try {
			result = service.getOne(id);
			status = new Status(0, "sucess");
		} catch (Exception e) {
			status = new Status(1, e.getMessage());
		}

		response.setObject(result);
		response.setStatus(status);

		return new HttpEntity<>(response);
	}

	@RequestMapping(value = "/crmanagrafiche", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody HttpEntity<Status> insertOne(@Valid @RequestBody Anagrafica anagrafica, BindingResult result) {
		HttpEntity<Status> entity;
		Status status;

		if (result.hasErrors()) {
			status = new Status(2, result.getFieldError().getDefaultMessage());
		} else {
			service.insertOne(anagrafica);
			status = new Status(0, "success");
		}

		entity = new HttpEntity<>(status);

		return entity;
	}

	@RequestMapping(value = "/crmanagrafiche", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody HttpEntity<Status> updateOne(@Valid @RequestBody Anagrafica anagrafica, BindingResult result) {
		HttpEntity<Status> entity;
		Status status;

		if (result.hasErrors()) {
			status = new Status(2, result.getFieldError().getDefaultMessage());
		} else {
			service.updateOne(anagrafica);
			status = new Status(0, "success");
		}

		entity = new HttpEntity<>(status);

		return entity;
	}

	@RequestMapping(value = "/crmanagrafiche/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody HttpEntity<Status> deleteOne(@PathVariable("id") Integer id) {
		HttpEntity<Status> entity;
		Status status;

		try {
			service.deleteOne(id);
			status = new Status(0, "sucess");
		} catch (Exception e) {
			status = new Status(1, e.getMessage());
		}

		entity = new HttpEntity<>(status);

		return entity;
	}
}