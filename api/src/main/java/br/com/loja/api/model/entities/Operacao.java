package br.com.loja.api.model.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Operacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="cod_tipo", referencedColumnName = "tipo_id")
	private Tipo tipo;
	
	@ManyToOne
	@JoinColumn(name="cod_metodo", referencedColumnName = "metodo_id")
	private Metodo metodo;
	
	@ManyToOne
	@JoinColumn(name="cod_bandeira", referencedColumnName = "bandeira_id")
	private Bandeiras bandeiras;
	
	private int parcelas;
	private double valorbr, valorlq;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime data;
	
	public Operacao() {
		
	}
	public Operacao(Tipo tipo, Metodo metodo, Bandeiras bandeiras, int parcelas, double valorbr, double valorlq) {
		super();
		this.tipo = tipo;
		this.metodo = metodo;
		this.bandeiras = bandeiras;
		this.parcelas = parcelas;
		this.valorbr = valorbr;
		this.valorlq = valorlq;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Metodo getMetodo() {
		return metodo;
	}
	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}
	public int getParcelas() {
		return parcelas;
	}
	public Bandeiras getBandeiras() {
		return bandeiras;
	}
	public void setBandeiras(Bandeiras bandeiras) {
		this.bandeiras = bandeiras;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	public double getValorbr() {
		return valorbr;
	}
	public void setValorbr(double valorbr) {
		this.valorbr = valorbr;
	}
	public double getValorlq() {
		return valorlq;
	}
	public void setValorlq(double valorlq) {
		this.valorlq = valorlq;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
}
