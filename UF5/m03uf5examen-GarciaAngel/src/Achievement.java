import java.util.ArrayList;

public abstract class Achievement implements Observer, Comparable<Achievement>
{
	String name;
	boolean completed;
	ArrayList<Reward> rewards;
	
	public Achievement(String name) 
	{
		super();
		this.name = name;
		this.completed = false;
		this.rewards = new ArrayList<Reward>();
	}
	
	abstract void process();
	public abstract void event(String event, Object object);
	
	void Rewards() 
	{
		for (Reward reward : rewards) 
		{
			reward.execute();
		}
	}
	
	public void AddReward(Reward reward)
	{
		this.rewards.add(reward);
	}
	
	@Override
	public int compareTo(Achievement o) 
	{
		int completed = this.completed && !o.completed ? -1 : !this.completed && o.completed ? 1: 0;
		int name = this.name.compareTo(o.name);
		int rewards = this.rewards.size() < o.rewards.size() ? -1 : this.rewards.size() > o.rewards.size() ? 1 : 0;
		
		if (completed != 0) return completed;
		else if (name != 0) return name;
		else return rewards;
	}

	@Override
	public String toString() 
	{
		return "Achievement [name=" + name + ", completed=" + completed + ", rewards=" + rewards + "]";
	}
}
