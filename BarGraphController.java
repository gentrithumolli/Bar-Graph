import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
public class BarGraphController
{  
   public static void main(String[] args)
   {  
      int n = new Integer(JOptionPane.showInputDialog("Write the number of bars you want to create:")).intValue();
      String title = JOptionPane.showInputDialog("Write the y-axis label");
      JOptionPane.showMessageDialog(null,"NOTE: You must write your item first then the representing value of that item seperated by comma, then the color\nEXAMPLE:  \"Item1,20,green\"");
      BarGraphWriter obj = new BarGraphWriter(40, 420, 300, 400, title);
      obj.starter(n);
      for(int i=0; i<n; i++)
       {
         String input = JOptionPane.showInputDialog("Write the data for the " + (i+1) + " bar");
         /*Creates and array of three values(label, amount and color), by separating the input taken 
           from the dialog created by the line above, using comma as a reference 
           and removing the space after the comma.*/
         String[] Array = input.split(",[ ]*");
         String label = Array[0];
         int amount = new Integer(Array[1]).intValue();
         String c = Array[2];
         Color color = BarGraphController.stringToColor(c);
         obj.setBar(label,amount,color);
       }
       obj.changer();
   }
   
   public static Color stringToColor(final String value) {
    if (value == null) {
      return Color.black;
    }
     {
      
      try {
        
        final Field f = Color.class.getField(value);

        return (Color) f.get(null);
      } catch (Exception ce) {
        
        return Color.black;
      }
    }
  }

   
   
   
   
   
   
   
   
   
   
     
}