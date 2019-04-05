package br.com.marquei.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("marqueiapi")
public class MarqueiApiProperty {

	private String originPermitida = "https://localhost:8000";
	private final Seguranca seguranca = new Seguranca();
	public static class Seguranca{
		private boolean enableHttps; 

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
	}
	public Seguranca getSeguranca() {
		return seguranca;
	}
	public String getOriginPermitida() {
		return originPermitida;
	}
	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}
	
}
