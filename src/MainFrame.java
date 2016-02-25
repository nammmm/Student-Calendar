/**
 * @Class: MainFrame
 * @Description: Including settings of all components and some arithmetics for important operations
 */
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

class MainFrame extends JFrame 
{ 
	/** 
	 * All components needed for the program 
	 */
	JPanel contPanel = new JPanel();           // The content panel
	String user = UpdateAccount.getUser();     // Get the current Username
	String name = UpdateAccount.getName();       // Get the name of current user

	/* Components on MENU panel */
	JPanel menu = new JPanel();
    JButton btnUpdate = new JButton("01 |  Update"); 
    JButton btnTodo = new JButton("02 |  To-do"); 
	JButton btnQuit = new JButton("03 |  Quit");
	JLabel lblStudent = new JLabel("Student");
	JLabel lblCalendar = new JLabel("Calendar");
	JLabel lblItsNow = new JLabel("It's               now  |"+"  Hi! "+name);
	JLabel lblNotification = new JLabel("Notification");
	JLabel lblEventsAmount = new JLabel();
	JLabel lblTips = new JLabel();
	JLabel clock=new JLabel("Clock");
	TimeListener m1=new TimeListener(clock);
	Timer t1=new Timer(1000,m1);
	//----------------------------------------------------------------------------------------
	/* Components on UPDATE panel */
	JPanel update = new JPanel();
	JButton back = new JButton();
	JButton btnAdd = new JButton("01 |  Add Event");
	JButton btnDelete = new JButton("02 |  Delete Event");
	JLabel lblStudent_1 = new JLabel("Student");
	JLabel lblCalendar_1 = new JLabel("Calendar");
	JLabel lblUpdate = new JLabel("Update");
	//----------------------------------------------------------------------------------------
	/* Components on TODO panel */
	JPanel todo = new JPanel(); 
	JPanel panelIn = new JPanel();
	JButton back_1 = new JButton();
	JScrollPane sP = new JScrollPane();
	JLabel lblNumOfThings = new JLabel();
	JLabel lblThingsTodo = new JLabel("Things To Do!");
	String[] subjects = UpdateEvent.getSubjects(user);
	JLabel lblT1 = new JLabel(subjects[8]);
	JLabel lblT2 = new JLabel(subjects[1]);
	JLabel lblT3 = new JLabel(subjects[2]);
	JLabel lblT4 = new JLabel(subjects[3]);
	JLabel lblT5 = new JLabel(subjects[4]);
	JLabel lblT6 = new JLabel(subjects[5]);
	JLabel lblT7 = new JLabel(subjects[6]);
	JLabel lblT8 = new JLabel(subjects[7]);
	final DefaultListModel eventModel1 = new DefaultListModel();
	final DefaultListModel eventModel2= new DefaultListModel();
	final DefaultListModel eventModel3 = new DefaultListModel();
	final DefaultListModel eventModel4 = new DefaultListModel();
	final DefaultListModel eventModel5 = new DefaultListModel();
	final DefaultListModel eventModel6 = new DefaultListModel();
	final DefaultListModel eventModel7 = new DefaultListModel();
	final DefaultListModel eventModel8 = new DefaultListModel();
	JList list1 = new JList(eventModel1);
	JList list2 = new JList(eventModel2);				
	JList list3 = new JList(eventModel3);
	JList list4 = new JList(eventModel4);		
	JList list5 = new JList(eventModel5);				
	JList list6 = new JList(eventModel6);				
	JList list7 = new JList(eventModel7);		
	JList list8 = new JList(eventModel8);
	//----------------------------------------------------------------------------------------
	/* Components on ADD-EVENT panel */
	JPanel addEvent = new JPanel();
	JButton btnConfirm = new JButton("Confirm");
	JButton btnCancel = new JButton("Cancel");
	JButton back_2 = new JButton();
	JLabel lblStudent_3 = new JLabel("Student");	
	JLabel lblCalendar_3 = new JLabel("Calendar");	
	JLabel lblAddEvent = new JLabel("Add Event");
	JLabel lblEventName = new JLabel("Event Name:");
	JLabel lblSubject = new JLabel("Subject:");
    String[] listSubject = UpdateEvent.getSubjects(user);
	JComboBox boxSubject = new JComboBox(listSubject);
	JLabel lblDeadline = new JLabel("Deadline:");
	DateChooser dateChooser = DateChooser.getInstance("yyyy-MM-dd");
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	JTextField showDate = new JTextField("Click to choose date");
	JLabel lblPriority = new JLabel("Priority:");
    String[] listLevel = {"1", "2", "3"};
	JComboBox boxPriority = new JComboBox(listLevel);
	JTextField event = new JTextField();
	//----------------------------------------------------------------------------------------
	/* Components on DELETE-EVENT panel */
	JPanel deleteEvent = new JPanel();
	JButton back_3 = new JButton();
	JButton btnDelete_1 = new JButton("Delete");
	JButton btnCancel_1 = new JButton("Cancel");
	JLabel lblStudent_4 = new JLabel("Student");	
	JLabel lblCalendar_4 = new JLabel("Calendar");	
	JLabel lblDeleteEvent = new JLabel("Detele Event");
	JLabel lblDeleteWhich = new JLabel("Which Subject?");
	JComboBox boxDelete = new JComboBox(listSubject);
	final DefaultListModel listModel = new DefaultListModel();
    JList deleteList = new JList(listModel);  
    JScrollPane sP1 = new JScrollPane();  
    JPanel panelWithin = new JPanel();

