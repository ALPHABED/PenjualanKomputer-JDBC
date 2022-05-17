package penjualanKomputer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class operatorClas extends JInternalFrame {
	
	JInternalFrame operator;
	private static JTextField txtTotal;
	private static JTextField txtBayar;
	private static JTextField txtKembalian;
	private JTable table_1;
	private JTextField txtIDpembelian;
	private JTextField txtHarga;
	 private DefaultTableModel model;
	 private JTextField txtItemID;
	 private JTextField txtJmlhItem;
	 
	 int bayar;
	 int kembalian;
	 int totalBayar;
	 
	 String data[][] = new String[20][4];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					operatorClas operatorFrame = new operatorClas();
					operatorFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public operatorClas() {
		setClosable(true);
		setTitle("Komputer Bahagia Operator");
		
		setBounds(100, 100, 1089, 759);
		  
		  try  {
	    	
	    	String dbuser = "root";
	        String dbpassword = "";
	      
	     
	      String url = "jdbc:mysql://localhost/Komputer";
	      
	      Connection con = DriverManager.getConnection(url, dbuser, dbpassword);
	    // table penjualan dan informasi
	      String query = "SELECT * FROM item";
	    
	      Statement stm = con.createStatement();
	      ResultSet res = stm.executeQuery(query);
	    
	      String columns[] = { "ID", "Nama", "Harga", "Jumlah" };
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
	    
	      DefaultTableModel model1 = new DefaultTableModel(data, columns);
	      JTable table = new JTable(model1);
	      table.setShowGrid(true);
	      table.setShowVerticalLines(true);
	      JScrollPane pane = new JScrollPane(table);
	      pane.setBounds(569, 109, 452, 431);

	      JPanel panel = new JPanel();
	      panel.setLayout(null);
	      panel.add(pane);
	      getContentPane().add(panel);

	      
	      JLabel lblDataBarangUntuk = new JLabel("DATA BARANG UNTUK DIJUAL");
	      lblDataBarangUntuk.setFont(new Font("Tahoma", Font.BOLD, 24));
	      lblDataBarangUntuk.setBounds(592, 46, 414, 40);
	      panel.add(lblDataBarangUntuk);
	      
	      JLabel lblTotal = new JLabel("Total :");
	      lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
	      lblTotal.setBounds(39, 479, 74, 32);
	      panel.add(lblTotal);
	      
	      JLabel lblNewLabel = new JLabel("Bayar :");
	      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	      lblNewLabel.setBounds(39, 524, 84, 32);
	      panel.add(lblNewLabel);
	      
	      JLabel lblKembalian = new JLabel("Kembalian :");
	      lblKembalian.setFont(new Font("Tahoma", Font.PLAIN, 18));
	      lblKembalian.setBounds(39, 569, 101, 40);
	      panel.add(lblKembalian);
	      
	      txtTotal = new JTextField();
	      txtTotal.setBounds(135, 481, 292, 32);
	      panel.add(txtTotal);
	      txtTotal.setColumns(10);
	      
	      txtBayar = new JTextField();
	      txtBayar.setBounds(135, 526, 292, 32);
	      panel.add(txtBayar);
	      txtBayar.setColumns(10);
	      
	      txtKembalian = new JTextField();
	      txtKembalian.setBounds(135, 575, 292, 32);
	      panel.add(txtKembalian);
	      txtKembalian.setColumns(10);
	      
	      JButton btnCetak = new JButton("Cetak Struk");
	      btnCetak.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		
	      		
	      		ReportPembayaran rp = new ReportPembayaran();
	      		rp.setCust(""+txtIDpembelian.getText());
	      		rp.setKembalian(kembalian);
	      		rp.setTable(model);
	      		rp.setHarga(totalBayar);
	      		rp.setVisible(true);
	      		
	      	}
	      });
	      btnCetak.setBounds(190, 641, 115, 25);
	      panel.add(btnCetak);
	      
	      JScrollPane scrollPane = new JScrollPane();
	      scrollPane.setBounds(36, 70, 366, 188);
	      panel.add(scrollPane);
	      

	      model = new DefaultTableModel(data, new String[] {
		      		"ID", "ItemID", "Jumlah", "Harga"
	  	      	});
	      
	      table_1 = new JTable(model);
	     
	      

	      scrollPane.setViewportView(table_1);
	      
	      JLabel lblListPembelian = new JLabel("List Pembelian");
	      lblListPembelian.setFont(new Font("Tahoma", Font.BOLD, 18));
	      lblListPembelian.setBounds(59, 25, 292, 16);
	      panel.add(lblListPembelian);
	      
	      txtIDpembelian = new JTextField();
	      txtIDpembelian.setBounds(134, 278, 171, 16);
	      panel.add(txtIDpembelian);
	      txtIDpembelian.setColumns(10);
	      
	      txtHarga = new JTextField();
	      txtHarga.setBounds(135, 376, 173, 16);
	      panel.add(txtHarga);
	      txtHarga.setColumns(10);
	      
	      JLabel lblIdPembelian = new JLabel("ID");
	      lblIdPembelian.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      lblIdPembelian.setBounds(23, 277, 110, 16);
	      panel.add(lblIdPembelian);
	      
	      JLabel lblJumlahItem = new JLabel("Harga");
	      lblJumlahItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      lblJumlahItem.setBounds(23, 375, 115, 16);
	      panel.add(lblJumlahItem);
	      
	      JButton btnInput = new JButton("Input");
	      btnInput.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		inputPembelian();
	      		
	      	}
	      });
	      btnInput.setBounds(135, 418, 97, 25);
	      panel.add(btnInput);
	      
	      txtItemID = new JTextField();
	      txtItemID.setColumns(10);
	      txtItemID.setBounds(134, 308, 171, 16);
	      panel.add(txtItemID);
	      
	      JLabel lblItemid = new JLabel("ItemID");
	      lblItemid.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      lblItemid.setBounds(23, 307, 74, 16);
	      panel.add(lblItemid);
	      
	      txtJmlhItem = new JTextField();
	      txtJmlhItem.setColumns(10);
	      txtJmlhItem.setBounds(135, 347, 173, 16);
	      panel.add(txtJmlhItem);
	      
	      JLabel lblJumlahItem_1 = new JLabel("Jumlah Item");
	      lblJumlahItem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	      lblJumlahItem_1.setBounds(23, 346, 84, 16);
	      panel.add(lblJumlahItem_1);
	      
	      JButton btnclear = new JButton("Hapus List");
	      btnclear.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		
	      		model.setRowCount(0);
	      		
	      	}
	      });
	      btnclear.setBounds(59, 641, 97, 25);
	      panel.add(btnclear);
	      
	      JButton btnHitung = new JButton("Hitung");
	      btnHitung.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		
	      		
	      		menghitungDuitDanKembalian();
	      	}
	      });
	      btnHitung.setBounds(328, 641, 115, 25);
	      panel.add(btnHitung);

	    
	    } catch(SQLException e) {
	      e.printStackTrace();
	    }
		  
		  
	}
	public void inputPembelian() {
		try {
			String dbuser = "root";
	        String dbpassword = "";

	     
	      String url = "jdbc:mysql://localhost/Komputer";
	      
	      Connection con = DriverManager.getConnection(url, dbuser, dbpassword);
		
	      String s = "INSERT INTO pembelian VALUES" + "('"+ this.txtIDpembelian.getText()+ "','"+this.txtItemID.getText()+ "','"+this.txtJmlhItem.getText() +"','"+ this.txtHarga.getText()+"')" ;
	     // String s = "INSERT INTO item('ItemId', 'Nama', 'Jumlah', 'Harga') VALUES " + "('"+ 12+ "','" + "barang" + "','" + 23 + "','" +23000 +"')" ;
				
	      System.out.println(s);
	      
	    
		
	      
			 Statement stm = con.createStatement();
		       stm.executeUpdate(s);
		       
		       model.setRowCount(0);
		      
		       // Referesh
		       connectTwoRefresh();
		       
		      
		      
		}catch (SQLException e){
			e.printStackTrace();
		}
	
	
	}
	public void connectTwoRefresh() {
		  try  {
		    	
		    	String dbuser = "root";
		        String dbpassword = "";
		      
		     
		      String url = "jdbc:mysql://localhost/Komputer";
		      
		      Connection con = DriverManager.getConnection(url, dbuser, dbpassword);
		    // table penjualan dan informasi
		      String query = "SELECT * FROM pembelian where PembelianNo ='"+txtIDpembelian.getText()+"'";

		      System.out.println(query);
		    
		      	Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);	
		      
		    
              String columns[] = { "ID", "ItemID", "Jumlah", "Harga" };
		  
		      int id;
		      String nama ;
		        String har;
		        String  juml ;
		      int i = 0;
		      while (res.next()) {
		         id = res.getInt("PembelianNo");
		         nama = res.getString("ItemID");
		        
		         juml = res.getString("Jumlah");
		         har = res.getString("Harga");
		        data[i][0] = id + "";
		        data[i][1] = nama;
		        data[i][2] = juml;
		        data[i][3] =  har;
		       
		        model.addRow(new Object[] {id,nama,juml,har});
		        i++;
		      }
		    
		    
		        
		    
		      
		       table_1 = new JTable(model);
		       // ambil hitung
		       HitungTotal();
		       
		       
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
}
	
	public void HitungTotal() {

		
		 try  {
		    	
		    	String dbuser = "root";
		        String dbpassword = "";
		      
		     
		      String url = "jdbc:mysql://localhost/Komputer";
		      
		      Connection con = DriverManager.getConnection(url, dbuser, dbpassword);
		    // table penjualan dan informasi
		      String query = "SELECT SUM(Harga) as cnt FROM pembelian where PembelianNo ='"+txtIDpembelian.getText()+"'";

		      System.out.println(query);
		    
		      	Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);	
		      
		      while (res.next())
		      {

		          txtTotal.setText(res.getString("cnt"));
		      }
           String columns[] = { "ID", "ItemID", "Jumlah", "Harga" };
		 
		      

		  
		       
		       
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
		
		
	}
	
	public void menghitungDuitDanKembalian() {
		
		 bayar = Integer.parseInt(txtBayar.getText());
		 kembalian =0;
		 totalBayar = Integer.parseInt(txtTotal.getText());
		
		kembalian = bayar-totalBayar;
		txtKembalian.setText(""+kembalian);
		
	}
	
	
	public void laporanPembayaran() {
		
	}
}
