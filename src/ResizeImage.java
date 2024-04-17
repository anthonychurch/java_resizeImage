//import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.Image;


public class ResizeImage {
	private String fname;
	private int width;
	private int height;
	
	public ResizeImage(String name, int width, int height){
		this.fname = name;
		this.width = width;
		this.height = height;
	}
	
	public ImageIcon setResize(){
		ImageIcon icon = new ImageIcon(fname);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);  
		ImageIcon newIcon = new ImageIcon(newImg);  
		//BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		//Graphics g = bi.createGraphics();
		//g.drawImage(img, 140, 199, imageW, imageH, null, null);
		return newIcon;
	}
}
