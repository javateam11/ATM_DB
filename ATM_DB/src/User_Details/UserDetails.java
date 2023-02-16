package User_Details;



public class UserDetails {
	private long acc_mobile,acc_number,acc_balance;
	private String acc_name,acc_address;
	

	
	
	public long getAcc_mobile() {
		return acc_mobile;
	}
	public void setAcc_mobile(long acc_mobile) {
		this.acc_mobile = acc_mobile;
	}
	public long getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(long acc_number) {
		this.acc_number = acc_number;
	}
	public long getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(long acc_balance) {
		this.acc_balance = acc_balance;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public String getAcc_address() {
		return acc_address;
	}
	public void setAcc_address(String acc_address) {
		this.acc_address = acc_address;
	}
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDetails [acc_mobile=" + acc_mobile + ", acc_number=" + acc_number + ", acc_balance=" + acc_balance
				+ ", acc_name=" + acc_name + ", acc_address=" + acc_address + "]";
	}
	public static void createUser(UserDetails u1) {
		// TODO Auto-generated method stub
		
	}

}
