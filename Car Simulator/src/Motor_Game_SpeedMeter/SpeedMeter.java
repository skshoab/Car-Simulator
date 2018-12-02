package Motor_Game_SpeedMeter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Game_Motor.Motor;

public class SpeedMeter {
	private Motor motor;
	public SpeedMeter(Motor motor)
	{
		this.motor=motor;
				
		
	}
	public void render(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillOval(8,98, 100+2*2, 100+2*2);
		
		g.setColor(Color.WHITE);
		g.fillOval(10,100, 100, 100);
		
		double speed=motor.getSpeed()%60.0/7 * Math.PI*2;
		
		int centerX=10+50;
		int centerY=100+50;
		int animX=(int) (centerX + Math.sin(speed)*40);
		int animY=(int) (centerY-Math.cos(speed)*40);
		
		g.setColor(Color.CYAN);
		g.drawLine(centerX, centerY, animX, animY);
		

		for(int i=1;i<=6;i++)
		{
			int radian=(int) (i%7.0/7 *Math.PI*2);
			int anim3=(int) ((centerX-4) + Math.sin(radian)*40);
			int anim4=(int) ((centerY+4)-Math.cos(radian)*40);
			
			g.setFont(new Font("arial",Font.PLAIN,12));
			String j= Integer.toString(i);
			g.drawString(j,anim3,anim4);
		}
		
		
				
	}
}
