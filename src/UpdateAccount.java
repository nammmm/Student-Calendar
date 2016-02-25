/**
 * @Class: UpdateAccount
 * @Description: Including methods of all operations related to ACCOUNT
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class UpdateAccount 
{
	private static String user;
	//----------------------------------------------------------------------------------------
	/* Constructor */
	public UpdateAccount()
	{
		Account a = new Account();
		a.set(null, null, null, null);
	}
	//----------------------------------------------------------------------------------------
	public static void setUser(String aUser)  // Store the current Username into memory
	{
		user = aUser;
	}
	public static String getUser()  // Return the current Username
	{
		return user;
	}
	public static String getName()  // Return the name of current user
	{
		Account a = FileManagement.getAccountFromFile(user);
		return a.getName();
	}

	//----------------------------------------------------------------------------------------
	/* Save the data to an Account object and call saveSelection(Account a) method */
	public void saveDataToArray(String aUser, String aPassword, String aName, String aSubjects)
	{
		Account a = new Account();
		a.set(aUser, aPassword, aName, aSubjects);
		saveSelection(a);
	}
	//----------------------------------------------------------------------------------------
	/* Save the Account object to file */
	public static void saveSelection(Account a)
	{
		FileManagement f = new FileManagement();
		f.saveAccountToFile(a);
	}
	//----------------------------------------------------------------------------------------
	/**
	 * @purpose: To judge whether the username exists
	 * @param: <String> username
	 * @return: <boolean> exists                                        
	 */
	public static boolean ifUsernameExist(String username)
	{
		boolean exist = false;
		try
		{
			BufferedReader f = new BufferedReader (new FileReader("log.txt"));
			String stringLine;
			while ((stringLine = f.readLine()) != null && !exist)   
			{
				if(stringLine.equals("User: "+username))
				{
				    exist = true;
				    setUser(username);
			    }
				else
				{
					exist = false;
				}
			}
			f.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		return exist;
	}

	//----------------------------------------------------------------------------------------
	/**
	 * @purpose: To judge whether the password is correct
	 * @param: <String> username, <char[]> input
	 * @return: <boolean> isCorrect                                        
	 */
	public static boolean isPasswordCorrect(String username, char[] input) 
	{
        boolean isCorrect = true;
        Account a = FileManagement.getAccountFromFile(username);
        String password = a.getPassword();
        char[] correctPassword = password.toCharArray();

        if (input.length != correctPassword.length) 
        {
            isCorrect = false;
        } 
        else 
        {
            isCorrect = Arrays.equals (input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword,'0');

        return isCorrect;
    }

}