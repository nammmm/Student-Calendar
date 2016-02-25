/**
 * @Class: Account
 * @Description: Contains 4 instance fields, setters and getters
 */
public class Account 
{
	private String user;
	private String password;
	private String name;
	private String subjects;
	
	public Account()
	{
		user = null;
		password = null;
		name = null;
		subjects = null;
	}
	public Account(String aUser, String aPassword, String aName, String aSubjects)
	{
		user = aUser;
		password = aPassword;
		name = aName;
		subjects = aSubjects;
	}
	
   /***************************************************************************
	*  Setter methods
	***************************************************************************/
	public void set(String aUser, String aPassword, String aName, String aSubjects)
	{
		user = aUser;
		password = aPassword;
		name = aName;
		subjects = aSubjects;
	}
	
   /***************************************************************************
	*  Getter methods
	***************************************************************************/
	public String getUser()
	{
		return user;
	}
	public String getPassword()
	{
		return password;
	}
	public String getName()
	{
		return name;
	}
	public String getSubjects()
	{
		return subjects;
	}
}
