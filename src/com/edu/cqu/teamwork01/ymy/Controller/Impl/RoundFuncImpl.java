package com.edu.cqu.teamwork01.ymy.Controller.Impl;

import com.edu.cqu.teamwork01.ymy.Controller.RoundFunc;

public class RoundFuncImpl implements RoundFunc {
    int[] EPBox={4,1,2,3,2,3,4,1};
    int[][] Sbox1={
            {1,0,3,2},
            {3,2,1,0},
            {0,2,1,3},
            {3,1,0,2}
    };

    int[][] Sbox2={
            {0,1,2,3},
            {2,3,1,0},
            {3,0,1,2},
            {2,1,0,3}
    };

    int[] SPBox={2,4,3,1};

    public String f(String inSentence,String key){
        String right=inSentence.substring(4);  //右部分
        String left=inSentence.substring(0,4);  //左部分
        //轮函数
        String Extendright = p(right, EPBox, 8); //对右部分进行扩展置换
        String newkey = xor(Extendright, key, 8); //对右部分进行加轮密钥
        String sboxkey = SBox(newkey.substring(0, 4), Sbox1) + SBox(newkey.substring(4), Sbox2);  //对右部分进行替换
        String afterRight= p(sboxkey,SPBox,4); //对右部分进行直接替换

        left=xor(left,afterRight,4);

        return left+right;


    }

    public String p(String inSentence, int[] transform, int Num) {
        String outSentence="";
        for(int i=0;i<Num;i++)
        {
            outSentence+=inSentence.charAt(transform[i]-1);
        }
        return outSentence;
    }

    public  String xor(String inSentence1,String inSentence2,int length){
        String out="";
        for (int i = 0; i < length; i++) {
            if(inSentence1.charAt(i)==inSentence2.charAt(i)){
                out+="0";
            }else {
                out+="1";
            }

        }
        return out;

    }

    public  String SBox(String inSentence,int[][] Sbox){
        //将二进制转为十进制
        int i = (inSentence.charAt(0) - '0') * 2 + inSentence.charAt(3) - '0';
        int j = (inSentence.charAt(1)-'0')*2+inSentence.charAt(2)-'0';

        //替换为SBox上的二进制码
        String binaryString = Integer.toBinaryString(Sbox[i][j]);
        if(binaryString.length()<2){
            binaryString="0"+binaryString;
        }
        return binaryString;
    }




}
