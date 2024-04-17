import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Dimension;

public class GetImageSize{
	private File f;
	private Dimension d = null;

	public GetImageSize(File f){
		this.f = f;
	}
	
	public Dimension getSize(){
		try {
			BufferedImage bi = ImageIO.read(f);
			int height = bi.getHeight();
			int width = bi.getWidth();
			d = new Dimension(width,height);
			//return d;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
		
	}
	
}
