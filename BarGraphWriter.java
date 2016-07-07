import javax.swing.*;
import java.awt.*;
/**Creates a bargraph*/
public class BarGraphWriter extends JPanel
{
   private double[] amounts;
   private String[] labels;
   private Color[] colors;
   private int x_position;
   private int y_position;
   private int x_length;
   private int y_height; 
   private int height;
   private int width; 
   private int count = 0;
   private String top_label;
   private int n = 1;
   private int p = 0;
   private JFrame frame;
   
   /**Creates the frame and inserts the panel to the created frame*/
   public BarGraphWriter(int x_pos,int y_pos, int x_width, int y_up, String t_label)
   {
      x_position = x_pos;
      y_position = y_pos;
      x_length = x_width;
      y_height = y_up;
      top_label = t_label;
      width = x_length + 100;
      height = y_height + 100;
      frame = new JFrame();
      frame.getContentPane().add(this);
      frame.setSize(width, height);
      frame.setVisible(true);
   }
   /**Paints the panel by drawing the bargraph*/
   public void paintComponent(Graphics g)
   {  if(p>0){
      g.setColor(Color.white);
      g.fillRect(0,0,width,height);
      double max_Amount = 0;//Maximum amount given by the user
      for(int i=0; i < amounts.length; i++)
      if (max_Amount < amounts[i])
          max_Amount = amounts[i];
      
      int barWidth = x_length / (n);
      //Each of the bar's height is multiplied by scale
      double scale = y_height / max_Amount;
      g.setColor(Color.black);
      g.drawLine(x_position, y_position + 20, x_position + x_length + 7, y_position + 20 );
      g.drawLine(x_position, y_position-y_height + 20, x_position, y_position + 20);
      g.drawString("0",x_position - 9, y_position + 9 + 20);
      g.drawString(top_label, 7, y_position - y_height + 8);
      //Draws the bars of the bargraph
      for (int i = 0; i < n; i++) {
      int x = i * barWidth + x_position + 3;
      int y = (y_position - y_height + 20) + (int) ((max_Amount - amounts[i]) * scale);
      int height = (int) (amounts[i] * scale);
         
      g.setColor(colors[i]);
      g.fillRect(x, y, barWidth - 5, height);
      g.setColor(Color.black);
      g.drawRect(x, y, barWidth - 5, height);
      String s = amounts[i] + "";
      g.drawString(s,7, y );
      int pos =  x + (barWidth/2); 
      g.drawString(labels[i],x,y_position + 13 + 20);
    }
    }
    
   }
   
   /**Fill the arrays needed to draw the bargraph*/
   public void setBar(String label, int height, Color c)
   {
      labels[count] = label;
      amounts[count] = height;
      colors[count] = c;
      count++;
   }
   //Initializes the arrays;
   public void starter(int num)
   {
      n = num;
      amounts = new double[n];
      labels = new String[n];
      colors = new Color[n];   
   }
   //Repaints paintComponent method
   public void changer()
   {
      p = 1;
      this.repaint();
   }
   
   
   
}