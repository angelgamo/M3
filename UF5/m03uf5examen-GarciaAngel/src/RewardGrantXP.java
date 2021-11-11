
public class RewardGrantXP extends Reward 
{
	int xp;
	
	public RewardGrantXP(int xp) 
	{
		super();
		this.xp = xp;
	}
	
	@Override
	public void execute() 
	{
		System.out.println("Gained " + xp + " experience points.");
	}

	@Override
	public String toString() 
	{
		return "RewardGrantXP [xp=" + xp + "]";
	}

}
