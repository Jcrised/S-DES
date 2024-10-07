package com.edu.cqu.teamwork01.ymy.SDES;

import com.edu.cqu.teamwork01.ymy.Controller.Impl.KeyImpl;
import com.edu.cqu.teamwork01.ymy.Controller.Impl.PBoxImpl;
import com.edu.cqu.teamwork01.ymy.Controller.Impl.RoundFuncImpl;
import com.edu.cqu.teamwork01.ymy.Controller.Key;
import com.edu.cqu.teamwork01.ymy.Controller.PBox;
import com.edu.cqu.teamwork01.ymy.Controller.RoundFunc;

import java.util.ArrayList;

public class SDes {

    int[] IP={2,6,3,1,4,8,5,7};
    int[] IPf={4,1,3,5,7,2,8,6};


    //加密
    public String Encryption(String cleartext,String key){
        PBox pbox=new PBoxImpl();
        Key k=new KeyImpl();
        RoundFunc roundFunc=new RoundFuncImpl();
        //生成子密钥
        String K1 = k.k1(key);
        String K2 = k.k2(key);

        String ip = pbox.p(cleartext, IP, 8);//初始置换
        String sentence01 = roundFunc.f(ip, K1);//k1
        String sentence02 = sentence01.substring(4) + sentence01.substring(0, 4); //swap
        String sentence03 = roundFunc.f(sentence02, K2); //k2
        return pbox.p(sentence03,IPf,8);//最终置换


    }


    //解密
    public String Decode(String code,String key){
        PBox pbox=new PBoxImpl();
        Key k=new KeyImpl();
        RoundFunc roundFunc=new RoundFuncImpl();

        //生成子密钥
        String K1 = k.k1(key);
        String K2 = k.k2(key);

        String ip = pbox.p(code, IP, 8);//初始置换
        String sentence01 = roundFunc.f(ip, K2);//k2
        String sentence02 = sentence01.substring(4) + sentence01.substring(0, 4); //swap
        String sentence03 = roundFunc.f(sentence02, K1); //k1
        return pbox.p(sentence03,IPf,8);//最终置换

    }


    //暴力破解，返回所有密文
    public ArrayList<String> ForceAttack(String code,String cleartext){
        ArrayList<String> arrayList=new ArrayList<>();
        String key;
        //从0开始，遍历所有10位二进制数。
        for(int i=0;i<1024;i++){
            //将十进制数变成10位二进制
            key=Integer.toBinaryString(i);
            while (key.length()<10){
                key="0"+key;
            }

            //把人工密文带入加密算法，如果能匹配则说明这个密文是满足条件的
            if(Encryption(cleartext,key).equals(code)){
                arrayList.add(key);
            }
        }
        return arrayList;
    }





    /**
     * ASCII编码进行加密：ASCII编码-》二进制-》ASCII编码输出
     *
     */



    //将每个字符，变成一个8位二进制数，用于加解密
    public  String charToBinary(char c,int num){
        String out=Integer.toBinaryString(c);
        while(out.length()<num)
            out="0"+out;
        return out;
    }

    //将二进制数，转换为字符
    public char BinaryToChar(String s) {
        return (char)Integer.parseInt(s,2);
    }

    //ASCII加密
    public String ASCII_Encryption(String cleartext,String key){
        String code="";
        for(int i=0;i<cleartext.length();i++){
            String oenchar = charToBinary(cleartext.charAt(i), 8);
            code=code+BinaryToChar(Encryption(oenchar,key));
        }
        return code;

    }

    //ASCII解密
    public String ASCII_Decode(String code,String key){
        String cleartext="";
        for(int i=0;i<code.length();i++){
            String oenchar = charToBinary(code.charAt(i), 8);
            cleartext=cleartext+BinaryToChar(Decode(oenchar,key));
        }
        return cleartext;

    }





}
