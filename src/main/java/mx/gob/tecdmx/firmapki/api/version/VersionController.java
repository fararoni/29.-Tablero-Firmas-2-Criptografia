package mx.gob.tecdmx.firmapki.api.version;

import mx.gob.tecdmx.firmapki.SecurityFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v")
public class VersionController {
	Logger logger = LoggerFactory.getLogger(SecurityFilter.class);
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
	public String version() {
		logger.info("version() - /api/v  ");
		return "API-PKI v1.0";
	}
	
}