    /**
     * @Title: MainFrame
     * @Description: Including settings of all components and some arithmetics for important operations
    */	
	public MainFrame()
	{
		/* Settings of content panel */
		setTitle("Student Calendar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 463);
		setLocation(380, 100);
		contPanel.setBackground(Color.BLACK);
		contPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contPanel);
		contPanel.setBorder(null);
		contPanel.setLayout(new BorderLayout(0, 0));
		//----------------------------------------------------------------------------------------
		/* Call refresh() method to refresh the content under NOTIFICATION bar on the home page */
		refresh();
		//----------------------------------------------------------------------------------------
		/* Settings of three primary panels */
		menu.setBackground(Color.BLACK);
		menu.setBounds(0, 0, 543, 441);
		contPanel.add(menu, BorderLayout.CENTER);
		menu.setLayout(null);
		
		update.setBounds(0, 0, 543, 441);
		update.setBackground(Color.BLACK);
		update.setLayout(null);
		
		todo.setBounds(0, 0, 543, 441);
		todo.setBackground(Color.BLACK);
		todo.setBorder(null);
		todo.setLayout(new BorderLayout(0, 0));
		//----------------------------------------------------------------------------------------
		/* Settings of two secondary panels */
		addEvent.setBounds(0, 0, 543, 441);
		addEvent.setBackground(Color.BLACK);
		addEvent.setLayout(null);
		
		deleteEvent.setBounds(0, 0, 543, 441);
		deleteEvent.setBackground(Color.BLACK);
		deleteEvent.setLayout(null);
		//----------------------------------------------------------------------------------------
		/* Settings of components on MENU panel */
		t1.setInitialDelay(0);
		t1.start();
		clock.setForeground(Color.LIGHT_GRAY);
		clock.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		clock.setBounds(50, 89, 77, 24);
		menu.add(clock);
		
		btnUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(55, 122, 173, 47);
		btnUpdate.addActionListener(new ActionListener()  // Switch current panel to UPDATE panel
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				contPanel.remove(menu);
				contPanel.add(update, BorderLayout.CENTER);
				setTitle("Update Event");
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		menu.add(btnUpdate);
		
		btnTodo.setHorizontalAlignment(SwingConstants.LEFT);
		btnTodo.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnTodo.setForeground(Color.WHITE);
		btnTodo.setBackground(Color.BLACK);
		btnTodo.setBounds(55, 186, 173, 47);
		btnTodo.addActionListener(new ActionListener()  // Switch current panel to TODO panel
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				contPanel.remove(menu);
				contPanel.add(todo, BorderLayout.CENTER);
				setTitle("Things To Do");
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		menu.add(btnTodo);
		
		btnQuit.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuit.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnQuit.setForeground(Color.WHITE);
		btnQuit.setBackground(Color.BLACK);
		btnQuit.setBounds(55, 250, 173, 47);
		btnQuit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)  // Close program
			{
				System.exit(0);
			}
		});
		menu.add(btnQuit);
		
