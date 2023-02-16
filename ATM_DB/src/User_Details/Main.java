package User_Details;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Connection getconnection = connectionToDb.Getconnection();
		// TODO Auto-generated method stub
		userServices users=new userServicesImpl();
		Scanner scan=new Scanner(System.in);
		long ac_n;
		System.out.println("Welcome to 1Rivet Bank");
		System.out.println("Enter Your Choice :");
		System.out.println("1.Create Account \n2.Get Account by id \n3.Credit \n4.Debit \n5.Update Account \n6.Exit");
		int ch=scan.nextInt();
		while(ch!=6) {
		
		if(ch==1) {
		
			UserDetails u1=new UserDetails();
			
			String name=u1.getAcc_name();
			String address=u1.getAcc_address();
			long mobile=u1.getAcc_mobile();
			long balance=u1.getAcc_balance();
			
			users.createAccount(u1);
			//break;
		}
			
			
		else if(ch==2) {
			users.getAccountById();
			//break;
		}
		else if(ch==3) {
		
			System.out.println("Please Enter Account number :");
			ac_n=scan.nextLong();
			users.creditAccountById(ac_n);
			//break;
		}
		else if(ch==4) {
			System.out.println("Please Enter Account number :");
			ac_n=scan.nextLong();
			users.debitAccountById(ac_n);
			//break;
		}
		else if(ch==5) {
			System.out.println("Please Enter Account number :");
			ac_n=scan.nextLong();
			users.updateAccountById(ac_n);
			
		}
			
		else if(ch==6)
			System.exit(0);
		else
		{
			System.out.println("Enter Valid choice");
			//break;
		}
			
		
		System.out.println("1.Create Account \n2.Get Account by id \n3.Credit \n4.Debit \n5.Update Account \n6.Exit");
		 ch=scan.nextInt();
		}
		}

	

}
