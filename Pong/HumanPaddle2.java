package Pong;
import java.awt.*;

public class HumanPaddle2 implements Paddle{
	double y, yVel;
	boolean upAccel, downAccel;
	int x;
	final double GRAVITY=0.94;
	public HumanPaddle2()
	{
		upAccel=false;
		downAccel=false;
		y=210;
		x=860;
		yVel=0;
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(x, (int)y, 20, 80);
	}
	public void move() {
		if(upAccel)
		{
			yVel-=0.01;
		}
		else if(downAccel)
		{
			yVel+=0.01;
		}
		else if(!upAccel&&!downAccel)
		{
			yVel*=GRAVITY; 
		}
		if(yVel==5)
		{
			yVel=5;
		}
		if(yVel==-5)
		{
			yVel=-5;
		}
		y+=yVel;
		if(y<0)
			{
				y=0;
			}
		if(y>=420)
		{
			y=420;
		}
		
	}
	public void setUpAccel(boolean input)
	{
		upAccel=input;
	}
	public void setDownAccel(boolean input)
	{
		downAccel=input;
	}
	public int getY() {
		return (int)y;
	}

}
