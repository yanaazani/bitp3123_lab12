package exercise5;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class DailyRainfallDataReader {

	public static void main(String[] args)
	{
		//1. Declare output file
		String sourceFile = "dailyRainfallData.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try {
			//2. Create Stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));
			
			
			//Variables 
			double day1 = 0; //, day2 = 0, day3 = 0, day4 = 0, day5 = 0, day6 = 0;
			double totalData = 0; 
			int noOfRecords =0;
			String station = "";

			
			while(dis.available() > 0)
			{
				//Read Data
				station = dis.readUTF();
				day1 = dis.readDouble();
				System.out.println(station+"\t"+day1);
				
				//Compute the total data of those 6 days
				totalData += day1; 
				noOfRecords ++;
				
			}
			
			//4. Close stream
			dis.close();
			
			//Compute Average
			double aveData = totalData / noOfRecords;
			String formattedAverage = String.format("%.1f", aveData);
			System.out.println("Average daily rainfall data for day 1 "+noOfRecords+" station: "+formattedAverage+ "%");
			
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		System.out.println("\n End of the program.");
		
		
		
		
	}
}
