package account.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SessionScoped
@ManagedBean(name="acc")
public class Account {
	private int accountId;
	private String accountType;
	private String accountHolderName;
	private String accountHolderContact;
	private double accountBalance;
	private String accountSetupDate;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountHolderContact() {
		return accountHolderContact;
	}
	public void setAccountHolderContact(String accountHolderContact) {
		this.accountHolderContact = accountHolderContact;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountSetupDate() {
		return accountSetupDate;
	}
	public void setAccountSetupDate(String accountSetupDate) {
		this.accountSetupDate = accountSetupDate;
	}

	public Account(int accountId, String accountType, String accountHolderName, String accountHolderContact,
			double accountBalance, String accountSetupDate) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountHolderContact = accountHolderContact;
		this.accountBalance = accountBalance;
		this.accountSetupDate = accountSetupDate;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", accountHolderName="
				+ accountHolderName + ", accountHolderContact=" + accountHolderContact + ", accountBalance="
				+ accountBalance + ", accountSetupDate=" + accountSetupDate + "]";
	}
	public Account() {
	
	}
public String greetings(){
		
		return("Response");
		
	}
}
