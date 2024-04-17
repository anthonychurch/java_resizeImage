import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ExecuteResizeImage {
	public static void main(String args[]) throws IOException{
		String fileExt = "jpg";
		//Var's to determine the min size of images
		int minWidth = Integer.parseInt(args[1]);//1000;
		int minHeight = Integer.parseInt(args[2]);//500;
		int division = Integer.parseInt(args[3]);//3;
		
		String prefix = "02_";
		String suffix = "";
		
		//Test to see if images are located in the specified folder
		//Exist program if none exist
		ListFolder folder = new ListFolder(args[0]);
		File[] list = folder.getContent();
		FileFilter fl = new FileFilter(fileExt,list);
		File[] newList = fl.filterList();
		//NEED TO REPLACE THIS WITH EXCEPTION**************************************
		if(newList[0] == null){
			System.out.println("main Class ERROR : Directory does not contain any " + fileExt + " files!");
			System.exit(0);
		}
		//RESIZE IMAGE:-
		//1.Get number of images that exist in folder
		//2.Get name of images
		//3.Get folder name
		//4.Get width and height of image
		//5.Get file extension
		//6.Save file
		int howManyImages = newList.length;
		System.out.println("main Class ADVICE : howManyImages = " + howManyImages + "!");
		for(int i = 0; i < howManyImages-1; i++){
			String imageFile = newList[i].toString();
			String imageNameExt = newList[i].getName().toString();
			int period = imageNameExt.lastIndexOf(".");  // 
			String imageName = imageNameExt.substring(0,period);
			String imagePath = newList[i].getParentFile().toString();
			Dimension imageSize = new GetImageSize(newList[i]).getSize();
			int newWidth = 0;
			int newHeight = 0;
			//Dimension imageSize 
			System.out.println("main Class ADVICE : imageFile = " + imageFile + "!");
			System.out.println("main Class ADVICE : imageSize = " + imageSize.getWidth() + "!");
			System.out.println("main Class ADVICE : imageName = " + imageName + "!");
			System.out.println("main Class ADVICE : imagePath = " + imagePath + "!");
			if((imageSize.getWidth()/division) <= minWidth | (imageSize.getHeight()/division) <= minWidth){
				if(imageSize.getWidth() <= minWidth | imageSize.getHeight() <= minWidth){
					newWidth = (int)imageSize.getWidth();
					newHeight = (int)imageSize.getHeight();
					System.out.println("main Class ADVICE : newWidth = " + newWidth + "!");
					System.out.println("main Class ADVICE : newHeight = " + newHeight + "!");
				}
				else{
					int newDivision = (int)imageSize.getHeight()/minHeight;
					newWidth = (int)imageSize.getWidth()/newDivision;
					newHeight = (int)imageSize.getHeight()/newDivision;
					System.out.println("main Class ADVICE : newWidth = " + newWidth + "!");
					System.out.println("main Class ADVICE : newHeight = " + newHeight + "!");
				}
			}
			else{
				newWidth = (int)imageSize.getWidth()/division;
				newHeight = (int)imageSize.getHeight()/division;
				System.out.println("main Class ADVICE : newWidth = " + newWidth + "!");
				System.out.println("main Class ADVICE : newHeight = " + newHeight + "!");
			}
			ImageIcon ic = new ResizeImage(imageFile, newWidth, newHeight).setResize();
			Image img = ic.getImage(); 
			RenderedImage rendered = null;
			if (img instanceof RenderedImage){  
				rendered = (RenderedImage)img;  
			}  
			else{  
				BufferedImage buffered = new BufferedImage(ic.getIconWidth(),ic.getIconHeight(),BufferedImage.TYPE_INT_RGB);  
				Graphics2D g = buffered.createGraphics();  
				g.drawImage(img, 0, 0, null);  
				g.dispose();  
				rendered = buffered;  
			}  
			suffix = "_" + newWidth + "x" + newHeight;
			//prefix = "02_";
			System.out.println("main Class ADVICE : suffix = " + suffix + "!");
			String nf = imagePath + "\\" + prefix + imageName + suffix + "." + fileExt;
			System.out.println("main Class ADVICE : nf = " + nf + "!");
			ImageIO.write(rendered, "JPEG", new File(nf));
		}
		
	}
}

