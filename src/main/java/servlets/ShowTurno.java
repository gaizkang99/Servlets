package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Consulta;
import service.Service;

/**
 * Servlet implementation class ShowTurno
 */

@WebServlet(name="/ShowTurno", urlPatterns={"/turnoEnClase.do"})
public class ShowTurno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTurno() {
        super();
        // TODO Auto-generated constructor stub
        service = new Service();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ArrayList<Consulta> consultas = service.consultarMarcados();
			request.setAttribute("consultas", consultas);
			getServletContext().getRequestDispatcher("/jsp/turnoEnClase.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*Función que pulsando el validar recoja esa linea y la borre actualizando
		 la lista de alumnos en cola*/
		try {
			service.actualizarListaConsulta(request.getParameter("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
