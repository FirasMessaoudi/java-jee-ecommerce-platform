
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.entities.Categorie;
import metier.entities.Produits;
import metier.sessions.IRemote;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestionCategories extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionCategories frame = new GestionCategories();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionCategories() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionDesCategories = new JLabel("Gestion des categories");
		lblGestionDesCategories.setBounds(312, 11, 221, 14);
		contentPane.add(lblGestionDesCategories);
		
		JLabel lblNomDuCategorie = new JLabel("Nom du categorie");
		lblNomDuCategorie.setBounds(51, 62, 115, 14);
		contentPane.add(lblNomDuCategorie);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(51, 101, 84, 14);
		contentPane.add(lblDescription);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 59, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(176, 98, 129, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(51, 152, 115, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(51, 186, 115, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(51, 220, 116, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnConsulterLesCategories = new JButton("Consulter les categories");
		btnConsulterLesCategories.setBounds(533, 58, 190, 23);
		contentPane.add(btnConsulterLesCategories);
		
		JPanel panel = new JPanel();
		panel.setBounds(385, 140, 491, 268);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 491, 257);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Id Categorie", "Nom Categorie", "Description"},
			},
			new String[] {
				"Id Categorie", "Nom Categorie", "Description"
			}
		));
		panel.add(table);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu m=new Menu();
				m.setVisible(true);
				new GestionCategories().setVisible(false);
			}
		});
		btnRetour.setBounds(51, 254, 115, 23);
		contentPane.add(btnRetour);
		
		table_1 = new JTable();
		table_1.setBounds(245, 186, 40, 124);
		contentPane.add(table_1);
		try {
			Properties p=new Properties();
			p.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
			Context ctx=new InitialContext(p);
			p.put("jboss.naming.client.ejb.context", true);
			    final IRemote stub=(IRemote)ctx.lookup("ejb:TestAll/ProjetEjb/Implementation!metier.sessions.IRemote");
		    
		btnConsulterLesCategories.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<Categorie> lst=new ArrayList<Categorie>();
				lst=(ArrayList<Categorie>) stub.listerCat();
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new Object[]{"IdCategorie","Nom Categorie","Description"});
			     Object[] row = new Object[3];
			       row[0]="IdCategorie";
				   row[1]="Nom Categorie";
				   row[2]="Description";
				   model.addRow(row);
				for(int i=0;i<lst.size();i++) {
				
				   row[0]=lst.get(i).getIdCategorie();
				   row[1]=lst.get(i).getNomCategorie();
				   row[2]=lst.get(i).getDescription();
				   model.addRow(row);
				     
				}
				
				table.setModel(model);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//control saisie
				stub.ajouterCat(new Categorie(textField_1.getText(),textField_2.getText()));
				JOptionPane.showMessageDialog(null, "Votre categorie a ete ajouté avec succes");
				textField_1.setText("");
				textField_2.setText("");
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int column = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
				stub.supprimerCategorie(Long.parseLong(value));
				
				((DefaultTableModel)table.getModel()).removeRow(row);
				
				JOptionPane.showMessageDialog(null, "cette categorie a ete supprimé avec succes ainsi que tous ses produits "+value);
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				//String value=table.getModel().getValueAt(row, 2).toString();
				if(row<1)
					JOptionPane.showMessageDialog(null,"Vous devez selectionner un produit pour le modifier");
				else {
				long idp=Long.parseLong(table.getModel().getValueAt(row, 0).toString());
				String nom=table.getModel().getValueAt(row, 1).toString();
				String desc=table.getModel().getValueAt(row, 2).toString();
				//control saisie
				Categorie c=new Categorie(idp,nom,desc);
				stub.modifierCategorie(c);
				JOptionPane.showMessageDialog(null,"Modification avec succes ");
				}
				
			}
		});
		}catch(Exception e) {};
		}
}
