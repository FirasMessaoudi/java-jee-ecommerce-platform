

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.sessions.ILocal;
import metier.sessions.IRemote;
import metier.entities.*;

/**
 * Servlet implementation class ControlLogin
 */
@WebServlet("/ControlLogin")
public class ControlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ILocal metier;
	private IRemote metier1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String login=request.getParameter("login").toString();
		String pass=request.getParameter("password").toString();
		Long id=metier.idClientCompte(login, pass);
		if(id!=0) {
			HttpSession session = request.getSession();
			
			ArrayList<LignePanier> cart=(ArrayList<LignePanier>)session.getAttribute("cart");
			if(cart.size()==0)
			{
				response.sendRedirect("CartEmptyjsp.jsp");
			}
			
			else {
			Commande c=new Commande(new Date(), "");
			metier.addCmd(c, id);
			for(int i=0;i<cart.size();i++) {
				Lign_comm_Pk lck =new Lign_comm_Pk(metier.maxIdCmd(),cart.get(i).getArticle().getIdProduit());
				Lign_Comm lc=new Lign_Comm(lck,cart.get(i).getArticle().getPrix()*cart.get(i).getQuantite(),cart.get(i).getQuantite());
				metier.AddLc(lc);
				/*Produits p=metier.getProduit(cart.get(i).getArticle().getIdProduit());
				p.setQuantite(p.getQuantite()-cart.get(i).getQuantite());
				metier1.modifierProduit(p);*/
				
			}
			cart.clear();
			response.sendRedirect("DetailleCommande.jsp");
			//commande enregistrer avec suces
			//rediriger vers page succes +detaille du commandes
	
		request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
		else {
			response.sendRedirect("ClientInexistant.jsp");
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
