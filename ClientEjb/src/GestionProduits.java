
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import metier.entities.Categorie;
import metier.entities.Ligne_Produit_Prom;
import metier.entities.Ligne_Produit_Prom_Pk;
import metier.entities.Produits;
import metier.entities.Promotion;
import metier.sessions.IRemote;
import metier.sessions.Implementation;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.naming.*;
import javax.swing.JRadioButton;
import java.awt.List;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JDateChooser;


import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JSeparator;
import java.awt.Choice;
import java.awt.Font;

public class GestionProduits extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesignation;
	private JTextField txtDescription;
	private JTextField txtPrix;
	private JTable table;
	private JTextField txtMotCl;
	private JTextField txtChoisirUnePhoto;
	private JTable table_1;
	private JTextField txtNomDuCategorie;
	private JTextField txtDescription_1;
	private JTextField textField;
	private JTable table_2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionProduits frame = new GestionProduits();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
      
	}
	
	 public static boolean numerique(String ch){
	        boolean ok=true;
	            int i=0;
	            String chiffre="0123456789";
	            while(i<ch.length() && ok==true){
	                if(chiffre.indexOf(ch.charAt(i))==-1)
	                    ok=false;
	                else
	                    i++;
	            }
	        
	        return ok;
	    }

	public static boolean existeList(String ch , List l) {
		int i=0;
		boolean ok=false;
		while(i<l.getItemCount() && !ok) {
			if(l.getItem(i).equals(ch))
				ok=true;
				else
					i++;
		}
		return ok;
	}
	
	public GestionProduits() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1131, 772);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1105, 722);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		tabbedPane.addTab("Gestion des produits", null, panel, null);
		panel.setLayout(null);
		
		txtDesignation = new JTextField();
		txtDesignation.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		txtDesignation.setBounds(10, 85, 185, 20);
		txtDesignation.setText("Designation");
		panel.add(txtDesignation);
		txtDesignation.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		txtDescription.setBounds(10, 122, 185, 20);
		txtDescription.setText("Description");
		txtDescription.setColumns(10);
		panel.add(txtDescription);
		
		txtPrix = new JTextField();
		txtPrix.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		txtPrix.setBounds(10, 167, 131, 20);
		txtPrix.setText("Prix");
		txtPrix.setColumns(10);
		panel.add(txtPrix);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		comboBox.setBounds(10, 212, 131, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Categorie"}));
		comboBox.setToolTipText("");
		panel.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		spinner.setBounds(10, 248, 45, 40);
		spinner.setModel(new SpinnerNumberModel(0, 0, 3000, 1));
		panel.add(spinner);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(249, 75, 841, 379);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Designation", "Prix", "Quantit\u00E9", "Categorie", "Photo"
			}
		));
		table.setBounds(0, 0, 831, 368);
		panel_3.add(table);
		
		txtMotCl = new JTextField();
		txtMotCl.setForeground(new Color(255, 255, 255));
		txtMotCl.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMotCl.setBackground(new Color(0, 191, 255));
		txtMotCl.setText("Mot cl\u00E9");
		txtMotCl.setBounds(896, 30, 120, 29);
		panel.add(txtMotCl);
		txtMotCl.setColumns(10);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/Add-to-database.png")));
		btnAjouter.setBounds(259, 11, 61, 53);
		panel.add(btnAjouter);
		
		JButton btnModifier = new JButton("");
		btnModifier.setIcon(new ImageIcon("C:\\Users\\Scofield\\eclipse-workspace\\ClientEjb\\src\\icons\\download-database.png"));
		btnModifier.setBounds(391, 11, 54, 53);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("");
		btnSupprimer.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/Remove-from-database (1).png")));
		btnSupprimer.setBounds(526, 11, 54, 53);
		panel.add(btnSupprimer);
		
		JButton btnRechercher = new JButton("");
		btnRechercher.setIcon(new ImageIcon("C:\\Users\\Scofield\\eclipse-workspace\\ClientEjb\\src\\icons\\search_magnifi-48.png"));
		btnRechercher.setBounds(791, 11, 67, 53);
		panel.add(btnRechercher);
		
		txtChoisirUnePhoto = new JTextField();
		txtChoisirUnePhoto.setText("Choisir une photo");
		txtChoisirUnePhoto.setBounds(10, 299, 131, 20);
		panel.add(txtChoisirUnePhoto);
		txtChoisirUnePhoto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 335, 229, 242);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Scofield\\eclipse-workspace\\ClientEjb\\src\\icons\\fchooser.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser f=new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter( "jpg", "jpeg","png","gif");
		        f.setFileFilter(filter);
		        f.showOpenDialog(null);
		        File file=f.getSelectedFile();
		        String filename=file.getAbsolutePath();
		        txtChoisirUnePhoto.setText(filename);
		        int slch=filename.lastIndexOf('\\');
				String PATH=filename.substring(slch+1,filename.length());
				 ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(PATH));
		           Image img = ii.getImage();
		           ii = new ImageIcon(img.getScaledInstance(160, 160,Image.SCALE_SMOOTH));
				lblNewLabel.setIcon(ii);;
			}
		});
		btnNewButton.setBounds(141, 299, 54, 20);
		panel.add(btnNewButton);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		tabbedPane.addTab("Gestion des categories", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 191, 255));
		panel_4.setBounds(274, 67, 792, 455);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		table_1.setBackground(new Color(255, 255, 255));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Categorie", "Nom Categorie", "Description"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(115);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(142);
		table_1.setBounds(10, 37, 775, 239);
		panel_4.add(table_1);
		
		txtNomDuCategorie = new JTextField();
		txtNomDuCategorie.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		txtNomDuCategorie.setText("Nom du categorie");
		txtNomDuCategorie.setColumns(10);
		txtNomDuCategorie.setBounds(10, 113, 176, 20);
		panel_1.add(txtNomDuCategorie);
		
		txtDescription_1 = new JTextField();
		txtDescription_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		txtDescription_1.setText("Description");
		txtDescription_1.setColumns(10);
		txtDescription_1.setBounds(10, 152, 176, 20);
		panel_1.add(txtDescription_1);
		
		JButton button = new JButton("");
		button.setBackground(new Color(72, 209, 204));
		button.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/Add-to-database.png")));
		button.setBounds(376, 11, 54, 64);
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(new Color(72, 209, 204));
		button_1.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/download-database.png")));
		button_1.setBounds(456, 11, 55, 64);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBackground(new Color(72, 209, 204));
		button_2.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/Remove-from-database (1).png")));
		button_2.setBounds(536, 11, 55, 64);
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		tabbedPane.addTab("Gestion des promotions", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Code Promotion");
		label.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 11));
		label.setBounds(10, 78, 116, 14);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 78, 159, 20);
		panel_2.add(textField);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setToolTipText("");
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(136, 111, 159, 20);
		panel_2.add(dateChooser);
		
		JLabel label_1 = new JLabel("Date debut");
		label_1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 11));
		label_1.setBounds(10, 114, 73, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Date fin");
		label_2.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 11));
		label_2.setBounds(10, 153, 59, 14);
		panel_2.add(label_2);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setBounds(136, 150, 159, 20);
		panel_2.add(dateChooser_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(136, 192, 159, 20);
		panel_2.add(spinner_1);
		
		JLabel label_3 = new JLabel("Pourcentage");
		label_3.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 11));
		label_3.setBounds(10, 192, 79, 14);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Produits");
		label_4.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 11));
		label_4.setBounds(10, 234, 59, 14);
		panel_2.add(label_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(136, 234, 159, 20);
		panel_2.add(comboBox_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/Remove-from-database (1).png")));
		button_3.setBounds(602, 11, 59, 50);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/download-database.png")));
		button_4.setBounds(475, 11, 59, 50);
		panel_2.add(button_4);
		
		JButton btnA = new JButton("");
		btnA.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/Add-to-database.png")));
		btnA.setBounds(349, 11, 59, 50);
		panel_2.add(btnA);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 191, 255));
		panel_5.setBounds(329, 83, 742, 307);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		table_2.setBackground(new Color(255, 255, 255));
		table_2.setBounds(0, 11, 732, 307);
		panel_5.add(table_2);
		
		List list_1 = new List();
		list_1.setBounds(10, 310, 159, 198);
		panel_2.add(list_1);
		
		btnAjouter.setOpaque(false);
		btnAjouter.setContentAreaFilled(false);
		btnAjouter.setBorderPainted(false);
		
		btnModifier.setOpaque(false);
		btnModifier.setContentAreaFilled(false);
		btnModifier.setBorderPainted(false);
		
		btnSupprimer.setOpaque(false);
		btnSupprimer.setContentAreaFilled(false);
		btnSupprimer.setBorderPainted(false);
		
		btnRechercher.setOpaque(false);
		btnRechercher.setContentAreaFilled(false);
		btnRechercher.setBorderPainted(false);
		
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		
		button_2.setOpaque(false);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		
		button_3.setOpaque(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		
		button_4.setOpaque(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		
		btnA.setOpaque(false);
		btnA.setContentAreaFilled(false);
		btnA.setBorderPainted(false);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionProduits g =new GestionProduits();
				g.dispose();
				GestionProduits gg=new GestionProduits();
				gg.setVisible(true);
			}
		});
		button_5.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/view-refresh-48.png")));
		button_5.setOpaque(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setBounds(10, 11, 67, 53);
		panel_2.add(button_5);
		
		txtMotCl.setBorder (BorderFactory.createLineBorder (new Color (0, 0, 0, 0), 2));
		
		try {
			Properties p=new Properties();
			p.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
		    p.put("jboss.naming.client.ejb.context", true);
			Context ctx=new InitialContext(p);
		    final IRemote stub=(IRemote)ctx.lookup("ejb:TestAll/ProjetEjb/Implementation!metier.sessions.IRemote");
		   
		    
		    //Gestion des promotions
		    
		    
		    //lister les produits dans le combobox 
		    ArrayList<Produits> lsp=new ArrayList<Produits>();
		    lsp=(ArrayList<Produits>) stub.listerProduit();
		    for(int i=0;i<lsp.size();i++)
		    	comboBox_2.addItem(lsp.get(i).getDesignation());
		    
		    
		    
		    //consulter les promotions
		    DefaultTableModel modelp = new DefaultTableModel();
			modelp.setColumnIdentifiers(new Object[]{"IdPromotion", "Date Debut", "Date Fin", "Pourcentage", "Produits"});
		     Object[] rowp = new Object[6];
		       rowp[0]="IdPromotion";
			   rowp[1]="Date Debut";
			   rowp[2]="Date Fin";
			   rowp[3]="Pourcentage";
			   rowp[4]="Produits";
			   
			   modelp.addRow(rowp);
		    ArrayList<Promotion> lsprom=new ArrayList<Promotion>();
		    lsprom=(ArrayList<Promotion>) stub.listerPromotion();
		    for(int i=0;i<lsprom.size();i++) {
		    	rowp[0]=lsprom.get(i).getIdprom();
		    	rowp[1]=lsprom.get(i).getDatedebut();
		    	rowp[2]=lsprom.get(i).getDatefin();
		    	rowp[3]=lsprom.get(i).getPourcentage();
		    	ArrayList<Long> l=new ArrayList<Long>();
		    	l=(ArrayList<Long>) stub.getIdByProm(lsprom.get(i).getIdprom());
		    	
		    	String chp="";
		    	for(int j=0;j<l.size();j++) {
		    		chp+=stub.getProduit(l.get(j)).getDesignation()+",";
		    	}
		    	rowp[4]=chp;
		    	modelp.addRow(rowp);
		    }
		    table_2.setModel(modelp);
		
		    
		    
		    
		    
		    
			//Modifier une promotion
		    
		   button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table_2.getSelectedRow();
				if(row<1)
					JOptionPane.showMessageDialog(null,"Vous devez selectionner un produit pour le modifier");
				
				else {
					try {
						String idp=table_2.getModel().getValueAt(row, 0).toString();
						Date db= new SimpleDateFormat("yyyy-MM-dd").parse(table_2.getModel().getValueAt(row, 1).toString());
						Date df= new SimpleDateFormat("yyyy-MM-dd").parse(table_2.getModel().getValueAt(row, 2).toString());
						Double pourcentage=Double.parseDouble(table_2.getModel().getValueAt(row, 3).toString());
						if(db.after(df) || numerique(pourcentage.toString())) {
							JOptionPane.showMessageDialog(null, "Verifier les données à modifier");
						}
						else {
							Promotion p=new Promotion(idp, db, pourcentage, df);
							stub.modifierPromotion(p);
							JOptionPane.showMessageDialog(null, "Promotion modifié avec succes");
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		    
		    comboBox_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(!existeList(comboBox_2.getSelectedItem().toString(), list_1))
					list_1.add(comboBox_2.getSelectedItem().toString());
					
					
				}
			});
		    
		    //Ajout des promotions
		    
			btnA.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				String code=textField.getText();
				Date db=dateChooser.getDate();
				Date df=dateChooser_1.getDate();
				
				if(code.equals("") || db.after(df)|| spinner_1.getValue().toString().equals("") || list_1.getItemCount()==0) {
					JOptionPane.showMessageDialog(null, "Verifier vos champs ou verifier que vous avez selectionner des produits");
				}
				else {
				Double pourcentage=Double.parseDouble(spinner_1.getValue().toString());
				Promotion p=new Promotion(code, db, pourcentage, df);
				stub.ajouterPromotion(p);
				for(int i=0;i<list_1.getItemCount();i++) {
				Ligne_Produit_Prom_Pk lp=new Ligne_Produit_Prom_Pk(code,stub.getProduitParNom(list_1.getItem(i).toString()).getIdProduit());
				Ligne_Produit_Prom lpp=new Ligne_Produit_Prom(lp);
		        stub.ajouterLignePromotion(lpp);
		        
		        Long id=(stub.getProduitParNom(list_1.getItem(i).toString()).getIdProduit());
		        String des=(list_1.getItem(i).toString());
		        String desc=(stub.getProduitParNom(list_1.getItem(i).toString()).getDescription());
		        String ph=(stub.getProduitParNom(list_1.getItem(i).toString()).getPhoto());
		        Categorie cat=(stub.getProduitParNom(list_1.getItem(i).toString()).getCat());
		        int qte=(stub.getProduitParNom(list_1.getItem(i).toString()).getQuantite());
		        double pri=stub.getProduitParNom(list_1.getItem(i).toString()).getPrix();
		        double nvp=pri-pri*(pourcentage/100);
		        Produits pr=new Produits(id,des,desc,nvp,ph,qte,cat,true);
		        
		        stub.modifierProduit(pr);
		        //modifier prix produit
		        //
				}
				JOptionPane.showMessageDialog(null, "Promotion ajouté avec succes");
				
				}
				}
			});
			
			//supprimer une promotion
			button_3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int row=table_2.getSelectedRow();
					if(row<1)
						JOptionPane.showMessageDialog(null,"Vous devez selectionner un produit pour le modifier");
					else {
						String idp=table_2.getModel().getValueAt(row, 0).toString();
						stub.supprimerPromotion(idp);
						JOptionPane.showMessageDialog(null, "promotion supprimée");
					}
					
				}
			});
		    
			//Gestion des categories
			  
		    ArrayList<Categorie>list =new ArrayList<Categorie>();
			list=(ArrayList<Categorie>) stub.listerCat();
			for(int i=0;i<list.size();i++)
			comboBox.addItem(list.get(i).getNomCategorie());
			DefaultTableModel modelCat = new DefaultTableModel();
			modelCat.setColumnIdentifiers(new Object[]{"IdCategorie","Nom Categorie","Description"});
		     Object[] rowc = new Object[3];
		       rowc[0]="IdCategorie";
			   rowc[1]="Nom Categorie";
			   rowc[2]="Description";
			   modelCat.addRow(rowc);
			for(int i=0;i<list.size();i++) {
			
			   rowc[0]=list.get(i).getIdCategorie();
			   rowc[1]=list.get(i).getNomCategorie();
			   rowc[2]=list.get(i).getDescription();
			   modelCat.addRow(rowc);
			     
			}
			table_1.setModel(modelCat);
			
			JButton button_6 = new JButton("");
			button_6.setIcon(new ImageIcon(GestionProduits.class.getResource("/icons/view-refresh-48.png")));
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionProduits g =new GestionProduits();
					g.dispose();
					GestionProduits gg=new GestionProduits();
					gg.setVisible(true);
				}
			});
			button_6.setOpaque(false);
			button_6.setContentAreaFilled(false);
			button_6.setBorderPainted(false);
			button_6.setBounds(10, 11, 67, 53);
			panel_1.add(button_6);
			
			//Ajouter une categorie
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(txtDescription_1.getText().equals("")||txtNomDuCategorie.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Verifier vos données");
					}
					else {
				   stub.ajouterCat(new Categorie(txtNomDuCategorie.getText(),txtDescription_1.getText()));
					JOptionPane.showMessageDialog(null, "Categorie ajouté avec succes");

					}
				}
			});
			
			
			//Modifier categorie
			
			button_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int row=table_1.getSelectedRow();
					//String value=table.getModel().getValueAt(row, 2).toString();
					if(row<1)
						JOptionPane.showMessageDialog(null,"Vous devez selectionner une categorie pour la modifier");
					else {
						if(txtDescription_1.getText().equals("")||txtNomDuCategorie.getText().equals("")) 
							JOptionPane.showMessageDialog(null, "les donnees sont incorrectes");
						else {
					long idp=Long.parseLong(table_1.getModel().getValueAt(row, 0).toString());
					String nom=table_1.getModel().getValueAt(row, 1).toString();
					String desc=table_1.getModel().getValueAt(row, 2).toString();
					Categorie c=new Categorie(idp,nom,desc);
					stub.modifierCategorie(c);
					JOptionPane.showMessageDialog(null,"Modification avec succes ");
						}
					}
					
				}
			});
			
			//Supprimer une categorie
			button_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int column = 0;
					int row = table_1.getSelectedRow();
					if(row<1)
						JOptionPane.showMessageDialog(null,"Vous devez selectionner une categorie pour la supprimer");
					else {
					String value = table_1.getModel().getValueAt(row, column).toString();
					stub.supprimerCategorie(Long.parseLong(value));
					
					((DefaultTableModel)table_1.getModel()).removeRow(row);
					
					JOptionPane.showMessageDialog(null, "cette categorie a ete supprimé avec succes ainsi que tous ses produits "+value);
					}
					}
			});
			
			//Gestions des produits
			
			
			ArrayList<Produits> lst=new ArrayList<Produits>();
			lst=(ArrayList<Produits>) stub.listerProduit();
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(new Object[]{"Id", "Designation", "Prix", "Quantit\u00E9", "Categorie", "Photo"});
		     Object[] row = new Object[6];
		       row[0]="IDProduit";
			   row[1]="Designation";
			   row[2]="Prix";
			   row[3]="Quantité";
			   row[4]="Categorie";
			   row[5]="Photo";
			   model.addRow(row);
			for(int i=0;i<lst.size();i++) {
			
			   row[0]=lst.get(i).getIdProduit();
			   row[1]=lst.get(i).getDesignation();
			   row[2]=lst.get(i).getPrix();
			   row[3]=lst.get(i).getQuantite();
			   row[4]=lst.get(i).getCat().getNomCategorie();
			   String path=lst.get(i).getPhoto();
			   row[5]=path;
			   model.addRow(row);
			  
				   
			}
			
			table.setModel(model);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Id"}));
			comboBox_1.setBounds(628, 34, 89, 20);
			panel.add(comboBox_1);
			
			JButton btnRefresh = new JButton("");
			btnRefresh.setOpaque(false);
			btnRefresh.setContentAreaFilled(false);
			btnRefresh.setBorderPainted(false);
			btnRefresh.setIcon(new ImageIcon("C:\\Users\\Scofield\\eclipse-workspace\\ClientEjb\\src\\icons\\view-refresh-48.png"));
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionProduits g =new GestionProduits();
					g.dispose();
					GestionProduits gg=new GestionProduits();
					gg.setVisible(true);
				}
			});
			btnRefresh.setBounds(10, 11, 67, 53);
			panel.add(btnRefresh);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBackground(Color.BLACK);
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(896, 62, 194, 2);
			panel.add(separator_1);
			
			
			for(int i=0;i<lst.size();i++)
				comboBox_1.addItem(lst.get(i).getIdProduit());
			
			//Afficher image
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					String path =table.getValueAt(table.getSelectedRow(), 5).toString();
					

					 ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(path));
			           Image img = ii.getImage();
			           ii = new ImageIcon(img.getScaledInstance(160, 160,Image.SCALE_SMOOTH));
					lblNewLabel.setIcon(ii);;
					
				}
			});
			//Ajouter un produit
			
			btnAjouter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					

					//control de saisie
					if(comboBox.getSelectedIndex()<1 || spinner.getValue().toString().equals("0")|| txtDescription.getText().equals("") ||txtDesignation.getText().equals("") || !numerique(txtPrix.getText()) || txtChoisirUnePhoto.getText().indexOf("C:\\Users\\Scofield\\eclipse-workspace\\ClientEjb\\src\\")<0)
					{
						JOptionPane.showMessageDialog(null, "Verifier vos données");
					}
					else
					{
					long idc=stub.getIdCatParNom(comboBox.getSelectedItem().toString()).getIdCategorie();
					String path=txtChoisirUnePhoto.getText();
					int slch=path.lastIndexOf('\\');
					String PATH=path.substring(slch+1,path.length());
					Produits p=new Produits(txtDesignation.getText(),txtDescription.getText(),Double.parseDouble(txtPrix.getText()),PATH,Integer.parseInt(spinner.getValue().toString()));
					stub.ajouterProduit(p,idc);
				    JOptionPane.showMessageDialog(null,"Votre produit a ete ajouté avec succes");
				    txtDescription.setText("Description");
				    txtDesignation.setText("Designation");
				    txtPrix.setText("Prix");
				    txtChoisirUnePhoto.setText("choisir une photo");
				    Produits pp=stub.getMaxId();
				  
				    Object[] row = new Object[6];
				    row[0]=pp.getIdProduit();
				    row[1]=pp.getDesignation();
				    row[2]=pp.getPrix();
				    row[3]=pp.getQuantite();
				    row[4]=pp.getCat().getNomCategorie();
				    row[5]=p.getPhoto();
				    model.addRow(row);
				    table.setModel(model);
					
					
					}
				    
					
				}
			});
			
			//supprimer un produit
			btnSupprimer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(comboBox_1.getSelectedIndex()==0)
						JOptionPane.showMessageDialog(null,"Vous devez selectionner un produit");
		
					else {
					Long idp=Long.parseLong(comboBox_1.getSelectedItem().toString());
					stub.supprimerProduit(idp);
					
				    
					JOptionPane.showMessageDialog(null, "ce produit a ete supprimé avec succes ");
					}
					
					
					
				}
			});
			//modifier un produit
		btnModifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int row=table.getSelectedRow();
				//String value=table.getModel().getValueAt(row, 2).toString();
				if(row<1)
					JOptionPane.showMessageDialog(null,"Vous devez selectionner un produit pour le modifier");
				else
				{
				long idp=Long.parseLong(table.getModel().getValueAt(row, 0).toString());
				
				String des=table.getModel().getValueAt(row, 1).toString();
				double prix =Double.parseDouble(table.getModel().getValueAt(row, 2).toString());
				int quantite=Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
				String cat=(table.getModel().getValueAt(row, 4).toString());
				String photo=table.getModel().getValueAt(row, 5).toString();
				
				
				boolean ok=false;
				int i=0;
				while(i<comboBox.getItemCount() && !ok)
				{
					if(comboBox.getItemAt(i).toString().toUpperCase().equals(cat.toUpperCase()))
						ok=true;
					else
						i++;
				}
				
				if(!ok && photo.indexOf("C:\\Users\\Scofield\\eclipse-workspace\\ClientEjb\\src\\")<0) {
					JOptionPane.showMessageDialog(null,"");
				
				
				}
				else {
					Categorie c=stub.getIdCatParNom(cat);
					//control de saisie
					Produits p=new Produits(idp,des,stub.getProduit(idp).getDescription(),prix,photo,quantite,c);
					stub.modifierProduit(p);
					JOptionPane.showMessageDialog(null,"Modification avec succes ");
				}
					
				}
				
				
			}
		});
		//chercher des produits
		btnRechercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtMotCl.getText().equals(""))
					JOptionPane.showMessageDialog(null,"vous devez saisir le code du produit à consulter ");
				else {
			
			String mc=txtMotCl.getText();
			ArrayList<Produits> p=(ArrayList<Produits>) stub.listerProduitParMotCle(mc);
			if(p.size()==0)
				JOptionPane.showMessageDialog(null,"Aucun produit corresepend à ce critere de recherche");
			else {
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new Object[]{"Id", "Designation", "Prix", "Quantit\u00E9", "Categorie", "Photo"});
			     Object[] row = new Object[6];
			       row[0]="IDProduit";
				   row[1]="Designation";
				   row[2]="Prix";
				   row[3]="Quantité";
				   row[4]="Categorie";
				   row[5]="Photo";
				   model.addRow(row);
				for(int i=0;i<p.size();i++) {
				
				   row[0]=p.get(i).getIdProduit();
				   row[1]=p.get(i).getDesignation();
				   row[2]=p.get(i).getPrix();
				   row[3]=p.get(i).getQuantite();
				   row[4]=p.get(i).getCat().getNomCategorie();
				   String path=p.get(i).getPhoto();
				   row[5]=path;
				   model.addRow(row);
				  
					   
				}
				     
				
				
				table.setModel(model);
			}
				
			
				}
				
			}
		});
		ctx.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		};
		
		
	}
}