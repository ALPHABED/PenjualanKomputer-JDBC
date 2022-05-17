package penjualanKomputer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ReportPembayaran extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTokoKompoterBaha;
	private JScrollPane scrollPane;
	private JLabel lblNomorCustomer;
	private JLabel lblBintaro;
	private JLabel lblCustID;
	private JLabel lblTotalHarga;
	private JTable table;
	private JLabel lblHarga;
	private DefaultTableModel model;
	private JLabel lblTotalKembalian;
	private JLabel lblKembalian;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportPembayaran dialog = new ReportPembayaran();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReportPembayaran() {
		setTitle("Struk");
		setBounds(100, 100, 583, 649);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			scrollPane = new JScrollPane();
			sl_contentPanel.putConstraint(SpringLayout.NORTH, scrollPane, 263, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, scrollPane, -133, SpringLayout.SOUTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, scrollPane, -14, SpringLayout.EAST, contentPanel);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
					},
					new String[] {
						"Nomor Pembelian", "ItemId", "Jumlah Item", "Harga"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
		{
			lblTokoKompoterBaha = new JLabel("Toko Kompoter Bahagia");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblTokoKompoterBaha, 42, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblTokoKompoterBaha, 156, SpringLayout.WEST, contentPanel);
			lblTokoKompoterBaha.setFont(new Font("Tahoma", Font.BOLD, 20));
			contentPanel.add(lblTokoKompoterBaha);
		}
		{
			lblBintaro = new JLabel("Jl.Bintaro 1, no292");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblBintaro, 6, SpringLayout.SOUTH, lblTokoKompoterBaha);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblBintaro, 222, SpringLayout.WEST, contentPanel);
			contentPanel.add(lblBintaro);
		}
		{
			lblNomorCustomer = new JLabel("Nomor Customer :");
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblNomorCustomer, 49, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNomorCustomer, -426, SpringLayout.SOUTH, contentPanel);
			contentPanel.add(lblNomorCustomer);
		}
		{
			lblTotalHarga = new JLabel("Total Harga :");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblTotalHarga, 58, SpringLayout.SOUTH, scrollPane);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblTotalHarga, 0, SpringLayout.WEST, lblNomorCustomer);
			contentPanel.add(lblTotalHarga);
		}
		{
			lblCustID = new JLabel("0000");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblCustID, 0, SpringLayout.NORTH, lblNomorCustomer);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblCustID, 38, SpringLayout.EAST, lblNomorCustomer);
			sl_contentPanel.putConstraint(SpringLayout.EAST, lblCustID, 279, SpringLayout.EAST, lblNomorCustomer);
			contentPanel.add(lblCustID);
		}
		{
			 lblHarga = new JLabel("0000");
			 sl_contentPanel.putConstraint(SpringLayout.NORTH, lblHarga, 0, SpringLayout.NORTH, lblTotalHarga);
			 sl_contentPanel.putConstraint(SpringLayout.WEST, lblHarga, 6, SpringLayout.EAST, lblTotalHarga);
			contentPanel.add(lblHarga);
		}
		{
			lblTotalKembalian = new JLabel("Total Kembalian :");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblTotalKembalian, 17, SpringLayout.SOUTH, lblTotalHarga);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblTotalKembalian, 0, SpringLayout.WEST, lblNomorCustomer);
			contentPanel.add(lblTotalKembalian);
		}
		{
			lblKembalian = new JLabel("0000");
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblKembalian, 19, SpringLayout.EAST, lblTotalKembalian);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblKembalian, 0, SpringLayout.SOUTH, lblTotalKembalian);
			contentPanel.add(lblKembalian);
		}
	}
	
	
	public void setTable(DefaultTableModel onetable) {
		table.setModel(onetable);
	}
	
	public void setHarga(int totalBayar) {
		lblHarga.setText(""+totalBayar);
		
	}

	public void setKembalian(int kembaliankU) {
		lblKembalian.setText(""+ kembaliankU);
	}
	
	
	
	public void Report() {
		
		 try  {
		    	
		    	String dbuser = "root";
		        String dbpassword = "";
		      
		     
		      String url = "jdbc:mysql://localhost/Komputer";
		      
		      Connection con = DriverManager.getConnection(url, dbuser, dbpassword);
		    // table penjualan dan informasi
		      String query = "SELECT SUM(Harga) as cnt FROM pembelian where PembelianNo ='"+lblHarga.getText()+"'";

		      System.out.println(query);
		    
		      	Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);	
		      
		      while (res.next())
		      {

		         lblHarga.setText(res.getString("cnt"));
		      }
        String columns[] = { "ID", "ItemID", "Jumlah", "Harga" };
		
		      
		      

		  
		       
		       
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}

	public void setCust(String text) {
		
			lblCustID.setText(""+text);
		
		
	}
	
}
