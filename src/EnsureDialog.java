/**
 * @Class: EnsureDialog
 * @Description:  pop-up to let user confirm an action
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EnsureDialog extends JFrame
{
    private int n;
    public EnsureDialog(String s)
    {     
        n = JOptionPane.showConfirmDialog(this,s,"Confirmation", JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION)
        {	
        }
        else if(n==JOptionPane.NO_OPTION)
        {	
        }
    }
    public int getN()
    {
        return n;
    }
}

