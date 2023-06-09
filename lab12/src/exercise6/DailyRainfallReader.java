package exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class DailyRainfallReader {
	public static void main(String[] args)
	{
		//1. Declare output file
		String sourceFile = "dailyRainfallData1.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try {
			//2. Create Stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));
			
			
			//Variables 
			double dailyRainfallDataSimpangAmpat = 0,dailyRainfallDataMelakaPindah = 0, dailyRainfallDataHospitalJasin = 0, dailyRainfallDataChohong=0, dailyRainfallDataSgDuyong =0, dailyRainfallMelakaTengah = 0;
			double totalData = 0; 
			int noOfRecords =0, stationId=0;
			String station = "", districtName="";
			
			
			
			// Declaration of Arraylist to store the each total daily rainfall readings
			ArrayList <Double> totalRainfall = new ArrayList<Double>();
			// ArrayList to store stations for calculation purpose
			ArrayList<String> stations = new ArrayList<String>();
			// HashSet to store distinct district for calculation purpose
			HashSet<String> districtCount = new HashSet<String>();			

			
			while(dis.available() > 0)
			{
				//Read Data
				stationId = dis.readInt();
				station = dis.readUTF();
				districtName = dis.readUTF();
				dailyRainfallDataSimpangAmpat = dis.readDouble();
				dailyRainfallDataMelakaPindah = dis.readDouble();
				dailyRainfallDataHospitalJasin = dis.readDouble();
				dailyRainfallDataChohong = dis.readDouble();
				dailyRainfallDataSgDuyong = dis.readDouble();
				dailyRainfallMelakaTengah = dis.readDouble();
	
				
				System.out.println( stationId + "\t" + station + "\t" + districtName
						+ "\t" + dailyRainfallDataSimpangAmpat + "\t" + dailyRainfallDataMelakaPindah + "\t" + dailyRainfallDataHospitalJasin 
						+ "\t" + dailyRainfallDataChohong + "\t" + dailyRainfallDataSgDuyong + "\t" + dailyRainfallMelakaTengah );
				//Compute the total data of those 6 days
				totalData =  dailyRainfallDataSimpangAmpat + dailyRainfallDataMelakaPindah + dailyRainfallDataHospitalJasin + dailyRainfallDataChohong
						+ dailyRainfallDataSgDuyong + dailyRainfallDataChohong;
			
				totalRainfall.add(totalData);
				stations.add(station);
				districtCount.add(districtName);
				
				noOfRecords ++;
			}
			
			for(int index = 0; index < stations.size(); index++)
			{
				// Calculation for average daily rainfall data
				double aveData = totalRainfall.get(index) / noOfRecords;
				String formattedAverage = String.format("%.1f", aveData);
				
				// display the total daily rainfall data
				System.out.println("The total daily rainfall readings in " + stations.get(index) + " : " 
						+ totalRainfall.get(index) );
				System.out.println("The average daily rainfall readings in " + stations.get(index) + " : " 
						+ formattedAverage + "\n");
			}
			//4. Close stream
			dis.close();
			
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		System.out.println("\n End of the program.");
	}
}
