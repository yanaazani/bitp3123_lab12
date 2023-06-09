package exercise6;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
 * This program is to demonstrate the I/O process for Daily RainfaLL Data
 * The data is written in its original type into the stream.
 * 
 * Author: shaufy yana
 * 
 */
public class DailyRainfallGenerator {

	public void main(String[] args){
		
		
		//1.Determine the target storage for the output.
		String outFile="dailyRainfallData1.txt";
		
		//Data Declaration for two stations in each district in Melaka from 3/6/2023 until 8/6/2023
		int stationId[]= {2421003,2322006,2324033, 2225044, 2223023, 2222006};
		String station[] = {"Simpang Ampat", "Melaka Pindah", "Hospital Jasin", "Chohong","Sg. Duyong", "Cheng"};
		String districtName[]={"Alor Gajah", "Jasin", "Melaka Tengah"};
		double dailyRainfallDataSimpangAmpat[] = {4.0,	1.0, 0.0, 6.0, 19.0, 1.0};
		double dailyRainfallDataMelakaPindah[] = {0.0, 0.0,	0.0, 2.0, 18.5,	2.5};
		double dailyRainfallDataHospitalJasin[] = {0.0, 14.0, 0.0, 11.0, 15.0, 31.0};
		double dailyRainfallDataChohong[] = {0.0, 21.5, 0.0,	39.0, 14.5,	24.5};
		double dailyRainfallDataSgDuyong[] = {0.0,	3.0, 0.0, 43.0,	26.0, 26.0};	
		double dailyRainfallMelakaTengah[] = {0.0,	3.5, 0.0, 42.5,	10.0, 14.5};	
				
		try {
			
			//2.Construct object for the output stream
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
		
			System.out.println("----------------------------------------------------");
			System.out.println("Station Id \t Station \t District \t Daily Rainfall");
			System.out.println("----------------------------------------------------");
			
			//3.Write the data into the output stream.
			for(int index =0; index<districtName.length; index++) {
				dos.writeInt(stationId[index]);
				dos.writeUTF(station[index]);
				dos.writeUTF(districtName[index]);
				dos.writeDouble(dailyRainfallDataSimpangAmpat[index]);
				dos.writeDouble(dailyRainfallDataMelakaPindah[index]);
				dos.writeDouble(dailyRainfallDataHospitalJasin[index]);
				dos.writeDouble(dailyRainfallDataChohong[index]);
				dos.writeDouble(dailyRainfallDataSgDuyong[index]);
				dos.writeDouble(dailyRainfallMelakaTengah[index]);
				

				//4. Flush the output stream.
				dos.flush();
			}
	
			//5.Close the output stream.
			dos.close();
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		System.out.println("End of program. Check " + outFile);
		
		
		
		
	}
	
}
