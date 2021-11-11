import java.util.ArrayList;
import java.util.Collections;

public class AchievementManager 
{
	ArrayList<Achievement> achievments;
	
	public AchievementManager()
	{
		super();
		achievments = new ArrayList<Achievement>();
	}
	
	public void AddAchievement(Achievement achievement)
	{
		achievments.add(achievement);
	}
	
	public void RemoveAchievement(Achievement achievement)
	{
		achievments.remove(achievement);
	}
	
	public void OrderAchivements()
	{
		Collections.sort(achievments);
	}
	
	public void ShowAchievements() 
	{
		OrderAchivements();
		System.out.println("\nAchivements");
		for (Achievement achievement : achievments) 
		{
			System.out.println(achievement);
		}
	}
}
