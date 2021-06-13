import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class ClickMe extends JFrame
{
	JButton b1;
	ClickMe()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,500);
		getContentPane().setBackground(Color.BLUE);
		setLocationRelativeTo(null);
		Font fnt=new Font(Font.SERIF,Font.ITALIC,15);
		setLayout(null);
		ImageIcon ii=new ImageIcon("C:\\JavaProg\\def.jpg");
		ImageIcon ii2=new ImageIcon(ii.getImage().getScaledInstance(50, 50, Image.SCALE_FAST));
		b1=new JButton("Click Me");
		//setUndecorated(true);
		
		b1.setBounds(250,250,100,100);
		b1.setFont(fnt);
		add(b1);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(ClickMe.this,"You Win","Title",JOptionPane.INFORMATION_MESSAGE,ii2);
				dispose();
			}
		});
		b1.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				int rx=0,ry=0;
				Point p=b1.getLocation();
				int x=p.x;
				int y=p.y;
				if(me.getX()>=95 && me.getY()>=95)
					return;
				while(true)
				{
					Random r=new Random();
					rx=r.nextInt(425);
					ry=r.nextInt(425);
					Rectangle r1=new Rectangle(x,y,100,100);
					Rectangle r2=new Rectangle(rx,ry,100,100);
					if(!r1.intersects(r2))
						break;
				}
				b1.addKeyListener(new KeyAdapter()
				{
					public void keyPressed(KeyEvent ke)
					{
						char ch=ke.getKeyChar();
						if(ch==32)
							ke.consume();
					}
					
				});
				b1.setLocation(rx,ry);
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new ClickMe();
	}
}
