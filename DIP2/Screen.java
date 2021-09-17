import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Screen extends JPanel{
    

    JScrollPane scrollPane;
    final int clear = 44;
    
public Screen(){
    JFrame jframe = new JFrame();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Project");
    JMenu menu1 = new JMenu("P1: Histogram");
    JMenu menu2 = new JMenu("P2: Histogram Normalization");
    JMenu menu3 = new JMenu("P3: Histogram Equalization");
    JMenu menu4 = new JMenu("P4: Histogram Adjustment");
    JMenu menu5 = new JMenu("P5: Sharping Image");
    JMenu menu6 = new JMenu("P6: Image Convolution");
    JMenu menu7 = new JMenu("P7: Image Embeding");
    JMenuItem hw1mI1 = new JMenuItem("Image Histogram");
    JMenuItem hw1mI2 = new JMenuItem("Image Histogram");
    JMenuItem hw2mI1 = new JMenuItem("Scaling and Streching Histogram");
    JMenuItem hw2mI2 = new JMenuItem("Normalizing Image Histogram");
    JMenuItem hw2mI3 = new JMenuItem("Normalizing Image Histogram");
    JMenuItem hw3mI1 = new JMenuItem("Histogram Equalization Method");
    JMenuItem hw3mI2 = new JMenuItem("Histogram Equalization");
    JMenuItem hw4mI1 = new JMenuItem("Histogram Equalization");
    JMenuItem hw4mI2 = new JMenuItem("Histogram Adjustment With Another Image");
    JMenuItem hw5mI1 = new JMenuItem("Sharping With Bluring Kernel Image");
    JMenuItem hw6mI1 = new JMenuItem("Convoluting kernels");
    JMenuItem hw6mI2 = new JMenuItem("Convoluting kernels");
    JMenuItem hw6mI3 = new JMenuItem("Convoluting kernels");
    JMenuItem hw7mI1 = new JMenuItem("Most Significant Bit(MSB)");
    menu1.add(hw1mI1);
    menu1.add(hw1mI2);
    menu2.add(hw2mI1);
    menu2.add(hw2mI2);
    menu2.add(hw2mI3);
    menu3.add(hw3mI1);
    menu3.add(hw3mI2);
    menu4.add(hw4mI1);
    menu4.add(hw4mI2);
    menu5.add(hw5mI1);
    menu6.add(hw6mI1);
    menu6.add(hw6mI2);
    menu6.add(hw6mI3);
    menu7.add(hw7mI1);
    menu.add(menu1);
    menu.add(menu2);
    menu.add(menu3);
    menu.add(menu4);
    menu.add(menu5);
    menu.add(menu6);
    menu.add(menu7);
    menuBar.add(menu);
    jframe.setJMenuBar(menuBar);
    jframe.setTitle("Image Processing By Saeed Khosravi");
    jframe.setLocation(100, 150);
    jframe.setSize(new Dimension(1100, 600));
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setVisible(true);
    jframe.setResizable(false);
    
    
    Graphics g = jframe.getGraphics();
    hw1mI1.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            IP1 ip = new IP1();
            jframe.setTitle("Image Histogram");
            g.clearRect(0, clear, 1200, 600);
            g.drawImage(ip.getImage(),100,100,450,250,jframe);
            new Histogram(ip.getImageHistogram(),jframe.getGraphics(), 450, 590, 230);
            g.drawImage(ip.getImage2(),560,100,450,250,jframe);
            if(scrollPane!= null)
                jframe.remove(scrollPane);
            
        }

        
    });
    
    hw1mI2.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            IP1 ip = new IP1();
            jframe.setTitle("Image Histogram");
            g.clearRect(0, clear, 1200, 600);
            g.drawImage(ip.getImage3(),100,100,450,250,jframe);
            new Histogram(ip.getImageHistogram2(),jframe.getGraphics(), 450, 590, 230);
            g.drawImage(ip.getImage4(),560,100,450,250,jframe);
            if(scrollPane!= null)
                jframe.remove(scrollPane);
        }
    });
    
    hw2mI1.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            IP2 ip = new IP2();
            jframe.setTitle("Image Histogram Streching and Scaling");
            g.clearRect(0, clear, 1200, 600);
            g.setFont(new Font("Serif", Font.BOLD, 16));
            g.drawString("Original Image", 110, 65);
            g.drawImage(ip.getImage(),100,70,jframe);
            new Histogram(ip.getImageHistogram(),jframe.getGraphics(), 100, 590, 230);
            g.drawString("Histogram Strech [c = "+ip.getc()+",d = "+ip.getd()+"]", 410, 65);
            g.drawImage(ip.getImage2(),400,70,jframe);
            new Histogram(ip.getImageHistogram2(),jframe.getGraphics(), 400, 590, 230);
            g.drawString("Scaling by C = "+ip.getC(), 710, 65);
            g.drawImage(ip.getImage3(),700,70,jframe);
            new Histogram(ip.getImageHistogram3(),jframe.getGraphics(), 700, 590, 230);
            if(scrollPane!= null)
                jframe.remove(scrollPane);
        }
    });
    
    hw2mI2.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            IP2 ip = new IP2();
            jframe.setTitle("Image Histogram Normalization");
            g.clearRect(0, clear, 1200, 600);
            g.setFont(new Font("Serif", Font.BOLD, 16));
            g.drawString("Original Image", 110, 65);
            g.drawImage(ip.getImage4(),100,70,jframe);
            new Histogram(ip.getImageHistogram4(),jframe.getGraphics(), 100, 590, 230);

            g.drawString("Log Normalization with C = "+ip.getC(), 410, 65);
            g.drawImage(ip.getImage5(),400,70,jframe);
            new Histogram(ip.getImageHistogram5(),jframe.getGraphics(), 400, 590, 230);
            g.drawString("P_Law Normalization C = "+ip.getC()+", Gamma = "+ip.getGamma(), 710, 65);
            g.drawImage(ip.getImage6(),700,70,jframe);
            new Histogram(ip.getImageHistogram6(),jframe.getGraphics(), 700, 590, 230);
            if(scrollPane!= null)
                jframe.remove(scrollPane);
        }
    });
    
