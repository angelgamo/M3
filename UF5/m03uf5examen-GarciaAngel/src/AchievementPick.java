
public class AchievementPick extends Achievement 
{

	String event;
	Object object;
	int pickCount;
	
	public AchievementPick(String name, int pickCount, Object object) 
	{
		super(name);
		this.event = "OnPick";
		this.pickCount = pickCount;
		this.object = object;
		EventManager.getInstance().RegisterObserver(event, this);
	}
	
	void process() 
	{
		pickCount--;
		if (pickCount <= 0)
		{
			EventManager.getInstance().UnregisterObserver(event, this);
			this.completed = true;
			Rewards();
		}
	}
	
	public void event(String event, Object object)
	{
		if (this.event.equals(event) && this.object.equals(object))
		{
			process();
		}
	}
	
}
