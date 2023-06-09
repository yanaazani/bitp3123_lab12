package exercise7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ByteBaseReader {

	public static void main (String [] args)
	{
		// 1. Declare output file 
		String sourceFile = "RainfallCharBased.txt";
				
		// display the sentence for reading data
		System.out.println("Reading data from " + sourceFile + "\n");
		try {
			BufferedReader bufferInput = new BufferedReader(new FileReader(sourceFile));
			String dailyRainfallData = "";
			int noOfRecords = 0;
			double totalRainfallData = 0.0;
			
			dailyRainfallData = bufferInput.readLine();
			while (dailyRainfallData != null) {
				
				System.out.println(dailyRainfallData);
				
				// Calculate total data of rainfall
				totalRainfallData = totalRainfallData + Double.parseDouble(dailyRainfallData);
				
				noOfRecords ++;

				dailyRainfallData = bufferInput.readLine();
				double averageRainfall = totalRainfallData / Double.valueOf(noOfRecords);

				String formattedAverage = String.format("%.1f", averageRainfall);
				System.out.print("\nAverage rainfall for " + noOfRecords 
						+ " days from station Simpang Ampat in Alor Gajah district: " + formattedAverage);
							
				// 4. Close the Reader
				bufferInput.close();
			}
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
