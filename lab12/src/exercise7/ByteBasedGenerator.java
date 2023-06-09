package exercise7;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ByteBasedGenerator {

	public static void main (String [] args)
	{
		//1.Determine the target storage for the output.
		String outFile = "RainfallByteBased.txt";
		
		try
		{
			FileWriter files = new FileWriter(outFile);
			BufferedWriter bufferOuput = new BufferedWriter(files);
			
			double day1[]= {4.0, 0.0, 2.0, 0.0, 0.0, 0.0, 0.0};
			
			for(int index=0; index<day1.length; index++) {
				
				//3. Write data into data output stream
				bufferOuput.write(String.valueOf(day1[index]));
				bufferOuput.newLine();
				
			}
			// 4. Clear the stream
			bufferOuput.flush(); 
			
			// 5. Close the stream
			bufferOuput.close();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
	}
}
