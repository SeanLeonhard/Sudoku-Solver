import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SButton extends JButton
{
   private boolean status;
   
   public SButton(String title)
   {
      super(title);
      status = false;
      this.setBackground(Color.WHITE);
      this.setPreferredSize(new Dimension(60, 30));
      this.setForeground(Color.BLACK);
   }
   
}
