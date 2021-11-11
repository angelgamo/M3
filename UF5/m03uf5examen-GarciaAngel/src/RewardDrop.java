
public class RewardDrop extends Reward 
{
	Object object;
	
	public RewardDrop(Object object) 
	{
		super();
		this.object = object;
	}
	
	@Override
	public void execute() 
	{
		System.out.println("You received: " + object.toString());
		EventManager.getInstance().NotifyObservers("OnPick", object);
	}

	@Override
	public String toString() 
	{
		return "RewardDrop [object=" + object + "]";
	}
}
