package mx.gob.tecdmx.firmapki.api.documento;

import java.util.Date;
import java.util.List;

public class PayloadAltaDocumento {
	
	String folio;
	String folioEspecial;
	String numExpediente;
	String tipoDestino;
	String tipoDocumento;
	String tipoPrioridad;
	String asunto;
	String contenido;
	Date fechaLimiteFirma;
	List<String> configuraciones;
	List<String> notificaciones;
	boolean  enOrden;
	List<DTOFirmanteDestinatario> firmantes;
	List<DTOFirmanteDestinatario> destinatarios;
	List<DTODocAdjunto> documentosAdjuntos;
	
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getFolioEspecial() {
		return folioEspecial;
	}
	public void setFolioEspecial(String folioEspecial) {
		this.folioEspecial = folioEspecial;
	}
	public String getNumExpediente() {
		return numExpediente;
	}
	public void setNumExpediente(String numExpediente) {
		this.numExpediente = numExpediente;
	}
	public String getTipoDestino() {
		return tipoDestino;
	}
	public void setTipoDestino(String tipoDestino) {
		this.tipoDestino = tipoDestino;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getTipoPrioridad() {
		return tipoPrioridad;
	}
	public void setTipoPrioridad(String tipoPrioridad) {
		this.tipoPrioridad = tipoPrioridad;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Date getFechaLimiteFirma() {
		return fechaLimiteFirma;
	}
	public void setFechaLimiteFirma(Date fechaLimiteFirma) {
		this.fechaLimiteFirma = fechaLimiteFirma;
	}
	public List<String> getConfiguraciones() {
		return configuraciones;
	}
	public void setConfiguraciones(List<String> configuraciones) {
		this.configuraciones = configuraciones;
	}
	public List<String> getNotificaciones() {
		return notificaciones;
	}
	public void setNotificaciones(List<String> notificaciones) {
		this.notificaciones = notificaciones;
	}
	public boolean isEnOrden() {
		return enOrden;
	}
	public void setEnOrden(boolean enOrden) {
		this.enOrden = enOrden;
	}
	public List<DTOFirmanteDestinatario> getFirmantes() {
		return firmantes;
	}
	public void setFirmantes(List<DTOFirmanteDestinatario> firmantes) {
		this.firmantes = firmantes;
	}
	public List<DTOFirmanteDestinatario> getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(List<DTOFirmanteDestinatario> destinatarios) {
		this.destinatarios = destinatarios;
	}
	public List<DTODocAdjunto> getDocumentosAdjuntos() {
		return documentosAdjuntos;
	}
	public void setDocumentosAdjuntos(List<DTODocAdjunto> documentosAdjuntos) {
		this.documentosAdjuntos = documentosAdjuntos;
	}
	
	
	
	
}