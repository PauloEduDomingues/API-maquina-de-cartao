package br.com.loja.api.model.integration;

public class D1Anticipation {

	private Mastercard mastercard;
	private Elo elo;
	private Visa visa;
	private Hipercard hipercard;
	
	
	public Mastercard getMastercard() {
		return mastercard;
	}
	public void setMastercard(Mastercard mastercard) {
		this.mastercard = mastercard;
	}
	public Elo getElo() {
		return elo;
	}
	public void setElo(Elo elo) {
		this.elo = elo;
	}
	public Visa getVisa() {
		return visa;
	}
	public void setVisa(Visa visa) {
		this.visa = visa;
	}
	public Hipercard getHipercard() {
		return hipercard;
	}
	public void setHipercard(Hipercard hipercard) {
		this.hipercard = hipercard;
	}

}
