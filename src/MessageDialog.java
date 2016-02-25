/**
 * @Class: MessageDialog
 * @Description:  pop-up a message
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MessageDialog extends JFrame
{
  public MessageDialog(String message, String title)
  {
	  JOptionPane.showMessageDialog(this, message 
              ,title, JOptionPane.PLAIN_MESSAGE);
  }
}
