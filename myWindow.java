package com.pratices;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class myWindow extends JFrame
{

    private JLabel heading;

    private JLabel clockLabel;

    private Font font=new Font("",Font.BOLD, 35); 
    myWindow()
    {
        super.setTitle(("My clock"));
        super.setSize(400,400);
        super.setLocation(300,50);
        this.CreateGUI();
        this.startClock();
        super.setVisible(true);
    }

    public void CreateGUI()
    {
        heading = new JLabel("My clock");
        clockLabel = new JLabel("clock");

        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);
    }

    public void startClock()
    {
       Thread t = new Thread()
       {
         public void run()
         {
            try
            {
               while(true)
               {
                 Date d=new Date();
                 SimpleDateFormat sfd=new SimpleDateFormat("hh : mm : ss a");
                 String dateTime=sfd.format(d);
                 clockLabel.setText(dateTime);
                 Thread.sleep(1000);
               }
            }catch(InterruptedException e)
            {
                e.printStackTrace();

            }
         }
       };
       t.start();
    }
    
}
