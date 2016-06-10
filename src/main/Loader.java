package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {

	@SuppressWarnings("unchecked")
	public static final void readF1(String filePath) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(  
                new FileInputStream(filePath)));  
  
        for (String line = br.readLine(); line != null; line = br.readLine()) {  
            //System.out.println(line);  
        	String[] str = line.split("\t");
            Container.rawData.add(str);
            
            if (str[3].contains("玉")) {
            	Container.jade.add(str);
            } else if (str[3].contains("金")) {
            	Container.gold.add(str);
            } else if (str[3].contains("银")) {
            	Container.silver.add(str);
            } else {
            	Container.iron.add(str);
            	if (str[2].contains("中立")) {
            		Container.ironNeutral.add(str);
            	}
            }
            
        }  
        br.close();  
  
    }  
  
    public static final void readF2(String filePath) throws IOException {  
        FileReader fr = new FileReader(filePath);  
        BufferedReader bufferedreader = new BufferedReader(fr);  
        String instring;  
        while ((instring = bufferedreader.readLine().trim()) != null) {  
            if (0 != instring.length()) {  
                System.out.println(instring);  
            }  
        }  
        fr.close();  
    }
    
    public static void loadRawData() {
    	try {
			Loader.readF1("src/data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }	

	
	
}
