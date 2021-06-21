package br.com.exemple.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="tb_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVeiculo;
	
	@JsonProperty("Valor")
	private String valor;

	@NotBlank(message = "{marca.not.blank}")
	@JsonProperty("Marca")
	private String marca;

	@NotBlank(message = "{modelo.not.blank}")
	@JsonProperty("Modelo")
	private String modelo;

	@NotNull(message = "{anoModelo.not.null}")
	@JsonProperty("AnoModelo")
	private String anoModelo;

	@JsonProperty("CodigoFipe")
	private String codigoFipe;

	@JsonProperty("TipoVeiculo")
	private int tipoVeiculo;
	
	private String CPF;
	
	@Transient
	private String diaRodizio;
	
	@Transient
	private boolean rodizioAtivo;
	
	public Veiculo(String valor, String marca, String modelo, String anoModelo, String codigoFipe, int tipoVeiculo, String cpf) {
		super();
		this.valor = valor;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.codigoFipe = codigoFipe;
		this.tipoVeiculo = tipoVeiculo;
		CPF = cpf;
		this.rodizioAtivo();
		this.diaRodizio();
		
	}
	
	public void diaRodizio() {
		char lastNumber = this.anoModelo.charAt(this.anoModelo.length() - 1);
		if (lastNumber == '0' || lastNumber == '1') {
			this.diaRodizio = "segunda-feira";
		} else if (lastNumber == '2' || lastNumber == '3') {
			this.diaRodizio = "terça-feira";
		} else  if (lastNumber == '4' || lastNumber == '5') {
			this.diaRodizio = "quarta-feira";
		} else  if (lastNumber == '6' || lastNumber == '7') {
			this.diaRodizio = "quinta-feira";
		} else  if (lastNumber == '8' || lastNumber == '9') {
			this.diaRodizio = "sexta-feira";
		} 
	}
	
	public void rodizioAtivo() {
		char lastNumber = this.anoModelo.charAt(this.anoModelo.length() - 1);
		Calendar calendar = Calendar.getInstance();
		int dia = calendar.get(Calendar.DAY_OF_WEEK); 
		this.rodizioAtivo = false;
		switch (dia) {
		    case Calendar.MONDAY:
		    	if (lastNumber == '0' || lastNumber == '1') {
					this.rodizioAtivo = true;
				}
		        break;
		    case Calendar.TUESDAY:
		    	if (lastNumber == '2' || lastNumber == '3') {
					this.rodizioAtivo = true;
				}
		        break;
		    case Calendar.WEDNESDAY:
		    	if (lastNumber == '4' || lastNumber == '5') {
					this.rodizioAtivo = true;
				}
		        break;
		    case Calendar.THURSDAY:
		    	if (lastNumber == '6' || lastNumber == '7') {
					this.rodizioAtivo = true;
				}
		        break;
		    case Calendar.FRIDAY:
		    	if (lastNumber == '8' || lastNumber == '9') {
					this.rodizioAtivo = true;
				}
		        break;
		    default:
		    	this.rodizioAtivo = false;
		}
	}
	
}
