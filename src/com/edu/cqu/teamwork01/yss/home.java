package com.edu.cqu.teamwork01.yss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame {
    JPanel Login;
    JLabel title;
    JButton out,main_comCipher,main_deCipher,main_Must_deCipher;
    public home(){
        Login = new JPanel();
        setContentPane(Login);
        setLayout(null);
        setTitle("S-DES 加解密集成系统");

        title = new JLabel("S—DES 加解密集成系统");
        title.setBounds(100,50,400,40);
        title.setFont(new Font("楷体",Font.BOLD,35));
        title.setForeground(Color.blue);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        Login.add(title);

        main_comCipher= new JButton("加密模式");
        main_comCipher.setBounds(120,150,110,40);
        main_comCipher.setFont(new Font("黑体",Font.BOLD,18));
        main_comCipher.setHorizontalAlignment(SwingConstants.CENTER);
        main_comCipher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Comcipher();
                dispose();
            }
        });
        Login.add(main_comCipher);

        main_deCipher= new JButton("解密模式");
        main_deCipher.setBounds(245,150,110,40);
        main_deCipher.setFont(new Font("黑体",Font.BOLD,18));
        main_deCipher.setHorizontalAlignment(SwingConstants.CENTER);
        main_deCipher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Decipher();
                dispose();
            }
        });
        Login.add(main_deCipher);

        main_Must_deCipher= new JButton("暴力破解");
        main_Must_deCipher.setBounds(370,150,110,40);
        main_Must_deCipher.setFont(new Font("黑体",Font.BOLD,18));
        main_Must_deCipher.setHorizontalAlignment(SwingConstants.CENTER);
        main_Must_deCipher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Mustdecipher();
                dispose();
            }
        });
        Login.add(main_Must_deCipher);

        //退出按钮
        out=new JButton("退出");
        out.setBounds(200,220,200,40);
        out.setFont(new Font("黑体",Font.BOLD,20));
        out.setHorizontalAlignment(SwingConstants.CENTER);
        out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Login.add(out);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350,200,600,400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new home();
    }
}