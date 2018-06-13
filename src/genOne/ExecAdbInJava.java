package genOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecAdbInJava {
 
	public static void main(String[] args) throws IOException, InterruptedException{
		String line;
		Runtime rt=Runtime.getRuntime();
		Process pr=rt.exec("adb shell pm list packages |grep \"chrome\"");
		pr.waitFor();
		
		BufferedReader buf=new BufferedReader(new InputStreamReader(pr.getInputStream()));
		while((line=buf.readLine())!=null){
			System.out.println(line);
			if(line.contains("chrome")){
				System.out.println("Chrome is installed : \n package is "+line);
			}
			
		}
		
	}

}
