package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.Ahorcado;
import main.java.Palabra;

/**
 * Servlet implementation class ahorcadoServlet
 */
@WebServlet("/ahorcadoServlet")
public class ahorcadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	private Ahorcado ahorcado;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ahorcadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String palActual = ahorcado.getPalabraActual();
		int errores = ahorcado.getErrores();
		String resultado = ahorcado.getResultado();
		response.sendRedirect(request.getContextPath() + "/ahorcado.jsp?estado="+resultado+"&errores="+errores+"&oculta=" + palActual);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("iniciar") != null) {
			ahorcado = new Ahorcado();
			//ahorcado.comenzarJuego();
			ahorcado.setPalabra(new Palabra("facil","esp","Ahorcado","Ahorcado"));
		} else {
			ahorcado.ingresarLetra(request.getParameter(("letra")));				
		}	
		doGet(request, response);
	}

}
