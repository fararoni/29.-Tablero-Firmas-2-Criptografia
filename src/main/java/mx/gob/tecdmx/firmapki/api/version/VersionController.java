package mx.gob.tecdmx.firmapki.api.version;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v")
public class VersionController {

	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
	public String version() {
		return "API-PKI v1.0";
	}
	
}
