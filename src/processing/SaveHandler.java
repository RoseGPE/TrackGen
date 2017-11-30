package processing;

import java.awt.geom.CubicCurve2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

public class SaveHandler {

	public static ArrayList<CubicCurve2D> loadTrackDataFromFile(File file) {
		ArrayList<CubicCurve2D> trackData = new ArrayList<CubicCurve2D>();
		
		try{
			FileInputStream fStream = new FileInputStream(file);
			ZipInputStream zStream = new ZipInputStream(fStream);
			
			zStream.getNextEntry();
			Scanner input = new Scanner(zStream);
			while(input.hasNext()){
				double[] nextCurve = new double[8];
				for(int i=0;i<8;i++){
					nextCurve[i] = input.nextDouble();
				}
				trackData.add(curveFromDoubles(nextCurve));
			}
			
			//CLOSING FILE STUFF
			zStream.close();
			fStream.close();
		} catch (ZipException e){
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

		return trackData;
	}
	
	public static CubicCurve2D curveFromDoubles(double[] points){
		return new CubicCurve2D.Double(points[0],points[1],points[2],points[3],points[4],points[5],points[6],points[7]);
	}
}
;