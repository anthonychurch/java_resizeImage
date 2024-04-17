
public class StringUtilities {
	public static String checkForRE(String s){
		String rs = "";
		String[] re = {"Re:","RE:","re:","rE:"};
		for(int i = 0; i < re.length; i++){
			int last = s.lastIndexOf(re[i]);
			System.out.println("last = " + last);
			if(last != -1){
				break;
		
			}
		}
		return rs;
	}
}
