import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Homeworks.Homework1;
import Homeworks.Homework10;
import Homeworks.Homework1B;
import Homeworks.Homework1C;
import Homeworks.Homework1D;
import Homeworks.Homework2;
import Homeworks.Homework2B;
import Homeworks.Homework3;
import Homeworks.Homework4;
import Homeworks.Homework5;
import Homeworks.Homework6;
import Homeworks.Homework7;
import Homeworks.Homework8;
import Homeworks.Homework9;

public class Screen extends JPanel{
	
	public Screen(){
		JFrame jframe = new JFrame();
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Homeworks");
		JMenu menu1 = new JMenu("Homework 1");
		JMenu menu2 = new JMenu("Homework 2");
		JMenu menu3 = new JMenu("Homework 3");
		JMenu menu4 = new JMenu("Homework 4");
		JMenu menu5 = new JMenu("Homework 5");
		JMenu menu6 = new JMenu("Homework 6");
		JMenu menu7 = new JMenu("Homework 7");
		JMenu menu8 = new JMenu("Homework 8");
		JMenu menu9 = new JMenu("Homework 9");
		JMenu menu10 = new JMenu("Homework 10");
		JMenuItem hw1mI1 = new JMenuItem("part 1");
		JMenuItem hw1mI2 = new JMenuItem("part 2");
		JMenuItem hw1mI3 = new JMenuItem("part 3");
		JMenuItem hw1mI4 = new JMenuItem("part 4");
		JMenuItem hw2mI1 = new JMenuItem("part 1");
		JMenuItem hw2mI2 = new JMenuItem("part 2");
		JMenuItem hw2mI3 = new JMenuItem("part 3");
		JMenuItem hw3mI1 = new JMenuItem("part 1");
		JMenuItem hw4mI1 = new JMenuItem("part 1");
		JMenuItem hw5mI1 = new JMenuItem("part 1");
		JMenuItem hw6mI1 = new JMenuItem("part 1");
		JMenuItem hw7mI1 = new JMenuItem("part 1");
		JMenuItem hw8mI1 = new JMenuItem("part 1");
		JMenuItem hw9mI1 = new JMenuItem("part 1");
		JMenuItem hw10mI1 = new JMenuItem("part 1");
		menu1.add(hw1mI1);
		menu1.add(hw1mI2);
		menu1.add(hw1mI3);
		menu1.add(hw1mI4);
		menu2.add(hw2mI1);
		menu2.add(hw2mI2);
		menu2.add(hw2mI3);
		menu3.add(hw3mI1);
		menu4.add(hw4mI1);
		menu5.add(hw5mI1);
		menu6.add(hw6mI1);
		menu7.add(hw7mI1);
		menu8.add(hw8mI1);
		menu9.add(hw9mI1);
		menu10.add(hw10mI1);
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);
		menu.add(menu4);
		menu.add(menu5);
		menu.add(menu6);
		menu.add(menu7);
		menu.add(menu8);
		menu.add(menu9);
		menu.add(menu10);
		menuBar.add(menu);
		jframe.setJMenuBar(menuBar);
		jframe.setTitle("DIP_HW1_By_Saeed_Khosravi");
		jframe.setLocation(100, 150);
		jframe.setSize(new Dimension(1100, 600));
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		jframe.setResizable(false);
		
