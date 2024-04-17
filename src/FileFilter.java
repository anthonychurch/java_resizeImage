import java.io.File;

public class FileFilter {
	private String ext;
	private File[] list;
	private File[] newList;
		
	public FileFilter(String ext, File[] list ){
		this.list = list;
		this.ext = ext;
	}
		
	public File[] filterList(){
		newList = new File[list.length];
		int i = 0;
		int j = 0;
		String file = "";
		String format = "";
		boolean testExt = false;
		if(list.length > 0){
			for (File f : list){
				if(f.isDirectory() == false){
					file = f.getName();
					int mid= file.lastIndexOf(".");
					format = file.substring(mid+1,file.length());
					//System.out.println("ext = " + ext);
					//System.out.println("format = " + format);
					testExt = format.equalsIgnoreCase(ext);
					//NOT SURE IF THE IF COMPARE CONDITION IS WORKING!!!!!*********
					if( testExt == true ){
						newList[j] = f;
						System.out.println("FileFilter Class ADVICE : " + newList[j].getName() + " : format match!");
						//System.out.println(newList[j].getName());
						j++;
					}
				}
				i++;
			}
			
		}
		//NEED TO REPLACE THIS WITH EXCEPTION**************************************
		if(newList[0] == null){
			System.out.println("FileFilter Class ERROR : Directory does not contain any " + ext + " files!");
		}
		return newList;
	}
}
