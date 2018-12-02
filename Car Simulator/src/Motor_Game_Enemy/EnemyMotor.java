package Motor_Game_Enemy;

import java.awt.Graphics;

import Game_Motor.Motor;
import Motor_Game_Graphics.LoadImage;

public class EnemyMotor {
	private int x,y;
	private Motor motor;
	
	public EnemyMotor(Motor motor,int x,int y)
	{
		this.x=x;
		this.y=y;
		this.motor=motor;
	}
	public void tick()
	{
		y+=1;
	}
	public void render(Graphics g)
	{
		g.drawImage(LoadImage.imgEnemy, x, y-motor.getOfset(),40,70, null);
		
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
}
