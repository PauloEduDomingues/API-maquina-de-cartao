package br.com.loja.api.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Metodo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long metodo_id;
	private String nome;
	
	public Metodo() {
		
	}
	public Metodo(long id, String nome) {
		this.metodo_id = id;
		this.nome = nome;
	}
	
	public long getId() {
		return metodo_id;
	}
	public void setId(long id) {
		this.metodo_id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
