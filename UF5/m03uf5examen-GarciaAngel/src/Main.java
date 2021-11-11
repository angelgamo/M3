
public class Main 
{
	public static void main(String[] args) 
	{
		AchievementManager achievementManager = new AchievementManager();
		EventManager eventManager = EventManager.getInstance();
		
		Object pokeball = "Pokéball";
		Object masterBall = "MasterBall";
		
		RewardDrop dropPokeball = new RewardDrop(pokeball);
		RewardDrop dropMasterBall = new RewardDrop(masterBall);
		RewardGrantXP grant100xp = new RewardGrantXP(100);
		RewardGrantXP grant1000xp = new RewardGrantXP(1000);
		
		AchievementCatch yourJourneyBegins = new AchievementCatch("Your Journey Begins", 1);
		yourJourneyBegins.AddReward(dropPokeball);
		achievementManager.AddAchievement(yourJourneyBegins);
		
		AchievementCatch beginnerTrainer = new AchievementCatch("Beginner Trainer", 10);
		beginnerTrainer.AddReward(dropMasterBall);
		beginnerTrainer.AddReward(grant1000xp);
		achievementManager.AddAchievement(beginnerTrainer);
		
		AchievementPick myFirstBall = new AchievementPick("My First Ball", 1, pokeball);
		myFirstBall.AddReward(grant100xp);
		achievementManager.AddAchievement(myFirstBall);
		
		AchievementPick gottacatchemall = new AchievementPick("Gotta catch ‘em all", 1, masterBall);
		gottacatchemall.AddReward(grant1000xp);
		achievementManager.AddAchievement(gottacatchemall);
		
		for (int i = 0; i < 10; i++) {
			eventManager.NotifyObservers("OnCatch", null);
			achievementManager.ShowAchievements();
		}
	}
}
