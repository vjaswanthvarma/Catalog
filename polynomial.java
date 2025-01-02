/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.nio.file.*;
import java.io.IOException;
public class Main
{
	public static void main(String[] args) {
	     String filePath = "input.json";
	     try{
	     String jsonString = Files.readString(Paths.get(filePath));
	     String keysSection = jsonString.substring(jsonString.indexOf("\"keys\":") + 7, jsonString.indexOf("},") + 1);
	     int k = Integer.parseInt(keysSection.split("\"k\":")[1].trim().replace("}", "").trim());
	       String[] entries = jsonString.substring(jsonString.indexOf("\"1\":")).split("\\},");
	        int[][] roots = new int[k][2];
            int index = 0;
             for (String entry : entries) {
                if (entry.contains("base")) {
                    String[] parts = entry.split(":");
                    int x = Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
                      String base = entry.substring(entry.indexOf("\"base\":") + 7, entry.indexOf(",", entry.indexOf("\"base\":")));
                     String value = entry.substring(entry.indexOf("\"value\":") + 8);
                      base = base.trim().replace("\"", "");
                     value= value.trim().replace("\"", "");
                     int base = Integer.parseInt(basePart);

            // Convert the value to a BigInteger in the specified base
            BigInteger Y = new BigInteger(valuePart, base);
                     roots[index++] = new int[]{x,y };
                     if (index >= k) break;
                }
            }
	         
	     }
	    catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        if (index >= k) break;
         int constantTerm = calculateConstantTerm(roots);
        System.out.println("c = " + constantTerm);
        
        
	}
	private static int calculateConstantTerm(int[][] roots) {
        double c = 0;

        for (int i = 0; i < roots.length; i++) {
            double term = roots[i][1];
            for (int j = 0; j < roots.length; j++) {
                if (i != j) {
                    term *= (double) (-roots[j][0]) / (roots[i][0] - roots[j][0]);
                }
            }
            c += term;
        }

        return (int) Math.round(c);
    }
	
	}