		lblStudent.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblStudent.setForeground(Color.WHITE);
		lblStudent.setBounds(12, 0, 226, 79);
		menu.add(lblStudent);
		
		lblCalendar.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblCalendar.setForeground(Color.LIGHT_GRAY);
		lblCalendar.setBounds(237, 1, 263, 77);
		menu.add(lblCalendar);
		
		lblItsNow.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblItsNow.setForeground(Color.LIGHT_GRAY);
		lblItsNow.setBounds(22, 89, 400, 24);
		menu.add(lblItsNow);
		
		lblNotification.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNotification.setForeground(Color.LIGHT_GRAY);
		lblNotification.setBounds(22, 320, 112, 28);
		menu.add(lblNotification);
		
		lblEventsAmount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblEventsAmount.setForeground(Color.WHITE);
		lblEventsAmount.setBounds(42, 350, 250, 23);
		menu.add(lblEventsAmount);
		
		lblTips.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblTips.setForeground(Color.WHITE);
		lblTips.setBounds(42, 377, 239, 23);
		menu.add(lblTips);
		//----------------------------------------------------------------------------------------
		/* Settings of components on UPDATE panel */
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnAdd.setBounds(53, 150, 244, 47);
		btnAdd.addActionListener(new ActionListener()  // Switch current panel to ADD-EVENT panel 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (UpdateEvent.arraySize(FileManagement.getDataFromFile(user))<99)
				{
					contPanel.remove(update);
					contPanel.add(addEvent, BorderLayout.CENTER);
					setTitle("Add Event");
					contPanel.revalidate(); 
					contPanel.repaint(); 
				}
				else
				{
					new WarningDialog ("You have 99 events remained to be done. Please finish some first!");
				}
			}
		});
		update.add(btnAdd);
		
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setBounds(53, 209, 244, 47);
		btnDelete.addActionListener(new ActionListener()  // Switch current panel to DELETE-EVENT panel 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				contPanel.remove(update);
				contPanel.add(deleteEvent, BorderLayout.CENTER);
				setTitle("Delete Event");
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		update.add(btnDelete);
		
		lblStudent_1.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblStudent_1.setForeground(Color.WHITE);
		lblStudent_1.setBounds(12, 0, 226, 79);
		update.add(lblStudent_1);
		
		lblCalendar_1.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblCalendar_1.setForeground(Color.LIGHT_GRAY);
		lblCalendar_1.setBounds(237, 1, 263, 77);
		update.add(lblCalendar_1);
		
		lblUpdate.setBounds(53, 101, 95, 37);
		update.add(lblUpdate);
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		
		back.setIcon(new ImageIcon(MainFrame.class.getResource("/image/icon.png")));
		back.setBackground(Color.BLACK);
		back.setBounds(10, 101, 32, 32);
		back.setBorderPainted(false);
		back.addActionListener(new ActionListener()  // Return to parent panel  
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				contPanel.add(menu, BorderLayout.CENTER);
				setTitle("Student Calendar");
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		update.add(back);
		
		//----------------------------------------------------------------------------------------
		/* Settings of components on TODO panel */
		sP.setBorder(BorderFactory.createEmptyBorder());
		todo.add(sP, BorderLayout.CENTER);
		panelIn.setBackground(Color.BLACK);
		sP.setViewportView(panelIn);
		
		panelIn.setLayout(new MigLayout("", "[37.00px][416.00px]", "[89px][44px][pref!][37px][2px][37px][2px][37px][2px][37px][2px][37px][2px][37px][2px][37px][2px]"));
		
		lblNumOfThings.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblNumOfThings.setForeground(Color.WHITE);
		panelIn.add(lblNumOfThings, "cell 0 0");
						
		lblThingsTodo.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblThingsTodo.setForeground(Color.WHITE);
		panelIn.add(lblThingsTodo, "cell 1 0,growx,aligny top");
		
		lblT1.setForeground(Color.WHITE);
		lblT1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		panelIn.add(lblT1, "cell 1 1,alignx left,aligny top");

		list1.setBackground(Color.BLACK);
		list1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		list1.setForeground(Color.WHITE);
		panelIn.add(list1, "cell 1 2,grow");
						
		lblT2.setForeground(Color.WHITE);
		lblT2.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		panelIn.add(lblT2, "cell 1 3,alignx left,aligny top");
		
		list2.setBackground(Color.BLACK);
		list2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		list2.setForeground(Color.WHITE);
		panelIn.add(list2, "cell 1 4,grow");
								
		lblT3.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblT3.setForeground(Color.WHITE);
		panelIn.add(lblT3, "cell 1 5,alignx left,aligny top");
		
		list3.setBackground(Color.BLACK);
		list3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		list3.setForeground(Color.WHITE);
		panelIn.add(list3, "cell 1 6,grow");

		lblT4.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblT4.setForeground(Color.WHITE);
		panelIn.add(lblT4, "cell 1 7,alignx left,aligny top");
		
		list4.setBackground(Color.BLACK);
		list4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		list4.setForeground(Color.WHITE);
		panelIn.add(list4, "cell 1 8,grow");
						
		lblT5.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblT5.setForeground(Color.WHITE);
		panelIn.add(lblT5, "cell 1 9,alignx left,aligny top");
		
		list5.setBackground(Color.BLACK);
		list5.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		list5.setForeground(Color.WHITE);
		panelIn.add(list5, "cell 1 10,grow");
			
		lblT6.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblT6.setForeground(Color.WHITE);
		panelIn.add(lblT6, "cell 1 11,alignx left,aligny top");
		
		list6.setBackground(Color.BLACK);
		list6.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		list6.setForeground(Color.WHITE);
		panelIn.add(list6, "cell 1 12,grow");
							
		lblT7.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblT7.setForeground(Color.WHITE);
		panelIn.add(lblT7, "cell 1 13,alignx left,aligny top");
		
		list7.setBackground(Color.BLACK);
		list7.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		list7.setForeground(Color.WHITE);
		panelIn.add(list7, "cell 1 14,grow");
						
		lblT8.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblT8.setForeground(Color.WHITE);
		panelIn.add(lblT8, "cell 1 15,alignx left,aligny top");
		
		list8.setBackground(Color.BLACK);
		list8.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		list8.setForeground(Color.WHITE);
		panelIn.add(list8, "cell 1 16,grow");
		
		back_1.setIcon(new ImageIcon(MainFrame.class.getResource("/image/icon.png")));
		back_1.setBackground(Color.BLACK);
		back_1.setBorderPainted(false);
		back_1.addActionListener(new ActionListener()  // Return to parent panel
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				contPanel.add(menu, BorderLayout.CENTER);
				setTitle("Student Calendar");
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		panelIn.add(back_1, "cell 0 1,alignx trailing,aligny top");
		
		//----------------------------------------------------------------------------------------
		/* Settings of components on ADD-EVENT panel */
		final UpdateEvent process = new UpdateEvent();
		
		lblEventName.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblEventName.setForeground(Color.WHITE);
		lblEventName.setBounds(91, 150, 129, 32);
		addEvent.add(lblEventName);
		
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblSubject.setBounds(91, 188, 129, 32);
		addEvent.add(lblSubject);
		
		lblDeadline.setForeground(Color.WHITE);
		lblDeadline.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblDeadline.setBounds(91, 226, 129, 32);
		addEvent.add(lblDeadline);
		
		lblPriority.setForeground(Color.WHITE);
		lblPriority.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblPriority.setBounds(91, 264, 129, 32);
		addEvent.add(lblPriority);
		
		btnConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		btnConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(Color.BLACK);
		btnConfirm.setBounds(255, 337, 129, 47);
		btnConfirm.addActionListener(new ActionListener()  // Add new event and record it into the file
		{
			public void actionPerformed(ActionEvent e)
			{
				if (getName().equals(""))
				{
					new WarningDialog ("Please input the event name!");
				}
				else if (!process.reasonableTime(dateChooser.getDate()))
				{
					new WarningDialog ("This DEADLINE has passed, please set a new DEADLINE.");
				}
				else if (process.reasonableTime(dateChooser.getDate()))
				{
					EnsureDialog dlgEnsure = new EnsureDialog ("Are you sure to save your setting for this event?");
					if (dlgEnsure.getN()==JOptionPane.YES_OPTION)
					{
						process.saveDataToArray(user, getName(), getType(), getTime(dateChooser.getDate()), getLevel());
						refresh();
					}
					else if(dlgEnsure.getN()==JOptionPane.NO_OPTION)
				    {
				    }
				}
				/* Refresh panel after click */
				event.setText("");
				boxSubject.removeAllItems();
				for(int i=0;i<listSubject.length;i++)
				{
					boxSubject.addItem(listSubject[i]);
				}
				boxSubject.repaint();
				boxSubject.updateUI();
				showDate.setText("Click to choose date");
				boxPriority.removeAllItems();
				for(int i=0;i<listLevel.length;i++)
				{
					boxPriority.addItem(listLevel[i]);
				}
				boxPriority.repaint();
				boxPriority.updateUI();
				}
		});
		addEvent.add(btnConfirm);

		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(394, 337, 123, 47);
		btnCancel.addActionListener(new ActionListener()  // Return to parent panel 
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				contPanel.add(update, BorderLayout.CENTER);
				setTitle("Update Event");
				contPanel.revalidate(); 
				contPanel.repaint();
			}
		});
		addEvent.add(btnCancel);
		
		lblStudent_3.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblStudent_3.setBackground(Color.BLACK);
		lblStudent_3.setForeground(Color.WHITE);
		lblStudent_3.setBounds(12, 0, 226, 79);
		addEvent.add(lblStudent_3);
		
		lblCalendar_3.setBackground(Color.BLACK);
		lblCalendar_3.setForeground(Color.LIGHT_GRAY);
		lblCalendar_3.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblCalendar_3.setBounds(237, 1, 263, 77);
		addEvent.add(lblCalendar_3);
		
		lblAddEvent.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		lblAddEvent.setForeground(Color.WHITE);
		lblAddEvent.setBackground(Color.BLACK);
		lblAddEvent.setBounds(53, 101, 173, 37);
		addEvent.add(lblAddEvent);
		
		back_2.setIcon(new ImageIcon(MainFrame.class.getResource("/image/icon.png")));
		back_2.setBackground(Color.BLACK);
		back_2.setBounds(10, 101, 32, 32);
		back_2.setBorderPainted(false);
		back_2.addActionListener(new ActionListener()  // Return to parent panel 
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				contPanel.add(update, BorderLayout.CENTER);
				setTitle("Update Event");
				contPanel.revalidate(); 
				contPanel.repaint();
			}
		});
		addEvent.add(back_2);
		
		event.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		event.setBackground(Color.WHITE);
		event.setBounds(227, 155, 212, 26);
		addEvent.add(event);
		event.setColumns(10);
		
		boxSubject.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		boxSubject.setBackground(Color.WHITE);
		boxSubject.setBounds(227, 193, 212, 26);
		addEvent.add(boxSubject);
		
		showDate.setHorizontalAlignment(SwingConstants.LEFT);
		showDate.setBackground(Color.WHITE);
		showDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		dateChooser.register(showDate);
		dateChooser.setBounds(227, 231, 180, 26);
		addEvent.add(dateChooser);
		
		boxPriority.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		boxPriority.setBackground(Color.WHITE);
		boxPriority.setBounds(227, 269, 50, 26);
		addEvent.add(boxPriority);
		
		//----------------------------------------------------------------------------------------
		/* Settings of components on DELETE-EVENT panel */
		lblStudent_4.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblStudent_4.setBackground(Color.BLACK);
		lblStudent_4.setForeground(Color.WHITE);
		lblStudent_4.setBounds(12, 0, 226, 79);
		deleteEvent.add(lblStudent_4);
		
		lblCalendar_4.setBackground(Color.BLACK);
		lblCalendar_4.setForeground(Color.LIGHT_GRAY);
		lblCalendar_4.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblCalendar_4.setBounds(237, 1, 263, 77);
		deleteEvent.add(lblCalendar_4);
		
		lblDeleteEvent.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		lblDeleteEvent.setForeground(Color.WHITE);
		lblDeleteEvent.setBackground(Color.BLACK);
		lblDeleteEvent.setBounds(53, 101, 179, 37);
		deleteEvent.add(lblDeleteEvent);
		
		lblDeleteWhich.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDeleteWhich.setForeground(Color.WHITE);
		lblDeleteWhich.setBounds(80, 150, 170, 32);
		deleteEvent.add(lblDeleteWhich);
		
		boxDelete.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		boxDelete.setBackground(Color.WHITE);
		boxDelete.setBounds(238, 155, 212, 26);
		boxDelete.addActionListener(new ActionListener()  // Import the events of the chosen type to the list 
		 {
		   public void actionPerformed(ActionEvent e) 
		   {
		     listModel.removeAllElements();
		     Event[] a = FileManagement.getDataFromFile(user);
		     int index = UpdateEvent.numberType((String) boxDelete.getSelectedItem());
		     int[] b = UpdateEvent.subjectIndex(a, index);
		     for (int level=3; level>0; level--)
		     {
		    	 for (int i=0; i<UpdateEvent.arraySize(a); i++)
			     {
			    	 if(b[i]==1)
			    	 {
			    		 if(Integer.parseInt(a[i].getLevel())==level)
			    			 listModel.addElement(UpdateEvent.symbolLevel(a[i].getLevel())+" "+a[i].getName()+" - DEADLINE: "+a[i].getTime());
			    	 }
			     }
		     }
		   }
		 });
		deleteEvent.add(boxDelete);
		
		deleteList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		deleteList.setBackground(Color.BLACK);
		deleteList.setForeground(Color.WHITE);
		deleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deleteEvent.add(deleteList);
		
		panelWithin.setBackground(Color.BLACK);
		sP1.setViewportView(panelWithin);
		panelWithin.setLayout(new BorderLayout(0, 0));
		
		sP1.setBackground(Color.BLACK);
		sP1.setBounds(100, 200, 360, 130);
		deleteEvent.add(sP1);
		
		sP1.setViewportView(panelWithin);
		panelWithin.add(deleteList, BorderLayout.NORTH);
		
		btnDelete_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete_1.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnDelete_1.setForeground(Color.WHITE);
		btnDelete_1.setBackground(Color.BLACK);
		btnDelete_1.setBounds(250, 363, 120, 47);
		btnDelete_1.addActionListener(new ActionListener()  // Delete the selected item in the list
		{
			public void actionPerformed(ActionEvent e) 
			{
				Event[] before = FileManagement.getDataFromFile(user);
				String selected = deleteList.getSelectedValue().toString();
				String level = selected.substring(0,3);
				int timeIndex = selected.indexOf(" - DEADLINE: ")+13;
				int index = UpdateEvent.numberType((String) boxDelete.getSelectedItem());
				String name = selected.substring(4, timeIndex-13);
				String time = selected.substring(timeIndex);
				int position = UpdateEvent.position(before, UpdateEvent.arraySize(before), index, name, time, level);
				Event[] after = UpdateEvent.deleteItem(before, position);
				listModel.removeAllElements();
				int[] b = UpdateEvent.subjectIndex(after, index);
			    for (int p=3; p>0; p--)
			    {
			    	for (int i=0; i<UpdateEvent.arraySize(after); i++)
			    	{
			    		 if(b[i]==1)
				    	 {
				    		 if(Integer.parseInt(after[i].getLevel())==p)
				    		 {
				    			 listModel.addElement(UpdateEvent.symbolLevel(after[i].getLevel())+" "+after[i].getName()+" - DEADLINE: "+after[i].getTime());
				    		 }
				    	 }
			    	}
			    }
				FileManagement.wipeOutFile(user);
				UpdateEvent.saveSelection(user, after);
				refresh();
			}
		});
		deleteEvent.add(btnDelete_1);
		
		btnCancel_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel_1.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnCancel_1.setForeground(Color.WHITE);
		btnCancel_1.setBackground(Color.BLACK);
		btnCancel_1.setBounds(394, 363, 123, 47);
		btnCancel_1.addActionListener(new ActionListener()  // Return to parent panel 
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				contPanel.add(update, BorderLayout.CENTER);
				refresh();
				setTitle("Update Event");
				contPanel.revalidate(); 
				contPanel.repaint();
			}
		});
		deleteEvent.add(btnCancel_1);
		
		
		back_3.setIcon(new ImageIcon(MainFrame.class.getResource("/image/icon.png")));
		back_3.setBackground(Color.BLACK);
		back_3.setBounds(10, 101, 32, 32);
		back_3.setBorderPainted(false);
		back_3.addActionListener(new ActionListener()  // Return to parent panel 
		{
			public void actionPerformed(ActionEvent e) 
			{
				contPanel.removeAll();
				contPanel.add(update, BorderLayout.CENTER);
				refresh();
				setTitle("Update Event");
				contPanel.revalidate(); 
				contPanel.repaint(); 
			}
		});
		deleteEvent.add(back_3);
	}
	//----------------------------------------------------------------------------------------
	/* Return values of information get from components on ADD-EVENT panel */
	public String getName()  // get event NAME that user types
	{
		return (event.getText());  
	}
	
	public String getType()  // get event TYPE that user chooses
	{
		return (String) (boxSubject.getSelectedItem());  
	}
	
	public String getTime(Date date)  // get event DATE that user clicks and transfer it in to a particular format;
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
	    return df.format(date);
	}
	
	public String getLevel()  // get event LEVEL that user chooses
	{
		return ((String) boxPriority.getSelectedItem());		
	}
	//----------------------------------------------------------------------------------------
	/* Refresh the frame by calling setLabel() and addEventToModel() */
	public void refresh()
	{
		setLabels();
		subjects = UpdateEvent.getSubjects(user);
		addEventToModel(subjects[8], eventModel1);
		addEventToModel(subjects[1], eventModel2);
		addEventToModel(subjects[2], eventModel3);
		addEventToModel(subjects[3], eventModel4);
		addEventToModel(subjects[4], eventModel5);
		addEventToModel(subjects[5], eventModel6);
		addEventToModel(subjects[6], eventModel7);
		addEventToModel(subjects[7], eventModel8);
	}
	//----------------------------------------------------------------------------------------
	/* Add the events under particular type to list models that are displayed in TODO panel */
	public void addEventToModel(String type, DefaultListModel eventModel)
	{
		eventModel.removeAllElements();
		Event[] a = FileManagement.getDataFromFile(user);
		int index = UpdateEvent.numberType(type);
		int[] b = UpdateEvent.subjectIndex(a, index);
		for (int level=3; level>0; level--)
		{
			for (int i=0; i<UpdateEvent.arraySize(a); i++)
			{
				if(b[i]==1)
				{
					if(Integer.parseInt(a[i].getLevel())==level)
						eventModel.addElement(UpdateEvent.symbolLevel(a[i].getLevel())+" "+a[i].getName()+" - DEADLINE: "+a[i].getTime());
				}
			}
		}
	}
	//----------------------------------------------------------------------------------------
	/* Set the contents setting contents under NOTIFICATION bar on home page */
	public void setLabels()
	{
		if (FileManagement.eventsExists(user))
		{
			if (Integer.toString(UpdateEvent.arraySize(FileManagement.getDataFromFile(user))).equals("1"))
			{
				lblEventsAmount.setText("You have "+Integer.toString(UpdateEvent.arraySize(FileManagement.getDataFromFile(user)))+" thing to do");
				lblTips.setText("Please remember to finish it  :)");
				lblNumOfThings.setText(Integer.toString(UpdateEvent.arraySize(FileManagement.getDataFromFile(user))));
			}
			else if (UpdateEvent.arraySize(FileManagement.getDataFromFile(user))==0)
			{
				lblEventsAmount.setText("You have finished doing everything!");
				lblTips.setText("Congratulations! :)");
				lblNumOfThings.setText("no");
			}
			else
			{
				lblEventsAmount.setText("You have "+Integer.toString(UpdateEvent.arraySize(FileManagement.getDataFromFile(user)))+" things to do");
				lblTips.setText("Please remember to finish them  :)");
				lblNumOfThings.setText(Integer.toString(UpdateEvent.arraySize(FileManagement.getDataFromFile(user))));
			}
		}
		else if(!FileManagement.eventsExists(user))
		{
			lblEventsAmount.setText("Welcome to Student Calendar!");
			lblTips.setText("Please create Events first :)");
			lblNumOfThings.setText("no");
		}
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
					MainFrame frame = new MainFrame();
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