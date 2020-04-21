package account.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import account.model.Account;



public class AccountDao {
	
	public Connection getConnection() {

		String url = "jdbc:mysql://localhost:3306/bankaccounts";

		String user = "root";

		String pwd = "";

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection successfull:");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public List<Account> displayAllEmployees() {

		List<Account> Accounts = new ArrayList<>();

		String sql = "select * from accounts";

		Connection con = getConnection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int accountId = rs.getInt(1);

				String accountType = rs.getString(2);

				String accountHolderName = rs.getString(3);

				String accountHolderContact = rs.getString(4);

				Double accountBalance = rs.getDouble(5);
				
				Date accountSetupDate = rs.getDate(6);
			

				Account accounts = new Account(accountId, accountType, accountHolderName,
											accountHolderContact,  accountBalance, accountSetupDate+"");

				Accounts.add(accounts);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Accounts);
		return Accounts;
	}
	
public void insertAccount(Account acc){
		
		Connection con = getConnection();
		
		String sql = "insert into accounts values(?,?,?,?,?,?)";
		
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,acc.getAccountId());
			
			pstmt.setString(2,acc.getAccountType());
			
			pstmt.setString(3,acc.getAccountHolderName());
			
			pstmt.setString(4,acc.getAccountHolderContact());
			
			pstmt.setDouble(5,acc.getAccountBalance());
			
			pstmt.setDate(6, java.sql.Date.valueOf(acc.getAccountSetupDate()));
			
			int status = pstmt.executeUpdate();
			
			if(status>0){
				
				System.out.println("Account Inserted successfully:");
			}
			else {
				
				System.out.println("Account not Inserted:");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public void deleteEmployee(int accIdTobeDeleted){
	
	Connection con = getConnection();
	
	String sql = "delete  from accounts where idAccounts=?;";
	
	try {
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, accIdTobeDeleted);
		
		int status = pstmt.executeUpdate();
		
		if(status>0){
			System.out.println("Account Deleted");
		}
		else {
			
			System.out.println("Try again!");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public Account getAccountById(int curr_accid){
	
	
	Connection con = getConnection();
	
	String sql = "select * from accounts where idAccounts=?;";
	
	Account   emp = new Account();
	
	try {
		
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, curr_accid);
		
		ResultSet rs =    pstmt.executeQuery();
		
		while(rs.next()){
			
			int accountId = rs.getInt(1);

			String accountType = rs.getString(2);

			String accountHolderName = rs.getString(3);

			String accountHolderContact = rs.getString(4);

			Double accountBalance = rs.getDouble(5);
			
			Date accountSetupDate = rs.getDate(6);
			
			emp.setAccountId(accountId);
			emp.setAccountType(accountType);
			emp.setAccountHolderName(accountHolderName);
			emp.setAccountHolderContact(accountHolderContact);
			emp.setAccountBalance(accountBalance);
			emp.setAccountSetupDate(accountSetupDate+"");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return emp;
}

public void updateEmployee(int curr_id,Account updated_acc){
	
	
	Connection con = getConnection();
	
	String sql = "update accounts set idAccounts=? , AccountType =? ,AccouHolderName=? "
			+ ", AccountHolderContact=? ,AccountBalance =?, AccountSetUpDate =? where idAccounts=?";
	

	
	try {
		
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1,updated_acc.getAccountId());
		
		pstmt.setString(2,updated_acc.getAccountType());
		
		pstmt.setString(3,updated_acc.getAccountHolderName());
		
		pstmt.setString(4,updated_acc.getAccountHolderContact());
		
		pstmt.setDouble(5,updated_acc.getAccountBalance());
		
		pstmt.setDate(6,java.sql.Date.valueOf(updated_acc.getAccountSetupDate()));
		
		pstmt.setInt(7,curr_id);
		
		int status = pstmt.executeUpdate();
		
		if(status>0){
			
			System.out.println("Account Updated!");
		}
		else {
			
			System.out.println("Try again!");
		}	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
