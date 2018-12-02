package Game_Motor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Motor_Game.Display;
import Motor_Game_Graphics.LoadImage;
import Motor_Game_Tile.Tile;

public class Motor implements KeyListener {
	private int x,y;
	private int ofset;
	private boolean left,right,up,down;
	private double speed;
	private int health;
	private int gear;
	
	public Motor()
	{
		x=Display.width/2;
		y=Tile.tileHeight*120;
		ofset=0;
		speed=0.3f;
		
		health=3;
		gear=0;
		
	}
	public void init()
	{
		
		Display.frame.addKeyListener(this);
		
	}
	public void tick()
	{
//		x+=1;
//		y+=1;
		System.out.println(y);
		if(health>0){
			ofset= y-(Display.height-100);
			
			if(right){
				if(x<=343){
					x+=1;
				}
				
			}
			if(left){
				if(x>=130){
					x-=1;
				}
				
			}
			if(up){
				if(y>700){
					//y-=1;
					speed+=0.03f;
					if(speed>=7){
						speed=7;
					}
				}
				
			}
			if(y>700){
				y-=speed;
			}
			
			if(down){
				speed-=0.30f;
				if(speed<=0){
					speed=0;
				}
			}
			
		}
		
		
	}
	public double getSpeed()
	{
		return speed;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
		
	}
	public int getOfset()
	{
		return ofset;
	}
	public void setSpeed(double speed)
	{
		this.speed=speed;
	}
	public void setHealth(int health)
	{
		this.health=health;
	}
	
	public void drawBoard(Graphics g)
	{
		int sp=(int)speed;
		switch(sp)
		{
		case 0: gear=0;
			break;
		case 2: gear=1;
			break;
		case 4: gear=2;
			break;
		case 6: gear=3;
			break;
		}
		g.setColor(Color.white);
		g.fillRect(10, 10, 150, 80);
		
		g.setColor(Color.BLUE);
		String str=Integer.toString(gear);
		g.drawString("Gear: "+str, 20, 40);
		g.setFont(new Font("arial",Font.BOLD,30));
		g.drawString("Health: "+health, 20, 80);
		
	}
	public void gameOver(Graphics g)
	{
		g.setColor(Color.red);
		g.setFont(new Font("arail",Font.BOLD,33));
		g.drawString("Game Over", Display.width/3, Display.height/2);
	}
	public void render(Graphics g)
	{
		if(health>0){
			g.setColor(Color.red);
			g.drawImage(LoadImage.imgPlayer,x, y-ofset, 40, 70,null);
		}
		else{
			gameOver(g);
		}
		
		drawBoard(g);
	}
	
	public void keyPressed(KeyEvent e) {
		int source=e.getKeyCode();
		
		if(source == KeyEvent.VK_RIGHT)
		{
			right=true;
		}
		if(source == KeyEvent.VK_LEFT)
		{
			left=true;
		}
		if(source == KeyEvent.VK_UP)
		{
			up=true;
		}
		if(source == KeyEvent.VK_DOWN)
		{
			down=true;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int source=e.getKeyCode();
		
		if(source == KeyEvent.VK_RIGHT)
		{
			right=false;
		}
		if(source == KeyEvent.VK_LEFT)
		{
			left=false;
		}
		if(source == KeyEvent.VK_UP)
		{
			up=false;
		}
		if(source == KeyEvent.VK_DOWN)
		{
			down=false;
		}
	}

	public void keyTyped(KeyEvent arg0) {
		
		
	}
}