hw2mI3.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            IP2 ip = new IP2();
            jframe.setTitle("Image Histogram Normalization");
            g.clearRect(0, clear, 1200, 600);
            g.setFont(new Font("Serif", Font.BOLD, 16));
            g.drawString("Original Image", 110, 65);
            g.drawImage(ip.getImage7(),100,70,326,200,jframe);
            new Histogram(ip.getImageHistogram7(),jframe.getGraphics(), 100, 590, 230);
            g.drawString("Log Normalization with C = "+ip.getC(), 440, 65);
            g.drawImage(ip.getImage8(),430,70,326,200,jframe);
            new Histogram(ip.getImageHistogram8(),jframe.getGraphics(), 430, 590, 230);
            g.drawString("P_Law Normalization C = "+ip.getC()+", Gamma = "+ip.getGamma(), 770, 65);
            g.drawImage(ip.getImage9(),760,70,326,200,jframe);
            new Histogram(ip.getImageHistogram9(),jframe.getGraphics(), 760, 590, 230);
            if(scrollPane!= null)
                jframe.remove(scrollPane);
        }
    });

hw3mI1.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        IP3 ip = new IP3();
        jframe.setTitle("Image Histogram Equalization");
        g.clearRect(0, clear, 1200, 600);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("Original Image", 110, 65);
        g.drawImage(ip.getImage(),100,70,200,200,jframe);
        new Histogram(ip.getImageHistogram(),jframe.getGraphics(), 100, 590, 230);
        Object columns[] = { "f", "P(I)", "g - sigma(P(I))","g*max","PG" };
        JTable table = new JTable(ip.getTable(), columns);
        scrollPane = new JScrollPane(table);
        jframe.add(scrollPane, BorderLayout.EAST);
        jframe.setVisible(true);
        g.drawString("Histogram Equalization", 370, 65);
        g.drawImage(ip.getImage2(),360,70,200,200,jframe);
        new Histogram(ip.getImageHistogram2(),jframe.getGraphics(), 360, 590, 230);
    }
    
});

hw3mI2.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        IP3 ip = new IP3();
        jframe.setTitle("Image Histogram Equalization");
        g.clearRect(0, clear, 1200, 600);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("Original Image", 110, 65);
        g.drawImage(ip.getImage3(),100,70,jframe);
        new Histogram(ip.getImageHistogram3(),jframe.getGraphics(), 100, 590, 230);
        g.drawString("Histogram Equalization", 510, 65);
        g.drawImage(ip.getImage4(),500,70,jframe);
        new Histogram(ip.getImageHistogram4(),jframe.getGraphics(), 500, 590, 230);
        if(scrollPane!= null)
            jframe.remove(scrollPane);
    }
});

hw4mI1.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        IP4 ip = new IP4();
        jframe.setTitle("Image Histogram Adjustment");
        g.clearRect(0, clear, 1200, 600);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("Original Image", 110, 65);
        g.drawImage(ip.getImage(),100,70,380,280,jframe);
        new Histogram(ip.getHistogram(),jframe.getGraphics(), 100, 590, 230);
        g.drawString("Histogram Equalization", 510, 65);
        g.drawImage(ip.getImage2(),500,70,380,280,jframe);
        new Histogram(ip.getHistogram2(),jframe.getGraphics(), 500, 590, 230);
        if(scrollPane!= null)
            jframe.remove(scrollPane);
    }
});
hw4mI2.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        IP4 ip = new IP4();
        jframe.setTitle("Image Histogram Adjustment");
        g.clearRect(0, clear, 1200, 600);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("Pigeon Image", 20, 65);
        g.drawImage(ip.getImage3(),10,70,350,250,jframe);
        new Histogram(ip.getHistogram3(),jframe.getGraphics(), 10, 590, 230);
        g.drawString("Soldier Image", 380, 65);
        g.drawImage(ip.getImage4(),370,70,350,250,jframe);
        new Histogram(ip.getHistogram4(),jframe.getGraphics(), 370, 590, 230);
        g.drawString("Pigeon HM from Soldier H", 740, 65);
        g.drawImage(ip.getImage5(),730,70,350,250,jframe);
        new Histogram(ip.getHistogram5(),jframe.getGraphics(), 730, 590, 230);
        if(scrollPane!= null)
            jframe.remove(scrollPane);
        
    }
});

