package com.edu.cqu.teamwork01.yss;





import com.edu.cqu.teamwork01.ymy.SDES.SDes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Decipher extends JFrame{
    SDes sDes=new SDes();
    JPanel De;
    JLabel title,lab_cate,lab_txt,lab_sec,lab_res;
    JComboBox JC_cate;
    JTextField JT_txt,JT_sec;
    JTextArea Jt_res;
    JButton back,out,sure;
    public Decipher(){
        De=new JPanel();
        setContentPane(De);
        setLayout(null);
        setTitle("S-DES 解密");

        //UI标题
        title = new JLabel("解密模式");
        title.setBounds(125,75,150,40);
        title.setFont(new Font("楷体",Font.BOLD,35));
        title.setForeground(Color.blue);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        De.add(title);

        //输入类型
        lab_cate = new JLabel("输出类型：");
        lab_cate.setBounds(80,175,100,30);
        lab_cate.setFont(new Font("宋体",Font.BOLD,18));
        lab_cate.setForeground(Color.gray);
        lab_cate.setHorizontalAlignment(SwingConstants.LEFT);
        De.add(lab_cate);

        //类型选择
        JC_cate = new JComboBox();
        JC_cate.addItem("ASCII码");
        JC_cate.addItem("Binary");
        JC_cate.setBounds(190,175,130,30);
        JC_cate.setFont(new Font("楷体",Font.BOLD,12));
        JC_cate.setBackground(Color.white);
        De.add(JC_cate);

        //输入密文
        lab_txt = new JLabel("输入密文：");
        lab_txt.setBounds(80,210,100,30);
        lab_txt.setFont(new Font("宋体",Font.BOLD,18));
        lab_txt.setForeground(Color.gray);
        lab_txt.setHorizontalAlignment(SwingConstants.LEFT);
        De.add(lab_txt);

        //密文输入框
        JT_txt = new JTextField();
        JT_txt.setBounds(190,210,130,30);
        JT_txt.setFont(new Font("宋体",Font.BOLD,12));
        JT_txt.setHorizontalAlignment(SwingConstants.LEFT);
        De.add(JT_txt);

        //输入密钥
        lab_sec= new JLabel("输入密钥：");
        lab_sec.setBounds(80,245,100,30);
        lab_sec.setFont(new Font("宋体",Font.BOLD,18));
        lab_sec.setForeground(Color.gray);
        lab_sec.setHorizontalAlignment(SwingConstants.LEFT);
        De.add(lab_sec);

        //密钥输入框
        JT_sec = new JTextField();
        JT_sec.setBounds(190,245,130,30);
        JT_sec.setFont(new Font("宋体",Font.BOLD,12));
        JT_sec.setHorizontalAlignment(SwingConstants.LEFT);
        De.add(JT_sec);

        //解密结果
        lab_res = new JLabel("解密结果：");
        lab_res.setBounds(80,280,100,30);
        lab_res.setFont(new Font("宋体",Font.BOLD,18));
        lab_res.setForeground(Color.gray);
        lab_res.setHorizontalAlignment(SwingConstants.LEFT);
        De.add(lab_res);

        //结果展示
        Jt_res = new JTextArea();
        Jt_res.setBounds(190,280,130,30);
        Jt_res.setFont(new Font("宋体",Font.BOLD,12));
        De.add(Jt_res);

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
        De.add(back);

        //退出系统
        out=new JButton("退出");
        out.setBounds(150,380,100,30);
        out.setFont(new Font("黑体",Font.BOLD,20));
        out.setHorizontalAlignment(SwingConstants.CENTER);
        out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        De.add(out);

        //确认按钮
        sure=new JButton("确认");
        sure.setBounds(210,330,110,30);
        sure.setFont(new Font("黑体",Font.BOLD,20));
        sure.setHorizontalAlignment(SwingConstants.CENTER);
        sure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JT_txt.getText();
                String key= JT_sec.getText();
                String inputType=(String) JC_cate.getSelectedItem();
                String result="";
                if(inputType.equals("ASCII码")){
                    result=sDes.ASCII_Decode(input,key);
                }else {
                    if (input.length() == 8 && key.length() == 10) {
                        result = sDes.Decode(input,key);
                    } else {
                        JOptionPane.showMessageDialog(De, "请输入8位明文和10位密钥", "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
                Jt_res.setText(result);
            }
        });
        De.add(sure);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,150,400,500);
        setVisible(true);
    }
}


