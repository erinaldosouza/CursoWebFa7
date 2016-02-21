package br.com.cursowebfa7.filtro;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Contador
 */
@WebFilter("*.xhtml")
public class Contador implements Filter {

    /**
     * Default constructor. 
     */
    public Contador() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Map<String, Integer> map = (Map<String, Integer>) request.getServletContext().getAttribute("contaAcessos");
		
		String[] requestSplit = ((HttpServletRequest)request).getRequestURI().split("/");
		String rss = requestSplit[requestSplit.length-1];
		
		if(!"jsf.js.xhtml".endsWith(rss)) {
			if(map.containsKey(rss)) {
				map.put(rss, map.get(rss)+1);
			} else {
				map.put(rss, 1);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
