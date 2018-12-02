package Motor_Game_Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadImage {
	public static BufferedImage img,imgMotor,imgPlayer,imgEnemy,roadImage,grassImage,pathImage; 
	
	public static void init()
	{
		img=imageLoader("/grid.png");
		imgMotor=imageLoader("/motor.jpg");
		crop();
	}
	public static BufferedImage imageLoader(String path)
	{
		try {
			return ImageIO.read(LoadImage.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	public static void crop()
	{
//		subImage1=img.getSubimage(10, 40,50,50);
//		subImage2=img.getSubimage(150,20,50,50);
		
		roadImage=img.getSubimage(130, 0, 131, 119);
		pathImage=img.getSubimage(262, 0, 131, 119);
		grassImage=img.getSubimage(0,0,130,119);
		
		imgPlayer=imgMotor.getSubimage(10, 25, 230, 430);
		imgEnemy=imgMotor.getSubimage(255,5, 225, 430);
		
	}
}
