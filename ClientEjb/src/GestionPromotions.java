
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.entities.Ligne_Produit_Prom;
import metier.entities.Ligne_Produit_Prom_Pk;
import metier.entities.Produits;
import metier.entities.Promotion;
import metier.sessions.IRemote;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.List;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;

public class GestionPromotions extends JFrame {
    JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPromotions frame = new GestionPromotions();
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
	public GestionPromotions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionDesPromotions = new JLabel("Gestion des promotions");
		lblGestionDesPromotions.setBounds(148, 11, 183, 14);
		contentPane.add(lblGestionDesPromotions);
		
		JLabel lblDateDebut = new JLabel("Date debut");
		lblDateDebut.setBounds(10, 98, 73, 14);
		contentPane.add(lblDateDebut);
		
		JLabel lblDateFin = new JLabel("Date fin");
		lblDateFin.setBounds(10, 137, 59, 14);
		contentPane.add(lblDateFin);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(281, 89, 120, 23);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(281, 125, 120, 23);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(281, 164, 120, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnConsulterLesPromotions = new JButton("Consulter les promotions");
		btnConsulterLesPromotions.setBounds(408, 89, 207, 23);
		contentPane.add(btnConsulterLesPromotions);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu m=new Menu();
				m.setVisible(true);
		frame.setVisible(false);
			}
		});
		btnRetour.setBounds(28, 302, 89, 23);
		contentPane.add(btnRetour);
		
		JLabel lblProduits = new JLabel("Produits");
		lblProduits.setBounds(10, 218, 59, 14);
		contentPane.add(lblProduits);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(136, 218, 166, 20);
		contentPane.add(comboBox);
		
		JLabel lblPourcentage = new JLabel("Pourcentage");
		lblPourcentage.setBounds(10, 176, 79, 14);
		contentPane.add(lblPourcentage);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Byte((byte) 0), new Byte((byte) 0), new Byte((byte) 100), new Byte((byte) 1)));
		spinner.setBounds(136, 176, 91, 20);
		contentPane.add(spinner);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.getCalendarButton().setToolTipText("");
		dateChooser.setBounds(136, 95, 91, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setBounds(136, 134, 91, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblCodePromotion = new JLabel("Code Promotion");
		lblCodePromotion.setBounds(10, 62, 116, 14);
		contentPane.add(lblCodePromotion);
		
		textField = new JTextField();
		textField.setBounds(136, 62, 91, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(418, 120, 526, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"IdPromotion", "Date Debut", "Date Fin", "Produits", "Nouveau prix"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(0, 0, 526, 286);
		panel.add(table);
		try {
			Properties p=new Properties();
			p.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
			Context ctx=new InitialContext(p);
			p.put("jboss.naming.client.ejb.context", true);
			    final IRemote stub=(IRemote)ctx.lookup("ejb:TestWebService/ProjetEjb/Implementation!metier.sessions.IRemote");
			    ArrayList<Produits> lst=new ArrayList<Produits>();
			    lst=(ArrayList<Produits>)stub.listerProduit();
			    for(int i=0;i<lst.size();i++)
			    	comboBox.addItem(lst.get(i).getDesignation());
			    btnAjouter.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
			            double pourcentage=Double.parseDouble(spinner.getValue().toString());
			            Promotion p= new Promotion(textField.getText(),dateChooser.getDate(),pourcentage,dateChooser_1.getDate());
			            Ligne_Produit_Prom_Pk lp=new Ligne_Produit_Prom_Pk(textField.getText(),stub.getProduitParNom(comboBox.getSelectedItem().toString()).getIdProduit());
			            Ligne_Produit_Prom lpp=new Ligne_Produit_Prom(lp);
			            stub.ajouterPromotion(p);
			            stub.ajouterLignePromotion(lpp);
			         
			            
			            JOptionPane.showMessageDialog(null,p.getIdprom());
			            
						
					}
				});
		    btnConsulterLesPromotions.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(new Object[]{"IdPromotion", "Date Debut", "Date Fin", "Produits", "Nouveau prix"});
				     Object[] row = new Object[6];
				       row[0]="IdPromotion";
					   row[1]="Date Debut";
					   row[2]="Date Fin";
					   row[3]="Produits";
					   row[4]="Nouveau prix";
					   model.addRow(row);
					   
					
				}
			});
		
		}catch(Exception e) {};
	}
}
