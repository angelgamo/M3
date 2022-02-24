
public class Main {
	
	static int FPS = 60;
	
	public static void main(String[] args) {
		
		GameLoop core = GameLoop.GetInstance();
		boolean end = false;
		
		long optimalTime = 1000000000 / FPS;
		
		core.init();
		
		long now;
		long updateTime;
		long wait;
		
		while (!end) {
			now = System.nanoTime();
	        
			core.input();
			core.update();
			core.render();
			
			updateTime = System.nanoTime() - now;
	        wait = (optimalTime - updateTime) / 1000000;
	        
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
