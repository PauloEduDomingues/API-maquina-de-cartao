package br.com.loja.api.model.integration;

public class Fee {
	
	private String percentage;
	private String installments;
	
	
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getInstallments() {
		return installments;
	}
	public void setInstallments(String installments) {
		this.installments = installments;
	}
}
