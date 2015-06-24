import java.lang.*;
import java.util.Scanner;

public class Location {
  
   public static void main(String[] args) {
    
       Scanner in = new Scanner(System.in);
       System.out.println("Enter latitude:");
       double x = in.nextFloat();
       
       System.out.println("Enter longitude:");
       double y = in.nextFloat();
       
       //Calling the encoding function
       String encoded = encode(x,y);
       System.out.println("Encoded location:"+encoded);
       
       //Calling the decoding functio
       System.out.println("Decoded:"+decode(encoded));    
   }
   
   //ENCODING FUNCTION
   public static String encode(double latitude, double longitude){
       double x = latitude;
       double y = longitude;
       
       System.out.println("Input coordinates: "+x+"; "+y);
        // Encoding into a long integer
       long data = (Math.round(x * 1e6) << 32) | Math.round(y * 1e6);
       // Converting long integer to binary string
       String binaryLocation = Long.toBinaryString(data);
       System.out.println("Length of location in binary:" + binaryLocation.length());
       return binaryLocation;
   }
   
   //DECODING FUNCTION
   public static String decode(String message){
       String binaryMess= message;
       //Parsing the message into a long string again
       long decodedCoord = Long.parseLong(binaryMess, 2);
       //Finding latitude and longitude
       double latitude = (decodedCoord >>> 32)/1e6;
       double longitude= ((int)decodedCoord)/1e6;
       //Making a final string out of both of them
       String Coordinates = String.valueOf(latitude) + " " + String.valueOf(longitude);
       return Coordinates;
   }
} 