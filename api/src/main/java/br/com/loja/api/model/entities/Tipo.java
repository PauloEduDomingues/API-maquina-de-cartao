package br.com.loja.api.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tipo_id;
	private String nome;
	
	public Tipo() {
		
	}
	public Tipo(long id, String nome) {
		this.tipo_id = id;
		this.nome = nome;
	}
	public long getId() {
		return tipo_id;
	}
	public void setId(long id) {
		this.tipo_id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
