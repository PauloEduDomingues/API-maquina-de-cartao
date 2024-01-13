package br.com.loja.api.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bandeiras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bandeira_id;
	private String nome;
	
	public Bandeiras() {
		
	}
	public Bandeiras(long id, String nome) {
		this.bandeira_id = id;
		this.nome = nome;
	}
	public long getId() {
		return bandeira_id;
	}
	public void setId(long id) {
		this.bandeira_id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
