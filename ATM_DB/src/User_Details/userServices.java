package User_Details;



public interface userServices {
	//create user
		public void createAccount(UserDetails user);
		
		//
		public void getAccountById();
		
		//
	    public void debitAccountById(long acc_number );
		
		//
		public void creditAccountById(long acc_number);
		
		//
		public void updateAccountById(long acc_number);


}
