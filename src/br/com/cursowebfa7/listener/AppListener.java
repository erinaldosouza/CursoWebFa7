package br.com.cursowebfa7.listener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.cursowebfa7.model.Usuario;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
	public final static Map<String, Usuario> usuariosMap  = new HashMap<String, Usuario>();
	public final static Map<String, Integer> contaAcessos = new HashMap<String, Integer>();
	
	/**
     * Default constructor. 
     */
    public AppListener() {
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }
 
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servlet)  { 
    	ServletContext context = servlet.getServletContext();
    	configUsuarios();
    	context.setAttribute("usuariosMap", usuariosMap);
    	context.setAttribute("contaAcessos", contaAcessos);
    }

    /**
     * Carrega os usuários do "banco" em um objeto global acessivel por todo o sistema.
     * @author erinaldo.souza
     * 
     */
	private void configUsuarios() {
		usuariosMap.put("123321", new Usuario("123", "321", "Usurio1", "usuario1@gmail.com", new Date()));
		usuariosMap.put("456654", new Usuario("456", "654", "Usurio2", "usuario2@hotmail.com", new Date()));
		usuariosMap.put("789987", new Usuario("789", "987", "Usurio3", "usuario3@gmail.com", new Date()));
	}
	
}
