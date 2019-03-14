package Pong;
import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Tennis extends Applet implements Runnable, KeyListener{
	final int WIDTH=900, HEIGHT=500;
	Thread thread;
	HumanPaddle p1;
	HumanPaddle2 p2;
	Ball b1;
	
	public void init()
	{
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		p1=new HumanPaddle();
		p2=new HumanPaddle2();
		b1=new Ball();
		thread=new Thread(this);
		thread.start();
		
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if(b1.getX()<-10||b1.getX()>850)
		{
			g.setColor(Color.WHITE);
			 g.drawString("GAME OVER", 450, 250);
		}
		p1.draw(g);
		b1.draw(g);
		p2.draw(g);
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("RUN");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(;;)
		{
			p1.move();
			b1.move();
			p2.move();
			b1.checkPaddleCollision(p1, p2);
			repaint();
			try 
			{
				Thread.sleep(1);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			p2.setUpAccel(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			p2.setDownAccel(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_W)
		{
			p1.setUpAccel(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			p1.setDownAccel(true);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			p2.setUpAccel(false);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			p2.setDownAccel(false);
		}
		else if(e.getKeyCode()==KeyEvent.VK_W)
		{
			p1.setUpAccel(false);
		}
		else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			p1.setDownAccel(false);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
