package chattingapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Client extends JFrame implements ActionListener{
    
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;
    
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    Client(){
        
        getContentPane().setBackground(Color.WHITE);
        
        p1 = new JPanel();
        p1. setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450,70);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/3.png"));       
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel l1 = new JLabel(i3);
        l1.setBounds(5,17,30,30);
        p1.add(l1);
        
        l1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/2.png"));       
        Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT); 
        ImageIcon i6 = new ImageIcon(i5); 
        JLabel l2 = new JLabel(i6);
        l2.setBounds(40,5,60,60);
        p1.add(l2);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/video.png"));       
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); 
        ImageIcon i9 = new ImageIcon(i8); 
        JLabel l3 = new JLabel(i9);
        l3.setBounds(290,20,30,30);
        p1.add(l3);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/phone.png"));       
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT); 
        ImageIcon i12 = new ImageIcon(i11); 
        JLabel l4 = new JLabel(i12);
        l4.setBounds(350,20,35,30);
        p1.add(l4);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/3icon.png"));       
        Image i14 = i13.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT); 
        ImageIcon i15 = new ImageIcon(i14); 
        JLabel l5 = new JLabel(i15);
        l5.setBounds(410,20,13,25);
        p1.add(l5);
        
        JLabel l6 = new JLabel("Client Side");
        l6.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        l6.setForeground(Color.WHITE);
        l6.setBounds(110,22,100,20);
        p1.add(l6);
        
        
        JLabel l7 = new JLabel("Active Now");
        l7.setFont(new Font("SAN_SERIF",Font.PLAIN,10));
        l7.setForeground(Color.WHITE);
        l7.setBounds(110,42,100,20);
        p1.add(l7);
        
        a1= new JTextArea();
        a1.setBounds(5,75,440,570);
        a1.setBackground(Color.WHITE);
        a1.setFont(new Font("SAN_SERIF",Font.PLAIN, 16));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);
        
        t1 = new JTextField();
        t1.setBounds(5,655,310,40);
        t1.setFont(new Font("SANS_SERIF",Font.PLAIN,16));
        add(t1);
        
        b1 = new JButton("Send");
        b1.setBounds(320,655,123,40);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SANS_SERIF",Font.PLAIN,16));
        b1.addActionListener(this);             
        add(b1);
        
        setLayout(null);
        setSize(450,700);
        setLocation(800,30);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
        String out = t1.getText();
        a1.setText(a1.getText()+ "\n\t\t\t"+out);  
        dout.writeUTF(out);
        t1.setText("");
        }catch(Exception e){
        }
    }
    
    public static void main(String[]args){
        new Client().setVisible(true);
        String msginput;
        try{
            s = new Socket("127.0.0.1",6020);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            msginput = din.readUTF();
            a1.setText(a1.getText()+"\n"+msginput);
        }
        catch(Exception e){
        }
    }
}
