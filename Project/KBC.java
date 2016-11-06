package kbcp;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class KBC extends KBC_Process implements ActionListener
{		
	KBC() throws FileNotFoundException {}
	
	String ques,cans;
	int quesno,cash=0,currques=5000,total=5000;
	JFrame f=new JFrame();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JPanel p5=new JPanel();
	JLabel question=new JLabel();
	JLabel currcash=new JLabel();
	JLabel thisques=new JLabel();
	JLabel totalCash=new JLabel();
	JLabel saperator=new JLabel("-----------------------------");
	JRadioButton c1=new JRadioButton();
	JRadioButton c2=new JRadioButton();
	JRadioButton c3=new JRadioButton();
	JRadioButton c4=new JRadioButton();
	ButtonGroup bg=new ButtonGroup();
	JButton conf=new JButton("CONFIRM");
	
	public void guiEnable()
	{
		this.f.setBounds(500,100,800,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.p1.setLayout(new FlowLayout());
		this.p1.setSize(600,300);
		this.p2.setLayout(new FlowLayout());
		this.p1.setBackground(Color.LIGHT_GRAY);
		this.p3.setBackground(Color.BLUE);
		this.p4.setBackground(Color.gray);
		this.p5.setLayout(new GridBagLayout());
		GridBagConstraints sjk=new GridBagConstraints();
		
		conf.addActionListener(this);
		
		
		bg.add(c1);
		bg.add(c2);
		bg.add(c3);
		bg.add(c4);
		p1.add(question);
		p2.add(c1);
		p2.add(c2);
		p2.add(c3);
		p2.add(c4);
		p3.add(conf);
		
		sjk.gridx=0;
		sjk.gridy=0;
		p5.add(currcash,sjk);
		sjk.gridx=0;
		sjk.gridy=1;
		p5.add(thisques,sjk);
		sjk.gridx=0;
		sjk.gridy=2;
		p5.add(saperator,sjk);
		sjk.gridx=0;
		sjk.gridy=3;
		p5.add(totalCash,sjk);
		
		p4.add(p5,BorderLayout.NORTH);
		
		this.f.add(p1,BorderLayout.NORTH);
		this.f.add(p2,BorderLayout.CENTER);
		this.f.add(p3,BorderLayout.SOUTH);
		this.f.add(p4,BorderLayout.EAST);
		this.f.setVisible(true);
	}
	
	public static void main(String args[]) throws IOException
	{
		KBC o=new KBC();
		o.guiEnable();
		o.startingPoint();
		
	}
	public void startingPoint() throws IOException
	{
		int i=1;
		quesno=quesno+1;
		this.ques=getQuestion();
		this.question.setText(""+quesno+") "+ques);
		while(i<=4)
		{
			//assign radio
			switch(i)
			{
			case 1:{
					c1.setText(getanswer());
					break;
				   }
			case 2:{
					c2.setText(getanswer());
					break;
			       }
			case 3:{
					c3.setText(getanswer());
					break;
		       	   }
			case 4:{
					c4.setText(getanswer());
					break;
		       	   }
			}
			i=i+1;
		}
		
		this.currcash.setText("Current Cash: "+this.cash);
		this.thisques.setText("This Question: "+this.currques);
		this.totalCash.setText("Total: "+this.total);
		
		//getCorrectAns()
		this.cans=getCorrectAns();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String opt;
		if(e.getSource()==this.conf)
		{
			if(this.c1.isSelected())
			{
				opt=c1.getText();
			}
			else if(this.c2.isSelected())
			{
				opt=c2.getText();
			}
			else if(this.c3.isSelected())
			{
				opt=c3.getText();
			}
			else
			{
				opt=c4.getText();
			}
			
			if(opt.equalsIgnoreCase(this.cans))
			{
				if(this.quesno==10)
				{
					dispWinMessage();
				}
				else
				{
					if(quesno<=5)
					{
						this.cash=this.cash+this.currques;
						this.currques+=5000;
						this.total=this.cash+this.currques;
					}
					else
					{
						this.cash=this.cash+this.currques;
						this.currques+=10000;
						this.total=this.cash+this.currques;
					}
					try 
					{
						startingPoint();
					} 
					catch (Exception e1)
					{
						
					}
				
				}
			}
			else
			{
				dispGameOver();
			}
		}
	}
	
	public void dispWinMessage()
	{
		String s;
		s="Congratulations!\n You have WON the game. \n Cash win="+this.total;
		JOptionPane.showMessageDialog(null,s);
		this.p3.setVisible(false);
		
	}
	public void dispGameOver()
	{
		String s;
		s="Sorry!\n You have chose a wrong answer.\n You got RS."+cash;
		JOptionPane.showMessageDialog(null,s);	
		this.p3.setVisible(false);
	}
}