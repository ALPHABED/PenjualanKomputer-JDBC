package penjualanKomputer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//AUTHOR GOEN 8 feb 2022 - 15 feb 2022

public class SupervidorUpdate extends JInternalFrame {

	 JInternalFrame superUpdateframe;
	 private JTable table;
	 private JTextField txtID;
	 private JTextField txtNama;
	 private JTextField txtJumlah;
	 private JTextField txtHarga;
	 private JLabel lblInputHarga;
	 private JLabel lblInputId;
	 private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {		  		
					SupervidorUpdate superUpdate = new SupervidorUpdate();
					superUpdate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		/**
	 * Create the application.
	 */
	public SupervidorUpdate() {
		setTitle("Komputer Bahagia Supervisor");
		setClosable(true);
		

  		
		
		initialize();
		
	}
//
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		setBounds(100, 100, 1013, 670);
	
		getContentPane().setLayout(null);
		
		JButton btnInsertData = new JButton("Insert Data");
		btnInsertData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				JFrame a = new JFrame();
				SuperLogin sl = new SuperLogin(a);
				sl.setVisible(true);

				connectInsert();

			}
		});
		btnInsertData.setBounds(36, 394, 97, 25);
		getContentPane().add(btnInsertData);
		
		JLabel lblUpdateDataFor = new JLabel("UPDATE DATA FOR SUPERVISOR");
		lblUpdateDataFor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUpdateDataFor.setBounds(363, 29, 322, 41);
		getContentPane().add(lblUpdateDataFor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(385, 115, 548, 353);
		getContentPane().add(scrollPane);
		
		
		
		connectTwo();
		

		scrollPane.setViewportView(table);
		
		txtID = new JTextField();
		txtID.setBounds(36, 120, 186, 22);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtNama = new JTextField();
		txtNama.setBounds(36, 186, 186, 22);
		getContentPane().add(txtNama);
		txtNama.setColumns(10);
		
		txtJumlah = new JTextField();
		txtJumlah.setBounds(36, 251, 186, 22);
		getContentPane().add(txtJumlah);
		txtJumlah.setColumns(10);
		
		txtHarga = new JTextField();
		txtHarga.setBounds(36, 317, 186, 22);
		getContentPane().add(txtHarga);
		txtHarga.setColumns(10);
		
		JLabel lblInputNama = new JLabel("Input Nama");
		lblInputNama.setBounds(36, 169, 97, 16);
		getContentPane().add(lblInputNama);
		
		JLabel lblNewLabel = new JLabel("Input Jumlah");
		lblNewLabel.setBounds(36, 228, 102, 22);
		getContentPane().add(lblNewLabel);
		
		lblInputHarga = new JLabel("Input Harga");
		lblInputHarga.setBounds(36, 296, 110, 25);
		getContentPane().add(lblInputHarga);
		
		lblInputId = new JLabel("Input Id");
		lblInputId.setBounds(36, 97, 127, 25);
		getContentPane().add(lblInputId);
	}
	
	public void connectInsert() {
		try {
			String dbuser = "root";
	        String dbpassword = "";
	      
	     
	      String url = "jdbc:mysql://localhost/Komputer";
	      
	      Connection con = DriverManager.getConnection(url, dbuser, dbpassword);
		
	      String s = "INSERT INTO item VALUES" + "('"+ this.txtID.getText()+ "','" + this.txtNama.getText() + "','" + this.txtJumlah.getText() + "','" +this.txtHarga.getText() +"')" ;
	     // String s = "INSERT INTO item('ItemId', 'Nama', 'Jumlah', 'Harga') VALUES " + "('"+ 12+ "','" + "barang" + "','" + 23 + "','" +23000 +"')" ;
				
	      System.out.println(s);
		
			 Statement stm = con.createStatement();
		       stm.executeUpdate(s);
		       
		       model.setRowCount(0);
		       connectTwoRefresh();
		      
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void connectTwo() {
		  try  {
		    	
		    	String dbuser = "root";
		        String dbpassword = "";
		      
		     
		      String url = "jdbc:mysql://localhost/Komputer";
		      
		      Connection con = DriverManager.getConnection(url, dbuser, dbpassword);
		    // table penjualan dan informasi 
		      String query = "SELECT * FROM item";
		    
		      Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);
		    
       String columns[] = { "ItemId", "Nama", "Jumlah", "Harga" };
		      String data[][] = new String[100][4];
		    
		      int i = 0;
		      while (res.next()) {
		        int id = res.getInt("ItemID");
		        String nama = res.getString("Nama");
		        String har = res.getString("Harga");
		        String  juml = res.getString("Jumlah");
		        data[i][0] = id + "";
		        data[i][1] = nama;
		        data[i][2] = har;
		        data[i][3] = juml;
		        i++;
		      }
		      model = new DefaultTableModel(data, columns);
		     table = new JTable(model);
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
}
	public void connectTwoRefresh() {
		  try  {
		    	
		    	String dbuser = "root";
		        String dbpassword = "";
		      
		     
		      String url = "jdbc:mysql://localhost/Komputer";
		      
		      Connection con = DriverManager.getConnection(url, dbuser, dbpassword);
		
		      String query = "SELECT * FROM item";
		    
		      Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);
		    
     String columns[] = { "ItemId", "Nama", "Jumlah", "Harga" };
		      String data[][] = new String[100][4];
		      

		      //Vector vc = new Vector();
		      int id;
		      String nama ;
		        String har;
		        String  juml ;
		      int i = 0;
		      while (res.next()) {
		         id = res.getInt("ItemID");
		         nama = res.getString("Nama");
		         har = res.getString("Harga");
		         juml = res.getString("Jumlah");
		        data[i][0] = id + "";
		        data[i][1] = nama;
		        data[i][2] = har;
		        data[i][3] = juml;
		      
		        model.addRow(new Object[] {id,nama,har,juml});
		        i++;
		      }
		    
		        
		      
		       table = new JTable(model);
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
}
}