hw5mI1.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        IP5 ip = new IP5();
        jframe.setTitle("Sharping Image using Bluring Image Kernel");
        g.clearRect(0, clear, 1200, 600);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("house Image", 20, 65);
        g.drawImage(ip.getImage(),10,70,350,250,jframe);
        //new Histogram(ip.getHistogram3(),jframe.getGraphics(), 10, 590, 230);
        g.drawString("blured house Image", 380, 65);
        g.drawImage(ip.getImage2(),370,70,350,250,jframe);
        //new Histogram(ip.getHistogram4(),jframe.getGraphics(), 370, 590, 230);
        g.drawString("house minus blured Image", 740, 65);
        g.drawImage(ip.getImage3(),730,70,350,250,jframe);
        g.drawString("unsharp masking Image", 20, 340);
        g.drawImage(ip.getImage4(),10,350,350,250,jframe);
        if(scrollPane!= null)
            jframe.remove(scrollPane);
        
        
    }
});

hw6mI1.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        IP6 ip = new IP6();
        jframe.setTitle("Convoluting Kernels on Image");
        g.clearRect(0, clear, 1200, 600);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("house Image", 20, 60);
        g.drawImage(ip.getImage(),10,65,350,250,jframe);
        g.drawString("a kernel", 380, 60);
        g.drawImage(ip.getImage2(),370,65,350,250,jframe);
        g.drawString("b kernel", 740, 60);
        g.drawImage(ip.getImage3(),730,65,350,250,jframe);
        g.drawString("c kernel", 20, 335);
        g.drawImage(ip.getImage4(),10,340,350,250,jframe);
        g.drawString("d kernel", 380, 335);
        g.drawImage(ip.getImage5(),370,340,350,250,jframe);
        g.drawString("e kernel", 740, 335);
        g.drawImage(ip.getImage6(),730,340,350,250,jframe);
        if(scrollPane!= null)
            jframe.remove(scrollPane);
    }
});
hw6mI2.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        IP6 ip = new IP6();
        jframe.setTitle("Convoluting Kernels on Image");
        g.clearRect(0, clear, 1200, 600);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("f kernel", 20, 60);
        g.drawImage(ip.getImage7(),10,65,350,250,jframe);
        g.drawString("g kernel", 380, 60);
        g.drawImage(ip.getImage8(),370,65,350,250,jframe);
        g.drawString("h kernel", 740, 60);
        g.drawImage(ip.getImage9(),730,65,350,250,jframe);
        g.drawString("i kernel", 20, 335);
        g.drawImage(ip.getImage10(),10,340,350,250,jframe);
        g.drawString("j kernel", 380, 335);
        g.drawImage(ip.getImage11(),370,340,350,250,jframe);
        g.drawString("k kernel", 740, 335);
        g.drawImage(ip.getImage12(),730,340,350,250,jframe);
        if(scrollPane!= null)
            jframe.remove(scrollPane);
    }
});
hw6mI3.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        IP6 ip = new IP6();
        jframe.setTitle("Convoluting Kernels on Image");
        g.clearRect(0, clear, 1200, 600);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("l kernel", 20, 60);
        g.drawImage(ip.getImage13(),10,65,350,250,jframe);
        if(scrollPane!= null)
            jframe.remove(scrollPane);
    }
});

hw7mI1.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        IP7 ip = new IP7();
        jframe.setTitle("Image embeding using Most Significant Bit technique");
        g.clearRect(0, clear, 1200, 600);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("Cover Image", 20, 60);
        g.drawImage(ip.getImage(),10,65,350,250,jframe);
        g.drawString("Message Image", 380, 60);
        g.drawImage(ip.getImage2(),370,65,350,250,jframe);
        g.drawString("Message MSB 1", 740, 60);
        g.drawImage(ip.getImage3(),730,65,350,250,jframe);
        g.drawString("Message MSB 2", 20, 335);
        g.drawImage(ip.getImage4(),10,340,350,250,jframe);
        g.drawString("Message MSB 3", 380, 335);
        g.drawImage(ip.getImage5(),370,340,350,250,jframe);
        g.drawString("Reveal Image", 740, 335);
        g.drawImage(ip.getImage6(),730,340,350,250,jframe);
        if(scrollPane!= null)
        jframe.remove(scrollPane);
    }
});

    
    }

    

}
