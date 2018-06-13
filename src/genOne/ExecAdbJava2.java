package genOne;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecAdbJava2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String command="adb shell pm list packages |grep \"chrome\"";
		
		StringBuffer output = new StringBuffer();
		 
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String response = output.toString();
        System.out.println(response);

	}

}
