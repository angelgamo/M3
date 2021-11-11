
public class AchievementCatch extends Achievement 
{
	String event;
	int catchCount;
	
	public AchievementCatch(String name, int catchCount) 
	{
		super(name);
		this.event = "OnCatch";
		this.catchCount = catchCount;
		EventManager.getInstance().RegisterObserver(event, this);
	}
	
	void process() 
	{
		catchCount--;
		if (catchCount <= 0)
		{
			EventManager.getInstance().UnregisterObserver(event, this);
			this.completed = true;
			Rewards();
		}
	}
	
	public void event(String event, Object object)
	{
		if (this.event.equals(event))
		{
			process();
		}
	}
}
