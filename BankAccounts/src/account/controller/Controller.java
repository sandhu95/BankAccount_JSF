package account.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import account.dao.AccountDao;
import account.model.Account;

@SessionScoped
@ManagedBean(name = "con")

public class Controller {
	
AccountDao dbUtil = new AccountDao();
	
 int oldaccountId ;

	public List<Account> display() {

		List<Account> conAccount = new ArrayList<>();

		conAccount = dbUtil.displayAllEmployees();

		return conAccount;
	}
	
	public String insert(Account Acc){
		
	   dbUtil.insertAccount(Acc);

		   
		   return "index";
	}
	
public String delete(int id){
		
		
		dbUtil.deleteEmployee(id);
		
		return "index" ;
		
	}

public String edit(int id){
	
	oldaccountId = id ;

	Account e = dbUtil.getAccountById(id);

	
	String datenew="" ;
	Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	sessionMap.put("e", e);
	sessionMap.put("dt", datenew);

	return "UpdateAccount" ;
}

public String update(Account e){
	dbUtil.updateEmployee(oldaccountId, e);
	return "index" ;
}
}
