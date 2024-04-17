import java.io.File;


public class ConvertToString {
	private File in;
	private String out;
	
	public ConvertToString(File in){
		this.in = in;
	}
	
	public String Convert(){
		out = in.toString();
		return out;
	}
	
}
