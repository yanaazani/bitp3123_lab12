package exercise5;
import java.io.DataOutputStream;
import java.io.FileOutputStream;


/*	A set of data to represent 6 days reading of daily rainfall
 * from station Simpang Ampat in Alor Gajah district.
 * 
 * 
 * 
 * Author: Shaufy Yana Ezani
 * 
 */

public class DailyRainfallDataGenerator {
	public static void main(String[] args)
	{
		//1 Determine the target storage for the output
				String outFile = "dailyRainfallData.txt";
				
		//Sample of Data
		String station[]= {"Simpang Ampat", "Melaka Pindah", "Ladang Lendu", " Durian Tunggal"
				,"Durian Tunggal D/S", "Empangan Durian Tunggal", "Sg. Melaka Di Pantai Belimbing"};
		double day1[]= {4.0, 0.0, 2.0, 0.0, 0.0, 0.0, 0.0};
		double day2[]= {1.0, 0.0, 0.0, 0.0, 0.0, 3.5, 1.0};
		double day3[]= {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		double day4[]= {6.0, 2.0, 3.0, 37.0, 46.0, 8.0, 12.0};
		double day5[]= {19.0, 18.5, 4.0, 6.0, 7.0, 6.0, 6.5};
		double day6[]= {1.0, 2.5, 0.0, 9.0, 9.0, 4.0, 5.0};
	
		try {
			
			//2. Construct object for output stream
			
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
			
			
			for(int index=0; index<station.length; index++) {
			
				//3. Write data into data output stream
				dos.writeUTF(station[index]);
				dos.writeDouble(day1[index]);
				dos.writeDouble(day2[index]);
				dos.writeDouble(day3[index]);
				dos.writeDouble(day4[index]);
				dos.writeDouble(day5[index]);
				dos.writeDouble(day6[index]);
				
				//4. Flush the output stream
				dos.flush();
			}
			
			//5. Close output stream
			dos.close();	
					
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
		//Show the end of the program 
		System.out.println("End of the program. Check out "+ outFile);
	}
}
