package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.AddProductBean;
import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class UniformDAO {
	
	Properties properties; 
	
	public UniformDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AddProductBean> getproductdetails(){
		String sql = properties.getProperty("get.productdetails"); 
		
		GetConnection gc  = new GetConnection(); 
		List<AddProductBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<AddProductBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				AddProductBean temp = new AddProductBean(); 
				temp.setProductname(gc.rs1.getString(1));
				temp.setMetatag(gc.rs1.getString(2));
				temp.setModel(gc.rs1.getString(3));
				temp.setPrice(gc.rs1.getString(4));
				temp.setQuantity(gc.rs1.getString(5));
				temp.setCategory(gc.rs1.getString(6));
				temp.setDiscountquantity(gc.rs1.getString(7));
				temp.setDiscountprice(gc.rs1.getString(8));
				temp.setPoints(gc.rs1.getString(9));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new UniformDAO().getproductdetails().forEach(System.out :: println);
	}
	
	
}
