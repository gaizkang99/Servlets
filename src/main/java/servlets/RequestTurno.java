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
 * Servlet implementation class RequestTurno
 */
@WebServlet(name="/RequestTurno", urlPatterns={"/turnoDeClase.do"})
public class RequestTurno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Service service; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestTurno() {
        super();
        // TODO Auto-generated constructor stub
        service = new Service();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Consulta> consultas;
		try {
			consultas = service.consultarMarcados();
			request.setAttribute("consultas", consultas);
			getServletContext().getRequestDispatcher("/jsp/turnoDeClase.jsp").forward(request, response);
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
		try {
			service.insertarConsulta(request.getParameter("nombre"), request.getParameter("salir"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
