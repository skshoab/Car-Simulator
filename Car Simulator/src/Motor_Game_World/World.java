package Motor_Game_World;

import java.awt.Graphics;
import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Game_Motor.Motor;
import Motor_Game.Display;
import Motor_Game_Tile.Tile;

public class World {
	
	private int [][] tile;
	private int width,height;
	private Motor motor;
	public World(Motor motor)
	{
		loadWorld("res/war.txt");
		this.motor=motor;
	}
	
	private int parseInt(String Number)
	{
		return Integer.parseInt(Number);
	}
	private void loadWorld(String path)
	{
		String file=loadFile(path);
		String[] space = file.split("\\s+");
		width=parseInt(space[0]);
		height=parseInt(space[1]);
		tile =new int[width][height];
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				tile[x][y]= parseInt( space[2+(x+y *width)]);
			}
		}
	}
	public String loadFile(String path)
	{
		StringBuilder sr =new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line = reader.readLine()) != null){
				sr.append(line+"\n");
			}
			reader.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return sr.toString();
	}
	public void render(Graphics g)
	{
		int start=Math.max(0, (motor.getOfset())/Tile.tileHeight);
		int end=Math.min(height, (motor.getOfset()+Display.height+20)/Tile.tileHeight);		
		for(int i=0;i<width;i++){
			for(int j=start;j<end;j++){
				Tile t=Tile.tile[tile[i][j]];
				t.render(g, i*Tile.tileWidth, (j*Tile.tileHeight)-motor.getOfset());
			}
		}
	}
}
