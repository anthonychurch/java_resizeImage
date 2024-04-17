import java.io.*;

public class ListFolder {
	//Variables
	private String fname;
	//constructor
	public ListFolder(String name){
		this.fname = name;
	}
	//Get Method
	public File[] getContent(){
		File dir = new File(fname);
		File[] chld = dir.listFiles();
		if(chld == null){
			System.out.println("Specified directory does not exist or is not a directory.");
			System.exit(0);
		}
		return chld;
	}
}
