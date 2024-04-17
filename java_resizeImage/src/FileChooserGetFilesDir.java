import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooserGetFilesDir extends JFrame {

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
		else{System.out.println("FileChooserGetFilesDir WARNING :: No Files or Directories Selected!!!!!!\n");}
		
		return returnArray;
	}

} ///:~