package br.com.cursowebfa7.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class Autenticador  implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		//TODO implementar logica de autentica��o.
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		String requesrUrl = httpRequest.toString();
		chain.doFilter(request, response);
	}
	

	@Override
	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
