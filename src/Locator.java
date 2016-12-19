
public class Locator {
	 int ID;
	 String ItemNumber;
	 String PO;
	 String Location;
	 int Amount;
	 String UserName;
	 String Type;
	
	public Locator(int ID, String ItemNumber, String PO, String Location, int Amount, String UserName, String Type)
	{
		this.ID = ID;
		this.ItemNumber = ItemNumber;
		this.PO = PO;
		this.Location = Location;
		this.Amount = Amount;
		this.UserName = UserName;
		this.Type = Type;
		
	}

	public String getItemNumber()
	{
		return ItemNumber;
	}
	public String getPO()
	{
		return PO;
	}
	public String getLocation()
	{
		return Location;
	}
	public int getAmount()
	{
		return Amount;
	}
	public String getUserName()
	{
		return UserName;
	}
	public int getID()
	{
		return ID;
	}
}
