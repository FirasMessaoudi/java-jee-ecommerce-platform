/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import metier.entities.*;
import metier.sessions.ILocal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;

/**
 *
 * @author Walid
 */
@WebServlet(name="PanierServlet", urlPatterns=("/PanierServlet"))
public class PanierServlet extends HttpServlet
{
	@EJB
	private ILocal metier;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    	
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
       // processRequest(request, response);
    	String action=request.getParameter("action");
    	HttpSession session = request.getSession();
    	
    	if(action.equals("addtocart")) {
        if(session.getAttribute("cart") == null) {
        	ArrayList<LignePanier> cart=new ArrayList<LignePanier>();
        	Produits p=new Produits();
        	Long id=Long.parseLong(request.getParameter("id").toString());
        	p=metier.getProduit(id);
        	
        	cart.add(new LignePanier(p,1));
            session.setAttribute("cart", cart);
        }
        else {
        	ArrayList<LignePanier> cart=(ArrayList<LignePanier>)session.getAttribute("cart");
        	Produits p=new Produits();
        	Long id=Long.parseLong(request.getParameter("id").toString());
        	p=metier.getProduit(id);
        	int index=isExisting(id, cart);
        	if(index==-1)
        	cart.add(new LignePanier(p,1));
        	else {
        		int q=cart.get(index).getQuantite()+1;
        		cart.get(index).setQuantite(q);
        	}
        	session.setAttribute("cart", cart);
        }
        request.getRequestDispatcher("Panier.jsp").forward(request, response);
        }
    	else if(action.equals("delete")) {
    		ArrayList<LignePanier> cart=(ArrayList<LignePanier>)session.getAttribute("cart");
    		Long id=Long.parseLong(request.getParameter("id").toString());
    		int index=isExisting(id, cart);
    		cart.remove(index);
    		session.setAttribute("cart", cart);
    		 request.getRequestDispatcher("Panier.jsp").forward(request, response);
    	}
    }
    private int isExisting(Long id,ArrayList<LignePanier> cart) {
    	for(int i=0;i<cart.size();i++)
    		if(cart.get(i).getArticle().getIdProduit()==id)
    			return i;
    	return -1;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
