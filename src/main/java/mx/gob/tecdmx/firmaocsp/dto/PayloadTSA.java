package mx.gob.tecdmx.firmaocsp.dto;

public class PayloadTSA {
	String responseOCSP;
	String certificado;
	public String getResponseOCSP() {
		return responseOCSP;
	}
	public void setResponseOCSP(String responseOCSP) {
		this.responseOCSP = responseOCSP;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	
	

}
