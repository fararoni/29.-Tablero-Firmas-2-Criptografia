package mx.gob.tecdmx.firmapki.api.documento;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.tecdmx.firmapki.DTOResponseUserInfo;
import mx.gob.tecdmx.firmapki.api.firma.DAOAltaDocumento;
import mx.gob.tecdmx.firmapki.security.ServiceSecurity;
import mx.gob.tecdmx.firmapki.utils.dto.DTOResponse;
import mx.gob.tecdmx.firmapki.utils.dto.PayloadAltaDocumento;

@RestController
@RequestMapping(path = "/api/documento")
public class RestControllerDocumento {

	@Autowired
	ServiceSecurity serviceSecurity;
	
	@Autowired
	ServiceRechazarDocumento serviceRechazarDocumento;
	
	@Autowired
	ServiceEliminarDocumento serviceEliminarDocumento;
	
	@Autowired
	ServiceEditarDocumento serviceEditarDocumento;
	
	@Autowired
	ServiceEnviarDocumento serviceEnviarDocumento;
	
	@Autowired
	ServiceModoCapturaDocumento serviceModoCapturaDocumento;
	
	@Autowired
	ServiceDocumentoByUsuario serviceDocumentoByUsuario;

	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/rechazar-documento", produces = "application/json")
	public ResponseEntity<DTOResponse> rechazarDocumento(@RequestBody PayloadRechazarDocumento payload,
			HttpServletRequest request) {
		DTOResponse res = new DTOResponse();
		DTOResponseUserInfo userInfo = serviceSecurity.getUserInfo(request, res);
		serviceRechazarDocumento.rechazarDocumento(payload, res, userInfo);
		return ResponseEntity.ok().header(null).body(res);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar-documento/{idDocumento}", produces = "application/json")
	public ResponseEntity<DTOResponse> eliminarDocumento(@PathVariable("idDocumento") int idDocumento,HttpServletRequest request) {
		DTOResponse res = new DTOResponse();
		DTOResponseUserInfo userInfo = serviceSecurity.getUserInfo(request, res);
		if (userInfo == null) { 
			return ResponseEntity.ok().header(null).body(res);
		}
		serviceEliminarDocumento.eliminarDocumento(idDocumento, res, userInfo);
		return ResponseEntity.ok().header(null).body(res);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.PUT, path = "/editar-documento/{idDocumento}", produces = "application/json")
	public ResponseEntity<DTOResponse> editarDocumento(@PathVariable("idDocumento") int idDocumento,
			@RequestBody PayloadAltaDocumento payload,
			HttpServletRequest request) {
		DTOResponse res = new DTOResponse();
		DTOResponseUserInfo userInfo = serviceSecurity.getUserInfo(request, res);
		if (userInfo == null) { 
			return ResponseEntity.ok().header(null).body(res);
		}
		DAOAltaDocumento documentoAlta = null;
		boolean docAlta = serviceEditarDocumento.editarDocumento(idDocumento, payload, documentoAlta, res, userInfo);
		if (docAlta) {
			res.setData(payload);
		}
		return ResponseEntity.ok().header(null).body(res);
	}

	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/enviar-documento", produces = "application/json")
	public ResponseEntity<DTOResponse> enviarDocumento(@RequestBody PayloadEnviarDocumento payload,
			HttpServletRequest request) {
		DTOResponse res = new DTOResponse();
		DTOResponseUserInfo userInfo = serviceSecurity.getUserInfo(request, res);
		boolean enviado = serviceEnviarDocumento.enviarDocumento(payload.getIdDocumento(), userInfo, res);
		if (!enviado) {
			return ResponseEntity.ok().header(null).body(res);
		}
		return ResponseEntity.ok().header(null).body(res);
	}

	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/alta-documento-modo-captura", produces = "application/json")
	public ResponseEntity<DTOResponse> createDocumentoCaptura(@RequestBody PayloadAltaDocumento payload,
			HttpServletRequest request) {
		DTOResponse res = new DTOResponse();
		DTOResponseUserInfo userInfo = serviceSecurity.getUserInfo(request, res);
		if (userInfo == null) {
			return ResponseEntity.ok().header(null).body(res);
		}
		DAOAltaDocumento documentoAlta = null;
		boolean docAlta = serviceModoCapturaDocumento.altaDocumentoModoCaptura(payload, documentoAlta, res, userInfo);
		if (docAlta) {
			res.setData(payload);
		}
		return ResponseEntity.ok().header(null).body(res);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET, path = "/documentos-usuario", produces = "application/json")
	public ResponseEntity<DTOResponse> documentosUsuario(HttpServletRequest request) {

		DTOResponse res = new DTOResponse();
		DTOResponseUserInfo userInfo = serviceSecurity.getUserInfo(request, res);
		serviceDocumentoByUsuario.getDocumentosByUsuario(res, userInfo);
		return ResponseEntity.ok().header(null).body(res);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET, path = "/numero-serie", produces = "application/json")
	public ResponseEntity<DTOResponse> getNumeroSerieUser(HttpServletRequest request) {
		DTOResponse res = new DTOResponse();
		DTOResponseUserInfo userInfo = serviceSecurity.getUserInfo(request, res);
		serviceDocumentoByUsuario.getUserSerial(userInfo, res);
		return ResponseEntity.ok().header(null).body(res);
	}
}
