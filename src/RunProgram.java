import java.awt.EventQueue;

import javax.swing.UIManager;
/**
 * Student Calendar
 * @author: Nan Jiang
 * @version: v1.0
 * @date: 2013-02-20
 */
public class RunProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Initialization frame = new Initialization();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

}
