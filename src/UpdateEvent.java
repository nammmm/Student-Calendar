/**
 * @Class: UpdateEvent                                                    
 * @Description: Including methods of all operations related to EVENT 
 */ 
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class UpdateEvent
{
	private static Event[] a;
	//----------------------------------------------------------------------------------------
	/* Constructor */
	public UpdateEvent()
	{
		a = new Event[100];
		a[0] = new Event();
		a[0].set(null, null, null, null);
		a[0].setNumber(-1);// -1 is a sentinel to indicate the end
	}
	//----------------------------------------------------------------------------------------
	/**
	 * @purpose: Save the data to a Event[] array and call saveSelection(Event[] a) method 
	 * @param: <String> user, <String> aName, <String> aType, <String> aTime, <String> aLevel                                           
	 */
	public void saveDataToArray(String user, String aName, String aType, String aTime, String aLevel)
	{
		boolean done = true;
		int count = 0;
		while (done && count<a.length-1)
		{
			a[count] = new Event();
			a[count].set(aName, aType, aTime, aLevel);
			a[count].setNumber(numberType(a[count].getType()));
			count = count+1;
			done = false;	
		}
		a[count] = new Event();
		a[count].set(null, null, null, null);
		a[count].setNumber(-1);
		saveSelection(user, a);
	}
	//----------------------------------------------------------------------------------------
    /* Save the Event[] array to file */
	public static void saveSelection(String user, Event[] a)
	{
		FileManagement f = new FileManagement();
		f.saveArrayToFile(user, a);
	}
	//----------------------------------------------------------------------------------------
	/* To judge whether the chosen time is out of date */
	public boolean reasonableTime(Date b) // a typical handling error
	{
		boolean reason = true;
		Date a = new Date();
		if (b.after(a))
		{
			reason = true;
		}
		else
		{
			reason = false;
		}
		return reason;
	}
	//----------------------------------------------------------------------------------------
	/** 
	 * @purpose: Delete a item in the array and return a new Event[] array with modified size
	 * @param: <Event[]> a, <int> index
	 * @return: <Event[]> a                                                                      
	 */
	public static <Event> Event[] deleteItem(Event[] a, int index) 
	{
	    int len = a.length;
	    if(index < 0 || index >= len) 
	    {
	        throw new IllegalArgumentException("Out of bounds");
	    }
	    List<Event> list = new LinkedList<Event>();
	    for(int i = 0; i < len; i++) 
	    {
	        if(i != index) 
	        {
	            list.add(a[i]);
	        }
	    }
	    a = list.toArray(a);
	    return java.util.Arrays.copyOf(a, a.length - 1);
	}
	//----------------------------------------------------------------------------------------
    /* 
     * Return reference number of each type of event 
     * P.S: the reason why I don't use switch condition because it requires JDK1.7
     */
	public static int numberType(String type)
	{
		int number=-1;
		String item=type.toLowerCase();
		if (item.equalsIgnoreCase("others"))
		{
			number=1;
		}
		else if (item.equalsIgnoreCase("chinese"))
		{
			number=2;
		}
		else if (item.equalsIgnoreCase("english"))
		{
			number=3;
		}
		else if (item.equalsIgnoreCase("korean"))
		{
			number=4;
		}
		else if (item.equalsIgnoreCase("business and management"))
		{
			number=5;
		}
		else if (item.equalsIgnoreCase("economics"))
		{
			number=6;
		}
		else if (item.equalsIgnoreCase("geography"))
		{
			number=7;
		}
		else if (item.equalsIgnoreCase("biology"))
		{
			number=8;
		}
		else if (item.equalsIgnoreCase("chemistry"))
		{
			number=9;
		}
		else if (item.equalsIgnoreCase("physics"))
		{
			number=10;
		}
		else if (item.equalsIgnoreCase("mathematics"))
		{
			number=11;
		}
		else if (item.equalsIgnoreCase("computer"))
		{
			number=12;
		}
		else if (item.equalsIgnoreCase("visual arts"))
		{
			number=13;
		}
		else if (item.equalsIgnoreCase("tok"))
		{
			number=14;
		}
		return number;
	}
	//----------------------------------------------------------------------------------------
    /* Change the level from String type to Integer type */
	public static int importance(String level)
	{
		int number = Integer.parseInt(level);
		return number;
	}
	//----------------------------------------------------------------------------------------
    /* Change the time from String type to Date type */
	public static Date date(String time) throws ParseException
	{
		Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(time);
		return date;
	}
	//----------------------------------------------------------------------------------------
    /* Change the level from number to exclamation mark */
	public static String symbolLevel(String aLevel)
	{
		String a = null;
		if (aLevel.equals("1"))
		{
			a = "!  ";
		}
		else if (aLevel.equals("2"))
		{
			a = "!! ";
		}
		else if (aLevel.equals("3"))
		{
			a = "!!!";
		}
		return a;
	}
	//----------------------------------------------------------------------------------------
    /* Change the level from exclamation mark to number */
	public static String levelSymbol(String aLevel)
	{
		String a = null;
		if (aLevel.equals("!  "))
		{
			a = "1";
		}
		else if (aLevel.equals("!! "))
		{
			a = "2";
		}
		else if (aLevel.equals("!!!"))
		{
			a = "3";
		}
		return a;
	}
	//----------------------------------------------------------------------------------------
    /* Count the number of event in the file */
	public static int arraySize (Event[] a)
	{
		boolean done = false;
		int i = 0;
		while (!done)
		{
			done = true;
			if (a[i].getNumber()!=-1)
			{
				done = false;
			}
			i++;
		}
		return (i-1);
	}
	//----------------------------------------------------------------------------------------
    /* Return a int[] array that indicates the position of all events of one type */
	public static int[] subjectIndex(Event[] a, int index)
	{
		int[] position = new int[100];
		int count = 0;
		for (int i=0; i<arraySize(a); i++)
		{
			if (a[i].getNumber()==index)
			{
				position[count] = 1;
			}
			else
			{
				position[count] = 0;
			}
			count = count+1;
		}
		return position;
	}
	//----------------------------------------------------------------------------------------
    /* Return the location of a item in the file */
	public static int position(Event[] a, int size, int type, String name, String time, String aLevel)
	{
		boolean  found = false;
		int i=0;
		String level = levelSymbol(aLevel);
		while (!found&&i<size)
		{
			if(a[i].getNumber()==type&&a[i].getTime().equals(time)&&a[i].getName().equals(name)&&a[i].getLevel().equals(level))
			{
				found = true;
			}
			else
				i++;
		}
		if(found)
			return i;
		else
			return -1;
	}
	//----------------------------------------------------------------------------------------
	/** 
	 * @purpose: Get the 6 subjects that user has chosen and assign them to a String[] array
	 * @param: <String> user
	 * @return: <String[]> subjectsList                                                                      
	 */
	public static String[] getSubjects(String user)
	{
		Account a = FileManagement.getAccountFromFile(user);
		String[] subjectsList = new String[9];
		String s = a.getSubjects();
		char c = '/';
		int head = 0;
		int tail = 0;
		int count = 1;
		char[] chars = s.toCharArray();
		for(int i=0; i<chars.length; i++)
		{
			if(c == chars[i])
			{
				tail = i;
				subjectsList[count] = (s.substring(head, tail));
				head = tail+1;
				count++;
			}
		}
		count++;
		subjectsList[0] = "";
		subjectsList[8] = "Others";
		return subjectsList;
	}	
	//----------------------------------------------------------------------------------------
	/** 
	 * @purpose: Return a String[] array that contains all events of one type in certain format
	 * @param: <String> user, <String> subject
	 * @return: <String[]> list                                                                     
	 */
	public static String[] getEvent(String user, String subject)
	{
		Event[] a = FileManagement.getDataFromFile(user);
		int index = numberType(subject);
		int[] b = UpdateEvent.subjectIndex(a, index);
		List<String> where = new ArrayList<String>();
		for (int position=3; position>0; position--)
		{
			for (int i=0; i<UpdateEvent.arraySize(a); i++)
		     {
		    	 if(b[i]==1)
		    	 {
		    		 if(Integer.parseInt(a[i].getLevel())==position)
		    			 where.add(UpdateEvent.symbolLevel(a[i].getLevel())+" "+a[i].getName()+" - DEADLINE: "+a[i].getTime());
		    	 }
		     }
		}
		String[] list = new String[where.size()];
		where.toArray(list);
		return list;
	}
}