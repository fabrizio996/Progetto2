package it.sincrono.crm.responses;

import lombok.Data;

@Data
public class GenericResponse<T> {
	private T object;
	private Status status;
}
