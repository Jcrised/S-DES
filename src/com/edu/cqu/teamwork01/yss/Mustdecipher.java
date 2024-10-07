package com.edu.cqu.teamwork01.yss;



import com.edu.cqu.teamwork01.ymy.SDES.SDes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class Mustdecipher extends JFrame {
    SDes sDes=new SDes();
    JPanel Mus;
    JLabel title,lab_cate,lab_txt,lab_sec;
    JTextField JT_insec,JT_sec;
    JTextArea Jt_res;
    JButton back,out,start;
    public Mustdecipher(){
        Mus=new JPanel();
        setContentPane(Mus);
        setLayout(null);
        setTitle("S-DES 暴力破解");

        //UI标题
        title = new JLabel("暴力破解模式");
        title.setBounds(90,75,220,40);
        title.setFont(new Font("楷体",Font.BOLD,35));
        title.setForeground(Color.blue);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        Mus.add(title);

        //输入明文
        lab_cate = new JLabel("输入明文：");
        lab_cate.setBounds(80,140,100,30);
        lab_cate.setFont(new Font("宋体",Font.BOLD,18));
        lab_cate.setForeground(Color.gray);
        lab_cate.setHorizontalAlignment(SwingConstants.LEFT);
        Mus.add(lab_cate);

        //明文输入框
        JT_insec = new JTextField();
        JT_insec.setBounds(190,140,130,30);
        JT_insec.setFont(new Font("宋体",Font.BOLD,12));
        JT_insec.setHorizontalAlignment(SwingConstants.LEFT);
        Mus.add(JT_insec);

        //输入密文
        lab_txt = new JLabel("输入密文：");
        lab_txt.setBounds(80,175,100,30);
        lab_txt.setFont(new Font("宋体",Font.BOLD,18));
        lab_txt.setForeground(Color.gray);
        lab_txt.setHorizontalAlignment(SwingConstants.LEFT);
        Mus.add(lab_txt);

        //密文输入框
        JT_sec = new JTextField();
        JT_sec.setBounds(190,175,130,30);
        JT_sec.setFont(new Font("宋体",Font.BOLD,12));
        JT_sec.setHorizontalAlignment(SwingConstants.LEFT);
        Mus.add(JT_sec);

        //开始破解
        start= new JButton("开始破解");
        start.setBounds(220,210,100,30);
        start.setFont(new Font("宋体",Font.BOLD,15));
        start.setHorizontalAlignment(SwingConstants.CENTER);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cleartext = JT_insec.getText();
                String code=  JT_sec.getText();
                Jt_res.setText(""); //清空文本
                ArrayList<String> result=new ArrayList<>();
                if (cleartext.length() == 8 && code.length() == 8) {
                    result = sDes.ForceAttack(code,cleartext);
                } else {
                    JOptionPane.showMessageDialog(Mus, "请输入8位明文和8位密文", "错误", JOptionPane.ERROR_MESSAGE);
                }

                StringBuilder keys=new StringBuilder();
                for (String s : result) {
                    keys.append(s).append("\n");
                }
                Jt_res.setText(keys.toString());

            }
        });
        Mus.add(start);

        //密钥输出
        lab_sec= new JLabel("已破解密钥：");
        lab_sec.setBounds(80,210,120,30);
        lab_sec.setFont(new Font("宋体",Font.BOLD,18));
        lab_sec.setForeground(Color.gray);
        lab_sec.setHorizontalAlignment(SwingConstants.LEFT);
        Mus.add(lab_sec);

        //结果展示
        Jt_res = new JTextArea();
        Jt_res.setBounds(80,245,240,75);
        Jt_res.setFont(new Font("宋体",Font.BOLD,12));
        Mus.add(Jt_res);

        //返回主页面
        back=new JButton("返回");
        back.setBounds(80,330,110,30);
        back.setFont(new Font("黑体",Font.BOLD,20));
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new home();
                dispose();
            }
        });
        Mus.add(back);

        //退出系统
        out=new JButton("退出");
        out.setBounds(210,330,110,30);
        out.setFont(new Font("黑体",Font.BOLD,20));
        out.setHorizontalAlignment(SwingConstants.CENTER);
        out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Mus.add(out);








        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,150,400,500);
        setVisible(true);
    }



}
