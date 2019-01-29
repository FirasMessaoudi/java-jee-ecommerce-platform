

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

import metier.entities.Compte;
import metier.entities.Lign_Comm;
import metier.entities.Lign_comm_Pk;
import metier.entities.LignePanier;
import metier.sessions.ILocal;
import metier.entities.Client;
import metier.entities.Commande;;

/**
 * Servlet implementation class ControlSignUp
 */
@WebServlet(name="ControlSignUp",urlPatterns="/ControlSignUp")
public class ControlSignUp extends HttpServlet {
	@EJB
	private ILocal metier;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//verifier login and email
		String nom=request.getParameter("nom").toString();
		String email=request.getParameter("Email").toString();
		String login=request.getParameter("Login").toString();
		String password=request.getParameter("password").toString();
		String tel=request.getParameter("tel").toString();
		String adresse=request.getParameter("adresse").toString();
		if(!metier.checkLogin(login).equals("") || !metier.checkEmail(email).equals("")) {
			//login and email already exist
			response.sendRedirect("ClientExiste.jsp");
		}
		else {
		
		HttpSession session = request.getSession();
		ArrayList<LignePanier> cart=(ArrayList<LignePanier>)session.getAttribute("cart");
		if(cart.size()==0) {
			response.sendRedirect("CartEmptyjsp.jsp");
		}
		else {
			metier.addClient(new Client(nom,adresse,email,tel));
			metier.addCompte(new Compte(login, password), metier.maxIdCl());
		Commande c=new Commande(new Date(), "");
		metier.addCmd(c, metier.maxIdCl());
		for(int i=0;i<cart.size();i++) {
			Lign_comm_Pk lck =new Lign_comm_Pk(metier.maxIdCmd(),cart.get(i).getArticle().getIdProduit());
			Lign_Comm lc=new Lign_Comm(lck,cart.get(i).getArticle().getPrix(),cart.get(i).getQuantite());
			metier.AddLc(lc);
		}
		//comùmande enregistrer avec succes
		//rediriger vers detaille commande
		response.sendRedirect("DetailleCommande.jsp");
		cart.clear();
		}
		}
		doGet(request, response);
	}

}
