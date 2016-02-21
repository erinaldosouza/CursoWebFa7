package br.com.cursowebfa7.listener;

import java.util.HashMap;

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
    	context.setAttribute("usuariosMap", new HashMap<String, Usuario>());
    	context.setAttribute("contaAcessos", new HashMap<String, Integer>());
    			
    }
	
}
