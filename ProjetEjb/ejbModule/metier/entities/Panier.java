package metier.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Walid
 */
import metier.entities.*;
import java.util.ArrayList;
import java.util.Collections;

public class Panier
{

    ArrayList<LignePanier> lignesPanier;

    public Panier()
    {
        lignesPanier = new ArrayList<LignePanier>();
    }

    @Override
    public String toString()
    {
        String s = "Panier : \n";
        for (LignePanier l : lignesPanier)
        {
            s += l.toString() + "\n";
        }

        return s;

    }

    
    
    public void addArticle(Produits art)
    {
        for (LignePanier lignePanier : lignesPanier)
        {
            if (lignePanier.getArticle().getIdProduit()== art.getIdProduit())
            {
                lignePanier.setQuantite(lignePanier.getQuantite() + 1);
                return;
            }
        }

        lignesPanier.add(new LignePanier(art, 1));
    }

    public void sousArticle(Produits art)
    {
        for (LignePanier lignePanier : lignesPanier)
        {
            if (lignePanier.getArticle().getIdProduit()== art.getIdProduit())
            {
                if (lignePanier.getQuantite() > 1)
                {
                    lignePanier.setQuantite(lignePanier.getQuantite() - 1);
                } else
                {
                    lignesPanier.remove(lignePanier);
                    return ;
                }
            }
        }


    }

    public int getNumberArticle()
    {
        return lignesPanier.size();
    }

    public ArrayList<LignePanier> getLignesPanier()
    {
        return lignesPanier;
    }

    public void removeArticle(Produits art)
    {
        for (LignePanier lignePanier : lignesPanier)
        {
            if (lignePanier.getArticle().getIdProduit()== art.getIdProduit())
            {
                lignesPanier.remove(lignePanier);
                return ;
            }
        }

    }
    
    public void vider()
    {
        try
        {

            while (lignesPanier.get(0) != null)
            {
                lignesPanier.remove(lignesPanier.get(0));
            }

        } catch (Exception e)
        {
        }
               
    }
}
