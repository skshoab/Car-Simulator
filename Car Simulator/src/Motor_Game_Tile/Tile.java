package Motor_Game_Tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	public BufferedImage texture;
	public static Tile[]tile=new Tile[24];
	public static  final int tileWidth=64,tileHeight=64;
	
	public static  Tile RoadTile=new RoadTile(0);
	public static  Tile grassTile=new GrassTIle(1);
	public static  Tile pathTile=new PathTile(2);
	
	public Tile(BufferedImage texture,int id)
	{
		this.texture=texture;
		tile[id]=this;
	}
	public void render(Graphics g,int x,int y)
	{
		g.drawImage(texture, x, y, null);
		
	}
}
