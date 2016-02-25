/**
 * @Class: Initialization
 * @Description:  Welcome interface and account-related operations
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

class Initialization extends JFrame 
{
	/** 
	 * All components needed for the program 
	 */
	JPanel contPanel = new JPanel();               // The content panel
	
	/* Components on MAIN panel */
	JPanel main = new JPanel();
	JLabel lblWelcome = new JLabel("Welcome! :)");
	JButton btnSignUp = new JButton("Sign Up");
	JButton btnLogIn = new JButton("Log In");
	JButton btnQuit = new JButton("Quit");
	//----------------------------------------------------------------------------------------
	/* Components on SIGN-UP panel */
	JPanel signUp = new JPanel();
	JLabel lblSignUp = new JLabel("Sign Up");
	JButton back = new JButton();
	JLabel lblAccount = new JLabel("Account:");
	JLabel lblPassword = new JLabel("Password:");
	JLabel lblName = new JLabel("Name:");
	JLabel lblSubjects = new JLabel("Subjects:");
	String[] listSubjects = {"Chinese", "English", "Korean", 
    		"Business and Management", "Economics", "Geography", 
    		"Biology", "Chemistry", "Physics",
    		"Mathematics", "Computer",
    		"Visual Arts"};
    JLabel lblAttention = new JLabel("(choose 6 from right)");
    JList subjectsList = new JList(listSubjects);  
    JScrollPane sP = new JScrollPane();  
    JPanel panelWithin = new JPanel();
	JButton btnConfirm = new JButton("Confirm");
	JButton btnCancel = new JButton("Cancel");
	JTextField txtAccount = new JTextField();
	JPasswordField pwdPassword = new JPasswordField();
	JTextField txtName = new JTextField();
	JLabel lblAttention2 = new JLabel("\u203B Press control to select multiple choices");
	//----------------------------------------------------------------------------------------
	/* Components on LOG-IN panel */
	JPanel logIn = new JPanel();
	JLabel lblLogIn = new JLabel("Log In");
	JButton back_1 = new JButton();
	JLabel lblAccount_1 = new JLabel("Account:");
	JLabel lblPassword_1 = new JLabel("Password:");
	JTextField txtAccount_1 = new JTextField();
	JPasswordField pwdPassword_1 = new JPasswordField();
	JButton btnConfirm_1 = new JButton("Confirm");
	JButton btnCancel_1 = new JButton("Cancel");
	
	public Initialization()
	{
		/* Settings of content panel */
		setTitle("Initialization");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 300);
		setLocation(380, 100);
		contPanel = new JPanel();
		contPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contPanel);
		contPanel.setLayout(null);
		//----------------------------------------------------------------------------------------
		/* Settings of components on MAIN panel */
		main.setBackground(Color.BLACK);
		main.setBounds(0, 0, 408, 278);
		contPanel.add(main);
		main.setLayout(null);

		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblWelcome.setBounds(23, 0, 351, 82);
		main.add(lblWelcome);
		
		btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnSignUp.setBounds(88, 91, 123, 47);
		btnSignUp.addActionListener(new ActionListener()  // Switch current panel to SIGN UP panel
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				contPanel.remove(main);
				setBounds(100, 100, 420, 442);
				setLocation(380, 100);
				setTitle("Sign Up");
				contPanel.add(signUp);
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		main.add(btnSignUp);
		
		btnLogIn.setBackground(Color.BLACK);
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnLogIn.setBounds(88, 150, 123, 47);
		btnLogIn.addActionListener(new ActionListener()  // Switch current panel to LOG IN panel 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (!FileManagement.logExists())  // Handling error
				{
					new WarningDialog ("You haven't sign up yet. Please sign up!");
				}
				else
				{
					contPanel.remove(main);
					contPanel.add(logIn);
					setTitle("Log In");
					contPanel.revalidate(); 
					contPanel.repaint(); 
				}
			}
		});
		main.add(btnLogIn);
		
		btnQuit.setBackground(Color.BLACK);
		btnQuit.setForeground(Color.WHITE);
		btnQuit.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnQuit.setBounds(88, 209, 123, 47);
		btnQuit.addActionListener(new ActionListener()  // Close program
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		main.add(btnQuit);
		//----------------------------------------------------------------------------------------
		/* Settings of components on SIGN-UP panel */
		final UpdateAccount process = new UpdateAccount();
		
		signUp.setBackground(Color.BLACK);
		signUp.setBounds(0, 0, 430, 420);
		signUp.setLayout(null);
		
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblSignUp.setBounds(45, 0, 245, 82);
		signUp.add(lblSignUp);
	
		back.setIcon(new ImageIcon(MainFrame.class.getResource("/image/icon.png")));
		back.setBackground(Color.BLACK);
		back.setBounds(10, 101, 32, 32);
		back.setBorderPainted(false);
		back.addActionListener(new ActionListener()  // Return to parent panel  
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				setBounds(100, 100, 408, 300);
				setLocation(380, 100);
				setTitle("Initialization");
				contPanel.add(main);
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		signUp.add(back);
		
		lblAccount.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		lblAccount.setForeground(Color.WHITE);
		lblAccount.setBounds(55, 103, 105, 30);
		signUp.add(lblAccount);
		
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(55, 148, 112, 30);
		signUp.add(lblPassword);
		
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(55, 193, 86, 30);
		signUp.add(lblName);
		
		lblSubjects.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		lblSubjects.setForeground(Color.WHITE);
		lblSubjects.setBounds(55, 238, 112, 37);
		signUp.add(lblSubjects);
		
	    lblAttention.setFont(new Font("Segoe UI", Font.PLAIN | Font.ITALIC, 14));
	    lblAttention.setForeground(Color.WHITE);
	    lblAttention.setBounds(39, 275, 138, 20);
	    signUp.add(lblAttention);
	    
	    subjectsList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		subjectsList.setBackground(Color.BLACK);
		subjectsList.setForeground(Color.WHITE);
		
		panelWithin.setBackground(Color.BLACK);
		sP.setViewportView(panelWithin);
		panelWithin.setLayout(new BorderLayout(0, 0));
		
		sP.setBackground(Color.BLACK);
		sP.setBounds(176, 238, 216, 82);
		signUp.add(sP);
		
		sP.setViewportView(panelWithin);
		panelWithin.add(subjectsList, BorderLayout.NORTH);
		signUp.add(sP);
		
		btnConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		btnConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(Color.BLACK);
		btnConfirm.setBounds(105, 357, 129, 47);
		btnConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!UpdateAccount.ifUsernameExist(getUser()) && getSubjects().length==6)  // Handling error
				{
					process.saveDataToArray(getUser(), getPassword(), getName(), returnSubjects());
					new MessageDialog ("Registration successful!", "Congratulations");
					contPanel.removeAll();
					setBounds(100, 100, 408, 300);
					setLocation(380, 100);
					contPanel.add(main);
					contPanel.revalidate(); 
					contPanel.repaint();  
				}
				else if (UpdateAccount.ifUsernameExist(getUser()))  // Handling error
			    {
			    	new WarningDialog ("This username has been registered. Please change another username!");
			    }
				else if (getSubjects().length<6)  // Handling error
				{
					new WarningDialog ("You've choosen less than 6 subjects. Please choose again!");
				}
				else if (getSubjects().length>6)  // Handling error
				{
					new WarningDialog ("You've choosen more than 6 subjects. Please choose again!");
				}
			}
		});
		signUp.add(btnConfirm);
		
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(257, 357, 123, 47);
		btnCancel.addActionListener(new ActionListener()  // Return to parent panel  
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				setBounds(100, 100, 408, 300);
				setLocation(380, 100);
				setTitle("Initialization");
				contPanel.add(main);
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		signUp.add(btnCancel);
		
		txtAccount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtAccount.setBackground(Color.WHITE);
		txtAccount.setBounds(179, 108, 213, 25);
		signUp.add(txtAccount);
		txtAccount.setColumns(10);
		
		pwdPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pwdPassword.setBackground(Color.WHITE);
		pwdPassword.setBounds(179, 153, 213, 25);
		signUp.add(pwdPassword);
		
		txtName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(179, 198, 213, 25);
		signUp.add(txtName);
		txtName.setColumns(10);
		
		lblAttention2.setFont(new Font("Segoe UI", Font.PLAIN | Font.ITALIC, 14));
	    lblAttention2.setForeground(Color.LIGHT_GRAY);
	    lblAttention2.setBounds(142, 325, 250, 20);
		signUp.add(lblAttention2);
		//----------------------------------------------------------------------------------------
		/* Settings of components on LOG-IN panel */
		logIn.setBackground(Color.BLACK);
		logIn.setBounds(0, 0, 408, 278);
		logIn.setLayout(null);
		
		lblLogIn.setForeground(Color.WHITE);
		lblLogIn.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblLogIn.setBounds(45, 0, 197, 82);
		logIn.add(lblLogIn);
		
		back_1.setIcon(new ImageIcon(MainFrame.class.getResource("/image/icon.png")));
		back_1.setBackground(Color.BLACK);
		back_1.setBounds(10, 101, 32, 32);
		back_1.setBorderPainted(false);
		back_1.addActionListener(new ActionListener()  // Return to parent panel   
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				contPanel.add(main);
				setTitle("Initialization");
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		logIn.add(back_1);
		
		lblAccount_1.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		lblAccount_1.setForeground(Color.WHITE);
		lblAccount_1.setBounds(55, 103, 105, 30);
		logIn.add(lblAccount_1);
		
		lblPassword_1.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		lblPassword_1.setForeground(Color.WHITE);
		lblPassword_1.setBounds(55, 148, 112, 30);
		logIn.add(lblPassword_1);
		
		txtAccount_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtAccount_1.setBackground(Color.WHITE);
		txtAccount_1.setBounds(179, 108, 167, 25);
		logIn.add(txtAccount_1);
		txtAccount_1.setColumns(10);
		
		pwdPassword_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pwdPassword_1.setBackground(Color.WHITE);
		pwdPassword_1.setBounds(179, 153, 167, 25);
		logIn.add(pwdPassword_1);
		
		btnConfirm_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnConfirm_1.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnConfirm_1.setForeground(Color.WHITE);
		btnConfirm_1.setBackground(Color.BLACK);
		btnConfirm_1.setBounds(74, 207, 129, 47);
		btnConfirm_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if (txtAccount_1.getText().equals("") && pwdPassword_1.getPassword().length==0)
				{
					new WarningDialog ("Please input your username and password first!");
				}
				else if (txtAccount_1.getText().equals(""))
				{
					new WarningDialog ("Please input your username!");
				}
				else if (pwdPassword_1.getPassword().length==0)
				{
					new WarningDialog ("Please input your password!");
				}
				else if (!UpdateAccount.ifUsernameExist(txtAccount_1.getText()))
				{
					new WarningDialog ("This username doesn't exist!");
					txtAccount_1.setText("");
					pwdPassword_1.setText("");
					pwdPassword_1.requestFocusInWindow();
				}
				else if (!UpdateAccount.isPasswordCorrect(txtAccount_1.getText(), pwdPassword_1.getPassword()))  // Handling error
				{
					new WarningDialog ("The Password is WRONG! Please enter again!");
					txtAccount_1.setText("");
					pwdPassword_1.setText("");
					pwdPassword_1.requestFocusInWindow();
				}
				else if (UpdateAccount.ifUsernameExist(txtAccount_1.getText()) && UpdateAccount.isPasswordCorrect(txtAccount_1.getText(), pwdPassword_1.getPassword()))
				{
					new MessageDialog ("Log in successful!", "Congratulations");
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		logIn.add(btnConfirm_1);
		
		btnCancel_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel_1.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnCancel_1.setForeground(Color.WHITE);
		btnCancel_1.setBackground(Color.BLACK);
		btnCancel_1.setBounds(226, 207, 123, 47);
		btnCancel_1.addActionListener(new ActionListener()  // Return to parent panel  
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				contPanel.add(main);
				setTitle("Initialization");
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		logIn.add(btnCancel_1);
	}
	//----------------------------------------------------------------------------------------
	/* Return values of information get from components on SIGN-UP panel */
	public String getUser()  // get USERNAME that user types
	{
		return (txtAccount.getText());
	}
	
	public String getPassword()  // get PASSWORD that user types
	{
		char[] a = pwdPassword.getPassword();
		String b = new String(a);
		return (b);
	}
	
	public String getName()  // get NAME that user types
	{
		return (txtName.getText());
	}
	
	public String[] getSubjects()  // get SUBJECTS that user chooses
	{
		Object[] oa = subjectsList.getSelectedValues(); 
		String[] sa = Arrays.copyOf(oa, oa.length, String[].class);
		return (sa);
	}
	
	public String returnSubjects()  // Output subjects that user chooses in one line
	{
		String[] a = getSubjects();
		String subjects = a[0]+"/"+a[1]+"/"+a[2]+"/"+a[3]+"/"+a[4]+"/"+a[5]+"/"+"TOK"+"/"+"Others"; 
		return subjects;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Initialization frame = new Initialization();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

}