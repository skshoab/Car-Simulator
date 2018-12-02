package Motor_Game_Setup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Motor_Game.Display;
import Motor_Game_Manger.GameManager;

public class GameSetup implements Runnable{
	private Thread thread;
	private Display display;
	
	private String title;
	private int width;
	private int height;
	
	private BufferStrategy buffer;
	private Graphics g;
	
	//private int y;
	private GameManager manager;
	
	public GameSetup(String t,int w,int h)
	{
		this.title=t;
		this.width=w;
		this.height=h;
	}
	
	public void init()
	{
		display=new Display(title,width,height);
		//y=0;
		manager=new GameManager();
		manager.init();
	}
	public synchronized void start()
	{
		if(thread == null)
		{
			thread=new Thread(this);
		}
		thread.start();
		
	}
	
	public synchronized void stop()
	{
		try {
			thread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void render()
	{
		buffer=display.canvas.getBufferStrategy();
		if(buffer == null)
		{
			display.canvas.createBufferStrategy(3);
			
			return;
		}
		g=buffer.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
//		g.setColor(Color.RED);
//		g.fillRect(12, y, 40, 40);
		
		manager.render(g);
		
		
		buffer.show();
		g.dispose();
		
	}

	
	public void run() {
		init();
		int fps=100;
		double timePerTick =1000000000/fps;
		double delta =0;
		long outLoopTime= System.nanoTime();
		
		while(true)
		{
			delta=delta+(System.nanoTime()-outLoopTime)/timePerTick;
			outLoopTime=System.nanoTime();
			
			if(delta>=1)
			{
				tick();
				render();
				delta--;
			}
			
			
		}
	}

	private void tick() {
		//y+=1;
		manager.tick();
		
	}
}
