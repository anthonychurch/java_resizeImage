import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class TESTFileChooserGetFilesDir extends JFrame {

	public File[] OpenFile() {

		File[] returnArray = new File[0];
		final JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setMultiSelectionEnabled(true);
		chooser.setAcceptAllFileFilterUsed(true);

		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
			final File[] getFiles = chooser.getSelectedFiles();
			returnArray = getFiles;
		}
		return returnArray;
	}

	public static void main(final String[] args) {
		final TESTFileChooserGetFilesDir p = new TESTFileChooserGetFilesDir();
		final File[] r = p.OpenFile();
		int increment = 0;
		if(r.length > 0){
			for(int i = 0;i < r.length;i++){
				System.out.println("r[" + increment + "] = " + r[i]);
				increment = increment + 1;
			}
		}else{System.out.println("FileChooserGetFilesDir WARNING :: No Files or Directories Selected!!!!!!\n");}
	}
} ///:~