package User_Details;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class userServicesImpl implements userServices{
	Scanner sc=new Scanner(System.in);
	String sql="";
	PreparedStatement st1;
	

	@Override
	public void createAccount(UserDetails user) {
		// TODO Auto-generated method stub
		long ac=0;
		boolean flag=false;

		
		try {
			st1=connectionToDb.con.prepareStatement("INSERT INTO User_Details VALUES(?,?,?,?)");
			System.out.println("Enter Account Name:");
			st1.setString(1,sc.next());
			System.out.println("Enter Account Address:");
			st1.setString(2, sc.next());
			System.out.println("Enter Account mobile number:");
			st1.setLong(3, sc.nextLong());
			System.out.println("Enter Account Balance:");
			st1.setLong(4, sc.nextLong());
			
			
			st1.executeUpdate();
			sql="SELECT MAX(Acc_number) FROM User_Details";
			PreparedStatement st=connectionToDb.con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
		
			while(rs.next()) {
				
				ac=rs.getLong("");
			}
			System.out.println("Account created successfully.");
			System.out.println("your Account number is"+ac);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void getAccountById() {
		// TODO Auto-generated method stub
		long acc_n;
		
		try {
			System.out.println("Enter Account Number:");
			acc_n=sc.nextLong();
			 boolean flag = accountExist(acc_n);
		
			sql="SELECT * FROM User_Details WHERE Acc_number="+acc_n;
			PreparedStatement st=connectionToDb.con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			if(!flag)
				{ 
				System.out.println("Account doesn't exist");
			    System.out.println("Please create Account");
				}
			else {
			System.out.printf("%12s %10s %10s\n",
                    "Account No", "Name",
                    "Balance");
			 while (rs.next()) {
	                System.out.printf("%12d %10s %10d.00\n",rs.getLong("Acc_number"),rs.getString("Acc_name"),rs.getLong("Acc_balance"));
	            }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void creditAccountById(long acc_number) {
		// TODO Auto-generated method stub
		long debit,balance=0;
		boolean flag=accountExist(acc_number);
		
	
		if(flag) {
			System.out.println("Enter amount you want to credit :");
			debit=sc.nextLong();
			
			
			try {
				sql="SELECT Acc_balance FROM User_Details WHERE Acc_number="+acc_number;
				PreparedStatement st;
				st = connectionToDb.con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					
					balance=rs.getLong("Acc_balance");
				}
			balance=balance+debit;
			System.out.println("Youe account balance is "+balance);
			sql="UPDATE User_Details SET Acc_balance="+balance+" WHERE Acc_number="+acc_number;
			st=connectionToDb.con.prepareStatement(sql);
			
			st.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("Account doesn't exist");
			System.out.println("Please create account");
			System.out.println();
		}
	}

	@Override
	public void debitAccountById(long acc_number) {
	
				long debit,balance=0;
				boolean flag=accountExist(acc_number);
				
			
				if(flag) {
					System.out.println("Enter amount you want to debit :");
					debit=sc.nextLong();
					
					
					try {
						sql="SELECT Acc_balance FROM User_Details WHERE Acc_number="+acc_number;
						PreparedStatement st;
						st = connectionToDb.con.prepareStatement(sql);
						ResultSet rs = st.executeQuery();
						while(rs.next()) {
							
							balance=rs.getLong("Acc_balance");
						}
						if(balance<debit)
							System.out.println("Insuffiecient balance");
						else {
					balance=balance-debit;
					System.out.println("Youe account balance is"+balance);
					sql="UPDATE User_Details SET Acc_balance="+balance+" WHERE Acc_number="+acc_number;
					st=connectionToDb.con.prepareStatement(sql);
					
					st.executeUpdate();
						}
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
				}
				else {
					System.out.println("Account doesn't exist");
				}
				
				
		
	}

	@Override
	public void updateAccountById(long acc_number) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag=accountExist(acc_number);
		if(flag) {
			System.out.println("Enter a number from below");
			System.out.println("1.To update name \n2.To update Address \n3.To update Phone number ");
			int ch=sc.nextInt();
			if(ch==1) {
				System.out.println("Enter the new name :");
				String name=sc.next();
				PreparedStatement st2;
				try {
					sql="UPDATE User_Details SET Acc_name='"+name+"' WHERE Acc_number="+acc_number;
					st2 = connectionToDb.con.prepareStatement(sql);
					st2.executeUpdate();
					//ResultSet rs1 = st2.executeQuery();
					System.out.println("Successfully updated");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(ch==2) {
				System.out.println("Enter the new address :");
				String add=sc.next();
				PreparedStatement st2;
				try {
					sql="UPDATE User_Details SET Acc_add='"+add+"' WHERE Acc_number="+acc_number;
					st2 = connectionToDb.con.prepareStatement(sql);
					st2.executeUpdate();
					//ResultSet rs1 = st2.executeQuery();
					System.out.println("Successfully updated");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(ch==3) {
				System.out.println("Enter the new number :");
				Long number=sc.nextLong();
				PreparedStatement st2;
				try {
					sql="UPDATE User_Details SET Acc_number='"+number+"' WHERE Acc_number="+acc_number;
					st2 = connectionToDb.con.prepareStatement(sql);
					st2.executeUpdate();
					//ResultSet rs1 = st2.executeQuery();
					System.out.println("Successfully updated");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else
			{
				System.out.println("Enter valid number ");
			}
		}
		
		else
		{
			System.out.println("Account doesn't Exist \nPlease create account or Enter valid account number");
		}
		
	}
	public static boolean accountExist(long acc_number) {
	boolean c;
		try {
		PreparedStatement st2=connectionToDb.con.prepareStatement("SELECT Acc_number FROM User_Details");
		ResultSet rs1 = st2.executeQuery();
		ArrayList<Long> Acc_number=new ArrayList<>();
		while (rs1.next()) {
			Acc_number.add(rs1.getLong("Acc_number"));
		}
		 c=Acc_number.contains(acc_number);
		}
		catch(Exception e){
			c=false;
		}
		return c;
	}


}



