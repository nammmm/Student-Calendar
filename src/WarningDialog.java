/**
 * @Class: WarningDialog
 * @Description:  pop-up to warn user
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WarningDialog extends JFrame
{
    public WarningDialog(String str)
    {
        JOptionPane.showMessageDialog(this,str, "Warning",JOptionPane.WARNING_MESSAGE);
    }
}

