import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               while (true)
	               {
	            	   direction = carQueue.deleteQueue();
	                   if (direction == 0)       y -= 10; 
	                   else if (direction == 1)  y += 10; 
	                   else if (direction == 2)  x += 10; 
	                   else if (direction == 3)  x -= 10; 
	                   
	                   if (x < 0) x = 0;
	                   if (y < 0) y = 0;
	                   if (x > getWidth() - 50) x = getWidth() - 50;
	                   if (y > getHeight() - 50) y = getHeight() - 50;
	                   
	            	   repaint();
	            	   Thread.sleep(delay*1000);
	            	   
	               }
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}