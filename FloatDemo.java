
import java.lang.*;

public class FloatDemo {

   public static void main(String[] args) {
   double x = 24.801044;
   double y = 120.993085;
   System.out.println("Input: "+x+"; "+y);
   // Encode
   long data = (Math.round(x * 1e6) << 32) | Math.round(y * 1e6);
   System.out.println("Input: "+data);

   
   // Convert it to binary and print it
   System.out.println(Long.toBinaryString(data));
   //Decode function
   long foo = Long.parseLong(Long.toBinaryString(data), 2);
   System.out.println(foo);
   
   double resX = (foo >>> 32)/1e6;
   double resY = ((int)foo)/1e6;
   System.out.println("Input: "+resX+"; "+resY);
   
   }
} 
