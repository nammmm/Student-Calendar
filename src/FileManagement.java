/**
 * @Class: FileManagement
 * @Description:  Contains methods that related to the file. Saves the information of events and accounts into the file.
 */
import java.io.*;
public class FileManagement
{ 	
	//----------------------------------------------------------------------------------------
	/* Create file */
	public static void createFile(String name) throws IOException 
	{ 
		File filename = new File(name); 
		if (!filename.exists()) 
		{ 
			filename.createNewFile();  
		} 
	}
	//----------------------------------------------------------------------------------------
	/* Produce a unique filename for users */
	public static String createFileName(String user) 
	{
		String fileName = "events-"+user;
		fileName = fileName + ".txt"; 
		return fileName;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * @purpose: To save the pass-in array to file
	 * @param: <String> user, <Event[]> a                                      
	 */
	public void saveArrayToFile(String user, Event[] a)
	{
		try
		{
			int count = 0;
			createFile(createFileName(user));
			PrintWriter f = new PrintWriter (new FileWriter(createFileName(user),true));
			while (a[count].getNumber()!=-1)
			{
				f.println("Name: "+a[count].getName());
				f.println("Type: "+a[count].getType());
				f.println("Deadline: "+a[count].getTime());
				f.println("Priority: "+a[count].getLevel());
				f.println("----------------------------------------------------------------------------------------");
				count = count+1;
			}
			f.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------
	/* Re-write content in the file by deleting the file and creating it again */
	public static void wipeOutFile(String user)
	{	
		try
		{
			File oldFile = new File(createFileName(user));
			oldFile.delete();
			File newFile = new File(createFileName(user));
			newFile.createNewFile();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------
	/* Judge if the events file exists */
	public static boolean eventsExists(String user)
	{	
		File a = new File(createFileName(user));
		if (a.exists())
			return (true);
		else
			return (false);
	}
	//----------------------------------------------------------------------------------------
	/**
	 * @purpose: Read the events from the file and assign the information to an array
	 * @param: <String> username
	 * @return: <Event[]> a                                     
	 */
	public static Event[] getDataFromFile(String username)
	{
		Event[] a = new Event [100];
		int count = 0;
		try
		{
			BufferedReader f = new BufferedReader (new FileReader(createFileName(username)));
			while (f.ready())
			{
				a[count] = new Event();
				String name = f.readLine().substring(6);
				String type = f.readLine().substring(6);
				String time = f.readLine().substring(10);
				String level = f.readLine().substring(10);
				String space = f.readLine();
				a[count].set(name, type, time, level);
				a[count].setNumber(UpdateEvent.numberType(type));
				count = count+1;
			}
			f.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		a[count] = new Event();
		a[count].set(null, null, null, null);
		a[count].setNumber(-1);
		return a;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * @purpose: Save the information of an account to log.txt
	 * @param: <Account> a                                  
	 */
	public void saveAccountToFile(Account a)
	{
		try
		{
			PrintWriter f = new PrintWriter (new FileWriter("log.txt",true));
			f.println("User: "+a.getUser());
			f.println("Password: "+a.getPassword());
			f.println("Name: "+a.getName());
			f.println("Subjects: "+a.getSubjects());
			f.close();
		}
		catch(IOException e)
		{
			System.out.println("log.txt has been created.");
		}
	}
	//----------------------------------------------------------------------------------------
	/* Judge if the log file exists */
	public static boolean logExists()
	{	
		File a = new File("log.txt");
		if (a.exists())
			return (true);
		else
			return (false);
	}
	//----------------------------------------------------------------------------------------
	/**
	 * @purpose: Read the account information from the file and assign the information to an object
	 * @param: <String> username
	 * @return: <Account> a                                     
	 */
	public static Account getAccountFromFile(String username)
	{
		Account a = new Account();
		try
		{
			BufferedReader f = new BufferedReader (new FileReader("log.txt"));
			String stringLine;
			boolean done = false;
			while ((stringLine = f.readLine()) != null && !done)   
			{
				if(stringLine.equals("User: "+username))
				{
				    String user = stringLine.substring(6);
					String password = f.readLine().substring(10);
					String name = f.readLine().substring(6);
					String subjects = f.readLine().substring(10);
					a.set(user, password, name, subjects);
					done = true;
			    }
			}
			f.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		return a;
	}

}