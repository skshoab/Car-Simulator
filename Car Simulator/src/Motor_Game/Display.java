package Motor_Game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private String title;
	public static int width;
	public static int height;
	public static JFrame frame;
	public static Canvas canvas;
	public Display(String t,int w,int h)
	{
		this.title=t;
		this.width=w;
		this.height=h;
		createDisplay();
	}
	public void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.pack();
		
	}
}
