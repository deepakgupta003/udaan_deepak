import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.URL;
import java.net.URLConnection;

class Udaan{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
URL url;
try {
			// get URL content
			url = new URL("https://newsapi.org/v2/top-headlines?apiKey=cd1db87dec794c2288c915ba6abeee94&country=in");
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			String fileName = "test.json";
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}
			bw.close();
			br.close();
			//System.out.println("Done");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Enter the Query:");
		String query=sc.nextLine();
		int l=query.length();
		
		
		 String fileName = "test.json";
        char line=' ';
		int count=0;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.read()!=0) {
				int s=0;
				for(int i=0;i<l;i++){
					if((char)bufferedReader.read()==fileName.charAt(i))
						continue;
					else
						s=i;
            }   
			if(s==l)
				count++;
        }
		}
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		System.out.println(count);
   
}
}
		
		
