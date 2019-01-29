

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.sessions.ILocal;

/**
 * Servlet implementation class ControlCommande
 */
@WebServlet("/ControlCommande")
public class ControlCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @EJB
     private ILocal metier;
     private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String login=request.getParameter("login");
		String pass=request.getParameter("password");
		if(metier.idClientCompte(login, pass)!=0){
			Query req=em.createQuery("select c.Idcomm,p.designation,lc.prix,lc.quantite from Commande c,Produits p,Lign_Comm lc"
					+ "where c.IdClt=:x and c.Idcomm=lc.Idcomm and p.idProduit=lc.idProduit ");
			req.setParameter("x", metier.idClientCompte(login, pass));
			ArrayList ls=new ArrayList();
			ls=(ArrayList) req.getResultList();
			
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
