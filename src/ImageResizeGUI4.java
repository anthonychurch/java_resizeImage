import javax.swing.* ;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.io.File;
import java.io.IOException;
import javax.jnlp.*;

import java.awt.* ;
import java.awt.event.* ;

public class ImageResizeGUI4 {
	FileOpenService fos = null;
	static final String scaleList[] = {"10", "25", "30", "50", "75", "100"};
	//Method to create GUI
	private void createGUI(){
		int componentGap = 12;
		//Set the default look of a JFrame's components to be decorated to match OS
		JFrame.setDefaultLookAndFeelDecorated(true) ;
		//Create and set up the frame
		JFrame frame = new JFrame("Resize Image") ;
		//Display the frame
		frame.setSize(320,380) ;
		//Close application when close button clicked
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		//Create instances of Grid Layouts and set their Vgap and Hgap between components
		GridLayout gridLayoutBase = new GridLayout(1,1);
		gridLayoutBase.setHgap(componentGap);
		gridLayoutBase.setVgap(componentGap);
		
		GridLayout gridLayoutBorder = new GridLayout(2,1);
		gridLayoutBorder.setHgap(componentGap);
		gridLayoutBorder.setVgap(componentGap);
		
		GridLayout gridLayoutRow2 = new GridLayout(5,2);
		gridLayoutRow2.setHgap(componentGap);
		gridLayoutRow2.setVgap(componentGap);
		
		GridLayout gridLayoutRow3 = new GridLayout(2,2);
		gridLayoutRow3.setHgap(componentGap);
		gridLayoutRow3.setVgap(componentGap);
		
		//Setup borders
		Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		TitledBorder titled = BorderFactory.createTitledBorder(blackLine,"Resize Image");
		//Setup pane's
		JPanel paneBase = new JPanel(gridLayoutBase) ;
		JPanel paneOuterBorder = new JPanel(gridLayoutBase) ;
		JPanel paneInnerBorder = new JPanel(gridLayoutBorder) ;
		paneBase.setBorder(paneEdge);
		paneOuterBorder.setBorder(titled);
		paneInnerBorder.setBorder(paneEdge);
		JPanel paneRow2 = new JPanel(gridLayoutRow2) ;
		JPanel paneRow3 = new JPanel(gridLayoutRow3) ;
		

		
		//Setup paneBase
		//JLabel title1_1_1 = new JLabel("Resize Image");
		JLabel title2_1_1 = new JLabel("Scale Image: ");
		JComboBox scale2_1_2 = new JComboBox(scaleList);
		JLabel blank2_2_1 = new JLabel("   ");
		JLabel blank2_2_2 = new JLabel("   ");
		JLabel prefix2_3_1 = new JLabel("Prefix: ");
		JTextField prefix2_3_2 = new JTextField();
		JLabel suffix2_4_1 = new JLabel("Suffix: ");
		final JTextField suffix2_4_2 = new JTextField();
		JLabel folder2_5_1 = new JLabel("Folder: ");
		JTextField folder2_5_2 = new JTextField();
	
		JLabel blank3_1_1 = new JLabel("   ");
		JButton resize3_1_2 = new JButton("Resize");
		resize3_1_2.setSize(new Dimension(50,20));
		resize3_1_2.requestFocus() ;
		JLabel blank3_2_1 = new JLabel("   ");
		JLabel blank3_2_2 = new JLabel("   ");
		
		paneRow2.add(title2_1_1);
		paneRow2.add(scale2_1_2);
		paneRow2.add(blank2_2_1);
		paneRow2.add(blank2_2_2);
		paneRow2.add(prefix2_3_1);
		paneRow2.add(prefix2_3_2);
		paneRow2.add(suffix2_4_1);
		paneRow2.add(suffix2_4_2);
		paneRow2.add(folder2_5_1);
		paneRow2.add(folder2_5_2);
		
		paneRow3.add(blank3_1_1);
		paneRow3.add(resize3_1_2);
		paneRow3.add(blank3_2_1);
		paneRow3.add(blank3_2_2);
					
		//paneBase.add(title1_1_1);
		paneBase.add(paneOuterBorder);
		paneOuterBorder.add(paneInnerBorder);
		paneInnerBorder.add(paneRow2);
		paneInnerBorder.add(paneRow3);
		
		 //Process the Apply gaps button press
		resize3_1_2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	String txt_suffix2_4_2 = suffix2_4_2.getText();
            	System.out.println("FileChooserGetFilesDir :: Info :: suffix2_4_2 = " + txt_suffix2_4_2 + "\n");
            	
            	final FileChooserGetFilesDir p = new FileChooserGetFilesDir();
            	final File[] r = p.OpenFile();
            	int increment = 0;
        		if(r.length > 0){
        			for(int i = 0;i < r.length;i++){
        				System.out.println("r[" + increment + "] = " + r[i]);
        				increment = increment + 1;
        			}
        		}else{System.out.println("FileChooserGetFilesDir :: Warning :: No Files or Directories Selected!!!!!!\n");}
            	
            }
        });
		//Add JPanel to the JFrame
		frame.add(paneBase, BorderLayout.CENTER) ;
		//frame.pack();
		frame.setVisible(true) ;
	}
	
	public static void main(String[] args){
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				//Create an instance of the BasicSwing class
				//and call the creatGUI method
				ImageResizeGUI4 app = new ImageResizeGUI4() ;
				app.createGUI() ;
			}
		});
	}
	
}
