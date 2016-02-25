/**
 * @Class: Event
 * @Description: Contains 5 instance fields, setters and getters
 */
public class Event
{
	private String name;
	private String type;
	private String time;
	private String level;
	private int number;

	public Event()
	{
		name = null;
		type = null;
		time = null;
		level = null;
		number = -1;
	}
	public Event(String aName, String aType, String aTime, String aLevel, int aNumber)
	{
		name = aName;
		type = aType;
		time = aTime;
		level = aLevel;
		number = aNumber;
	}
	
   /***************************************************************************
	*  Setter methods
	***************************************************************************/
	public void set(String aName, String aType, String aTime, String aLevel)
	{
		name = aName;
		type = aType;
		time = aTime;
		level = aLevel;
	}
	public void setNumber(int aNumber)
	{
		number = aNumber;
	}
	
   /***************************************************************************
	*  Getter methods
	***************************************************************************/
	public String getName()
	{
		return name;
	}
	public String getType()
	{
		return type;
	}
	public String getTime()
	{
		return time;
	}
	public String getLevel()
	{
		return level;
	}
	public int getNumber()
	{
		return number;
	}

}