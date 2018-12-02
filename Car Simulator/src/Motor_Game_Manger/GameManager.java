package Motor_Game_Manger;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Game_Motor.Motor;
import Motor_Game.Display;
import Motor_Game_Enemy.EnemyMotor;
import Motor_Game_Graphics.LoadImage;
import Motor_Game_SpeedMeter.SpeedMeter;
import Motor_Game_World.World;

public class GameManager {
	
	 //private int y;
	private World world;
	private Motor motor;
	
	private long time=System.nanoTime();
	private long delay;
	private int health;
	private SpeedMeter meter;
	
	private ArrayList<EnemyMotor> eMotor;
	
	public GameManager()
	{
		motor=new Motor();
		world=new World(motor);
		eMotor=new ArrayList<EnemyMotor>();
		meter=new SpeedMeter(motor);
		
		delay=2000;
		health=3;
	}
	public void init()
	{
		//y=0;
		
		
		motor.init();
		LoadImage.init();
	}
	
	public void tick()
	{
		Random rand=new Random();
		int randX=rand.nextInt(300);
		int randY=rand.nextInt(Display.height);
		while(randX<150){
			randX=rand.nextInt(300);
		}
		for(int i=0;i<eMotor.size();i++){
			int px=motor.getX();
			int py=motor.getY();
			
			//Enemy player
			int ex=eMotor.get(i).getX();
			int ey=eMotor.get(i).getY();
			
			if(px<ex+40  && px+40>ex && py<ey+40 && py+40>ey){
				//collided
				eMotor.remove(i);
				i--;
				health--;
				//System.out.println(health);
				motor.setHealth(health);
				motor.setSpeed(0);
				
			}
		}
		
		long elapsed=(System.nanoTime()-time)/1000000;
		if(elapsed>delay){
			if(motor.getSpeed()>=3){
				eMotor.add(new EnemyMotor(motor,randX,(-randY)+motor.getOfset()));
				time=System.nanoTime();
			}
			
		}
		
		
		//y+=1;
		motor.tick();
		//EnemyMotor
		for(int i=0;i<eMotor.size();i++){
			eMotor.get(i).tick();
		}
	}
	
	public void render(Graphics g)
	{
		//g.fillRect(40, y,60, 60);
		motor.render(g);
		g.drawImage(LoadImage.img, 40, 40,100,100,null);
//		g.drawImage(LoadImage.subImage1, 150, 150,100,100, null);
//		g.drawImage(LoadImage.subImage2, 300, 300,100,100, null);
		world.render(g);
		motor.render(g);
		meter.render(g);
		for(int i=0;i<eMotor.size();i++){
			eMotor.get(i).render(g);
		}
	}
}
