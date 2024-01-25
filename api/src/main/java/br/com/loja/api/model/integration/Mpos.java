package br.com.loja.api.model.integration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mpos {
	
	@JsonProperty("D1Anticipation")
	private D1Anticipation d1Anticipation;

	
	public D1Anticipation getD1Antecipation() {
		return d1Anticipation;
	}

	public void setD1Antecipation(D1Anticipation D1Antecipation) {
		this.d1Anticipation = D1Antecipation;
	}
}
