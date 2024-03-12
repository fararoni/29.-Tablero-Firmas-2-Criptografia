package mx.gob.tecdmx.firmapki;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecurityFilter extends OncePerRequestFilter {
//	seguridad.url.api
//	@Value("${firma.url.security}")
//
	@Value("${firma.url.security}")
	private String securityUrl;
	Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		StringBuffer url = request.getRequestURL();
		if (request.getQueryString() != null) {
			url.append('?').append(request.getQueryString());
		}
		System.out.println(url);

		if (url.toString().contains("/api/escritorio/login-escritorio")) {
			logger.info("sesion activa, redireccionando");
			filterChain.doFilter(request, response);
		} else {

			String token = request.getHeader("Authorization");
			if (token != null && token.startsWith("Bearer")) {
				if (isTokenValid(token, request)) {
					logger.info("sesion activa, redireccionando");
					filterChain.doFilter(request, response);
				} else {
					logger.info("token invalido", token);
					response.setStatus(HttpStatus.UNAUTHORIZED.value());
				}

			} else {
				logger.info("No se encontro el Bearer en el token", token);
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
			}
		}

	}

	private boolean isTokenValid(String token, HttpServletRequest request) {
		HttpPost post = new HttpPost(securityUrl);
		post.addHeader("Content-Type", "application/x-www-form-urlencoded");
		post.addHeader("Authorization", token);
		System.out.println("# isTokenValid [" + token + "]");
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpResponse response = httpClient.execute(post);
			String json = EntityUtils.toString(response.getEntity());
			System.out.println("# json");
			System.out.println( json );
			request.setAttribute("userdata", json);
			logger.info("la sesion esta activa", token);
			return true;

		} catch (Exception e) {
			return false;
		}

	}
}