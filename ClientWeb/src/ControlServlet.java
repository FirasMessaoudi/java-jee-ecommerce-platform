import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.entities.Produits;
import metier.sessions.ILocal;

/**
 * Servlet implementation class ControlServlet
 */

@WebServlet(name="ControlServlet", urlPatterns=("/ControlServlet"))
public class ControlServlet extends HttpServlet {
	@EJB
	private ILocal metier;
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Produits> lst=new ArrayList<Produits>();
		lst=(ArrayList<Produits>) metier.listerProduit();
		request.setAttribute("Produits", lst);
		request.getRequestDispatcher("Client.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		/*String action=request.getParameter("action");
		if(action.equals("Consulter par mc")) {
		String mc=(request.getParameter("motcle"));
			request.setAttribute("motcle",mc);
		ArrayList<Produits> lst=new ArrayList<Produits>();
			
			lst=(ArrayList<Produits>)metier.listerProduitParMotCle(mc);
		    //Produits p=metier.getProduit(idp);
			request.setAttribute("Produits", lst);
			
		}*/
		//else{
			
		//s	}
	    	//doGet(request, response);
		    //request.getRequestDispatcher("/Client.jsp").forward(request, response);
		
	}

}
