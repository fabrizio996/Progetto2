package it.sincrono.crm.tipologiche.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.sincrono.crm.domain.entities.TipoContratto;
import it.sincrono.crm.responses.GenericListResponse;
import it.sincrono.crm.responses.GenericResponse;
import it.sincrono.crm.responses.Status;
import it.sincrono.crm.tipologiche.services.TipoContrattoService;

@RestController
public class TipoContrattoController {
	@Autowired
	private TipoContrattoService service;

	@RequestMapping(value = "/crmtipologiche/tipo-contratto", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericListResponse<TipoContratto>> getAll() {
		HttpEntity<GenericListResponse<TipoContratto>> entity;
		GenericListResponse<TipoContratto> response = new GenericListResponse<>();

		response.setList(service.getAll());
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}

	@RequestMapping(value = "/crmtipologiche/tipo-contratto/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<GenericResponse<TipoContratto>> getOne(@PathVariable("id") Integer id) {
		HttpEntity<GenericResponse<TipoContratto>> entity;
		GenericResponse<TipoContratto> response = new GenericResponse<>();

		response.setObject(service.getOne(id));
		response.setStatus(new Status(0, "success"));

		entity = new HttpEntity<>(response);

		return entity;
	}

	@RequestMapping(value = "/crmtipologiche/tipo-contratto", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody HttpEntity<Status> insertOne(@RequestBody TipoContratto tipoContratto) {
		HttpEntity<Status> entity;

		service.insertOne(tipoContratto);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}

	@RequestMapping(value = "/crmtipologiche/tipo-contratto", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody HttpEntity<Status> updateOne(@RequestBody TipoContratto tipoContratto) {
		HttpEntity<Status> entity;

		service.updateOne(tipoContratto);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}

	@RequestMapping(value = "/crmtipologiche/tipo-contratto/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody HttpEntity<Status> deleteOne(@PathVariable("id") Integer id) {
		HttpEntity<Status> entity;

		service.deleteOne(id);

		entity = new HttpEntity<>(new Status(0, "success"));

		return entity;
	}
}
