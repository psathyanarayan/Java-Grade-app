package log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.print.DocFlavor.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



//import com.sun.org.apache.xpath.internal.operations.Bool;




public class log extends JFrame implements ActionListener{
	String a;
	char[] b;
	JFrame frame;
	JTextField tf;
	JLabel label,label2;
	JPasswordField pass;
	JButton login;
	JPanel p;
	JFrame f2;
	static JTextField tf4;
	static JPanel contentPane;  
	Boolean exit = false;
	static Connection con;
	// TODO Auto-generated method stub
	
	log()
	{
		//1st frame that we see with username and password with the avatar image
		
		frame = new JFrame();
		frame.setResizable(false);
		
		label = new JLabel("Enter Username:");
		label.setBounds(90, 130, 200, 30);
	    tf = new JTextField(16);
	    //tf.setToolTipText("Enter Username");
	    tf.setBounds(200, 130, 200, 30);
	    label2 = new JLabel("Enter Password:");
	    label2.setBounds(90, 175, 200, 30);
	    pass = new JPasswordField(16);
	    pass.setBounds(200, 175, 200, 30);
	    login = new JButton("Login");
	    login.setBounds(245,225,100,30);
	    JPanel panel = (JPanel)frame.getContentPane();
	    panel.setBounds(245, 11, 100, 100);
        JLabel label3 = new JLabel();
        label3.setBounds(250, 11, 100, 100);
        label3.setIcon(new ImageIcon("/Users/sathyanarayan/OneDrive - Student Ambassadors/Lab/Jyothi miss/Login/login/log/log/U.png"));
        panel.add(label3);
	    frame.add(label);
	    frame.add(tf);
	    frame.add(label2);
	    frame.add(pass);
	    frame.add(login);
	    frame.add(label3);	
	    frame.setSize(600, 350);
	    frame.setLayout(null);
	    frame.setVisible(true);;
	    login.addActionListener(this);
	    
	}
	  

