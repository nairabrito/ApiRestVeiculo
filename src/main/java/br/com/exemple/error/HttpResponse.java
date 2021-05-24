package br.com.exemple.error;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true )
public class HttpResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;

	private Object object;

	private List< ? > objects;
	
	public HttpResponse( HttpStatus status ) {
		this.status = status.value();
	}

	public HttpResponse( HttpStatus status, Object object ) {
		this.status = status.value();
		this.object = object;
	}

	public HttpResponse( HttpStatus status, List< ? > objects ) {
		this.status = status.value();
		this.objects = objects;
	}
	
	public static HttpResponse insertSuccess() {
		return new HttpResponse( HttpStatus.CREATED, "Registro(s) inserido(s) com sucesso!" );
	}

	public static HttpResponse response( List< ? > objects ) {
		return new HttpResponse( HttpStatus.OK, objects );
	}

	public static HttpResponse Error() {
		return new HttpResponse( HttpStatus.INTERNAL_SERVER_ERROR, "Não foi possível encontrar a sua requisição!" );
	}

	public static HttpResponse responseSuccess() {
		return new HttpResponse( HttpStatus.ACCEPTED );
	}
	
	public static HttpResponse conflict() {
		return new HttpResponse( HttpStatus.CONFLICT, "Já existe um usuário cadastrado com esse E-MAIL ou CPF!" );
	}
}