		Graphics g = jframe.getGraphics();
		hw1mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Homework1 hw = new Homework1();
				jframe.setTitle("hw1_A");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getImage(),100,100,jframe);
				g.drawImage(hw.getImage2(),600,100,jframe);
				
			}
		});
		hw1mI2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				jframe.setTitle("hw1_B");
				new Homework1();
				Homework1B hw = new Homework1B();
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getImage3(),100,100,jframe);
				g.drawImage(hw.getImage4(),600,100,jframe);
				
			}
		});
		
		hw1mI3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Homework1();
				jframe.setTitle("hw1_C");
				g.clearRect(0, 50, 1200, 600);
				//resize hw.getImage2(); to 100*100;
				Homework1C hw1C = new Homework1C();
				g.drawImage(hw1C.getImage6(),350,100,jframe);
				
			}
		});
		
		hw1mI4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setTitle("hw1_D");
				g.clearRect(0, 50, 1200, 600);
				Homework1D hw = new Homework1D();
				g.drawImage(hw.getImage6(),350,100,jframe);
				
			}
		});
		
		
		hw2mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				double c;
				c = 100;
				Homework2 hw = new Homework2(c,1);
				jframe.setTitle("hw2_A");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getOriginalImage(), 300, 100, jframe);
				g.drawImage(hw.getImage(),600,100,jframe);
				
			}
		});
		
		hw2mI2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				jframe.setTitle("hw2_B");
				g.clearRect(0, 50, 1200, 600);
				Homework2B hw = new Homework2B();
				g.drawImage(hw.getcarImage(),100,50,jframe);
				g.drawImage(hw.getcar2Image(),100,225,jframe);
				g.drawImage(hw.getcar3Image(),100,400,jframe);
				g.drawImage(hw.getImage(),	600, 225, jframe);
			}
		});

		hw2mI3.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				double c;
				c = 1.5;
				Homework2 hw = new Homework2(c,2);
				jframe.setTitle("hw2_C");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getOriginalImage(), 300, 100, jframe);
				g.drawImage(hw.getImage(),600,100,jframe);
				
			}
		});
		
		hw3mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Homework3 hw = new Homework3();
				jframe.setTitle("hw3");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getBalloon(), 10, 60, jframe);
				g.drawImage(hw.getImage(),10,450,jframe);
				g.drawImage(hw.getImage2(),250,450,jframe);
				g.drawImage(hw.getImage3(),490,450,jframe);
				g.drawImage(hw.getBalloonTemp(),550,60,jframe);
			}
		});
		
		hw4mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Homework4 hw = new Homework4();
				jframe.setTitle("hw4");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getImage(), 400, 150, jframe);
			}
		});
		
		hw5mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Homework5 hw = new Homework5();
				jframe.setTitle("hw5");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getImage(8), 10, 60, 220,200, jframe);
				g.drawImage(hw.getImage(7), 240, 60, 220,200, jframe);
				g.drawImage(hw.getImage(6), 470, 60, 220,200, jframe);
				g.drawImage(hw.getImage(5), 700, 60, 220,200, jframe);
				g.drawImage(hw.getImage(4), 10, 300, 220,200, jframe);
				g.drawImage(hw.getImage(3), 240, 300, 220,200, jframe);
				g.drawImage(hw.getImage(2), 470, 300, 220,200, jframe);
				g.drawImage(hw.getImage(1), 700, 300, 220,200, jframe);
				
			}
		});
		
		hw6mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Homework6 hw = new Homework6();
				jframe.setTitle("hw6");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getImage(1), 10, 60, 220,200, jframe);
				g.drawImage(hw.getImage(2), 240, 60, 220,200, jframe);
				g.drawImage(hw.getImage(3), 470, 60, 220,200, jframe);
				g.drawImage(hw.getImage(4), 700, 60, 220,200, jframe);
			}
		});
		hw7mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Homework7 hw = new Homework7();
				jframe.setTitle("hw7");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getImage(),250,100,jframe);
				g.drawImage(hw.getImageR(),550,100,jframe);
				
			}
		});
		
		hw8mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Homework8 hw = new Homework8();
				jframe.setTitle("hw8");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getImage(),250,100,jframe);
				g.drawImage(hw.getImageS(),550,100,jframe);
				
			}
		});
		hw9mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Homework9 hw = new Homework9();
				jframe.setTitle("hw9");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getImageI1(),100,50,324,270,jframe);
				g.drawImage(hw.getImageI2(),100,325,324,270,jframe);
				g.drawImage(hw.getImageO(),440,160,jframe);
				
				
			}
		});
		hw10mI1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Homework10 hw = new Homework10();
				jframe.setTitle("hw10");
				g.clearRect(0, 50, 1200, 600);
				g.drawImage(hw.getImage(),10,50,198,310,jframe);
				g.drawImage(hw.getImage2(),210,50,198,310,jframe);
				g.drawImage(hw.getImage3(),410,50,198,310,jframe);
				g.drawImage(hw.getImage4(),610,50,198,310,jframe);
				g.drawImage(hw.getImage5(),810,50,198,310,jframe);
				
				
			}
		});
		
		
	}

}