	public static void main(String[] args) {
		 new log(); 
		 
		
		 

	}
	//When we click login button
	public void actionPerformed(ActionEvent e)
	{
		 a=tf.getText().toString();
		 b=pass.getPassword();
		 if(e.getSource()==login)
		 {
			 

		        try
		        {
		        	int i=1;
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root@sathya");
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("select *from login");
		            while (rs.next())
		            {
		                String username = rs.getString(1);
		                String password=rs.getString(2);;
		                i+=1;
		        
		               
		                if((username.equals(tf.getText()) && (password.equals(new String((pass.getPassword()))))))
		                {
		                	exit = true;
		                	frame.dispose();
		                	JButton generate = new JButton("Generate Result");
		                	generate.setBounds(131, 427, 275, 60);
		                	f2 = new JFrame();
		                	Font font1 = new Font("SansSerif", Font.BOLD, 50);
		                	JTextField tb1 = new JTextField("0");
		                	tb1.setBounds(70,153,180,30);
		                	JTextField tb2 = new JTextField("0");
		                	tb2.setBounds(70,197,180,30);
		                	JTextField tb3 = new JTextField("0");
		                	tb3.setBounds(70,239,180,30);
		                	JTextField tb4 = new JTextField("0");
		                	tb4.setBounds(70,282,180,30);
		                	JTextField tb5 = new JTextField("0");
		                	tb5.setBounds(70,323,180,30);
		                	JTextField tb6 = new JTextField("0");
		                	tb6.setBounds(70,366,180,30);
		                	
		                	JTextField result = new JTextField();
		                	result.setBounds(276,153,200,100);
		                	result.setFont(font1);
		                	result.setHorizontalAlignment(JTextField.CENTER);
		                	result.setEditable(false);
		            		f2.setResizable(false);
		            		JLabel mark = new JLabel("Enter Marks");
		            		mark.setBounds(122, 132, 90, 20);
		            		JLabel res = new JLabel("Result");
		            		res.setBounds(130, 336, 90, 20);
		            		JLabel hed = new JLabel("Your Grade Card");
		            		res.setBounds(220, 130, 100, 20);
		            		//JPanel panel = new JPanel();
		            		//panel.setBounds(50,94,473,473);
		            		tf4 = new JTextField();
		            		tf4.setBounds(276, 336, 200, 65);
		            		tf4.setEditable(false);		            
		                	JButton b2 = new JButton("Log out");
		                	b2.setBounds(297, 278, 120, 40);
		                	JLabel label3 = new JLabel("Login Successful");
		                	JOptionPane.showMessageDialog(null,"You Entered successfully");
		                	//f2.add(label3);
		                	f2.add(b2);
		                	f2.add(tb1);
		                	f2.add(tb2);
		                	f2.add(tb3);
		                	f2.add(tb4);
		                	f2.add(tb5);
		                	f2.add(tb6);
		                	f2.add(tf4);
		                	f2.add(result);
		                	f2.add(generate);
		                	f2.add(mark);
		                	//f2.add(res);
		                	f2.add(hed);
		                	f2.setLayout(null);
		                	generate.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Double a1 = Double.parseDouble(tb1.getText());
									Double a2 = Double.parseDouble(tb2.getText());
									Double a3 = Double.parseDouble(tb3.getText());
									Double a4 = Double.parseDouble(tb4.getText());
									Double a5 = Double.parseDouble(tb5.getText());
									Double a6 = Double.parseDouble(tb6.getText());
									Double r = 0.0;
									
									if(e.getSource()==generate)
									{
										r = (a1+a2+a3+a4+a5+a6)/6;
										if(r>=90)
										{
											insertGrade(username,"OS");
											result.setText("OS");
											result.setForeground(Color.green);
										}
										else if(r>=85)
										{
											insertGrade(username,"A+");
											result.setText("A+");
											result.setForeground(Color.blue);
										}	
										else if(r>=82)
										{
											insertGrade(username,"A");
											result.setText("A");
											result.setForeground(Color.magenta);
										}	
										else if(r>=75)
										{
											insertGrade(username,"B+");
											result.setText("B+");
											result.setForeground(Color.orange);
										}	
										else if(r>=72)
										{
											insertGrade(username,"B");
											result.setText("B");
											result.setForeground(Color.yellow);
										}	
										else if(r>=65)
										{
											insertGrade(username,"C+");
											result.setText("C+");
											result.setForeground(Color.pink);
										}
										else if(r>=62)
										{
											insertGrade(username,"C");
											result.setText("C");
											result.setForeground(Color.cyan);
										}	
										else if(r>=55)
										{
											insertGrade(username,"D+");
											result.setText("D+");
											result.setForeground(Color.cyan);
										}	
										else if(r>=52)
										{
											insertGrade(username,"D");
											result.setText("D");
											result.setForeground(Color.cyan);
										}	
										else if(r>=42)
										{
											insertGrade(username,"Pass");
											result.setText("Pass");
											result.setForeground(Color.cyan);
										}
										else
										{
											insertGrade(username,"Fail");
											result.setText("Fail");
											result.setForeground(Color.red);
										}
										
									}
								}
							});
		                	b2.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									int a = JOptionPane.showConfirmDialog(b2, "Are you sure?");
									if(a==JOptionPane.YES_OPTION)
									{
										f2.dispose();
										log obj = new log();
										
										
										
									}

									
									
								
								}	
							});
		                	
		                	f2.setSize(590, 590);
		            	    f2.show();
		            	    if (exit == true)
					        {
					            break;
					        }
		                	
		           
		               }
		               
		                

		            }
		            if(exit != true)
		            {
		            	//For creating a new User if the pass is not correct
		            	JOptionPane.showMessageDialog(null,"Incorrect username and password");
		            	int a = JOptionPane.showConfirmDialog(f2, "Do you want to Signup");
		            	if(a==JOptionPane.YES_OPTION)
		            	{
		            		frame.dispose();
		            		JFrame f3 = new JFrame();
		            		JLabel label3 = new JLabel("Enter Username");
		            	    JTextField tf3 = new JTextField(16);
		            	    JLabel label_p3 = new JLabel("Enter Password");
		            	    JPasswordField pass3 = new JPasswordField(16);
		            	    JButton signup = new JButton("SignUp");
		            	    JPanel p2 = new JPanel();
		            	   
		            	    
		            	    p2.setLayout( new BoxLayout(p2, BoxLayout.Y_AXIS)); 
		            	    p2.add(label3);
		            	    p2.add(tf3);
		            	    p2.add(label_p3);
		            	    p2.add(pass3);
		            	  
		            	    p2.add(signup);
		            	    f3.add(p2);
		            	    f3.setSize(300, 150);
		            	    f3.show();
		            	  
		            	    //when we click signup in the user creation frame
		            	    signup.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									if(e.getSource()==signup)
									{
										insert(tf3.getText(),new String((pass3.getPassword())));
										
										f3.dispose();
										log obj = new log();
										
									}
								}
							});
		            	    
		            		
		            	}
		            	
		            }
		      

		        }
		        catch(Exception er)
		        {
		            System.out.println(er);
		        }
		 }
	}
	
	
	
	//Insert function to insert new user to the database
	public static void insert(String username,String pass)
	{
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Statement stat = con.createStatement();
			 ResultSet rs = stat.executeQuery("select *from login");
			 while (rs.next())
	            {
	                String user = rs.getString(1);
	                String password=rs.getString(2);
	               
	        
	              
	                if(!(username.equals(user)))
	                {
	                	String insertQuery = "insert into login values('"+ username +"','" + pass +"')";
						
						System.out.println(username);
						System.out.println(pass);
						JOptionPane.showMessageDialog(null,"User Registered");
						stat.executeUpdate(insertQuery);
						break;
	                	
			 
						//PreparedStatement smpts = con.prepareStatement("insert into login values(?,?)");
						
	                }
	                else
	                {
	                	
	                	JOptionPane.showMessageDialog(null,"User Already Registered");
	                	break;
	                }
	                
	                	
	            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void insertGrade(String username,String grade)
	{
		Boolean ex = false;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Statement state = con.createStatement();
			 ResultSet res = state.executeQuery("select *from grade");
			 while (res.next())
	            {
	                String user = res.getString(1);
	                String g=res.getString(2);
	               
	        
	              
	                if((username.equals(user)))
	                {
	                	String mar;
	                	if(grade.equals(g))
						{
	                		String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
	                		mar = g;
							tf4.setText("OS");
							tf4.setForeground(Color.green);
						}
						else if(grade.equals(g))
						{
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("A+");
							tf4.setForeground(Color.blue);
						}	
						else if(grade.equals(g))
						{
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("A");
							tf4.setForeground(Color.magenta);
						}	
						else if(grade.equals(g))
						{	
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("B+");
							tf4.setForeground(Color.orange);
						}	
						else if(grade.equals(g))
						{
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("B");
							tf4.setForeground(Color.yellow);
						}	
						else if(grade.equals(g))
						{
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("C+");
							tf4.setForeground(Color.pink);
						}
						else if(grade.equals(g))
						{
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("C");
							tf4.setForeground(Color.cyan);
						}	
						else if(grade.equals(g))
						{
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("D+");
							tf4.setForeground(Color.cyan);
						}	
						else if(grade.equals(g))
						{
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("D");
							tf4.setForeground(Color.cyan);
							
						}	
						else if(grade.equals(g))
						{
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("Pass");
							tf4.setForeground(Color.cyan);
						}
						else
						{
							String updateQuery = "update grade set grade = '"+grade+"' where name = '"+username+"'";
	                		state.executeUpdate(updateQuery);
							mar = g;
							tf4.setText("Fail");
							tf4.setForeground(Color.red);
						}
						tf4.setText(mar);
						Font font1 = new Font("SansSerif", Font.BOLD, 50);
						tf4.setFont(font1);
						tf4.setHorizontalAlignment(JTextField.CENTER);
						ex = true;
	                	
	                
	                }
	               
	                
	                	
	            }
			 if(ex == false)
			 {	 
			 String insertQuery = "insert into grade values('"+ username +"','" + grade +"')";
				
				System.out.println(username);
				System.out.println(grade);
				JOptionPane.showMessageDialog(null,"Mark Entered");
				state.executeUpdate(insertQuery);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	                }
	                	
	                	
			 
						//PreparedStatement smpts = con.prepareStatement("insert into login values(?,?)");
						
	                
	               
	                	
	}

}


