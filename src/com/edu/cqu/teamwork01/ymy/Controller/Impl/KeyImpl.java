package com.edu.cqu.teamwork01.ymy.Controller.Impl;


import com.edu.cqu.teamwork01.ymy.Controller.Key;

public class KeyImpl implements Key {

    int[] ten={3,5,2,7,4,10,1,9,8,6};
    int[] eight={6,3,7,4,8,5,10,9};

    @Override
    public String k1(String inSentence) {
        //p10置换
        String IniSentence= p(inSentence,ten,10);

        //左移
        String left=shift(IniSentence.substring(0,5));
        String right=shift(IniSentence.substring(5));

        //子密钥1
        return p(left+right,eight,8);

    }

    @Override
    public String k2(String inSentence) {
        //p10置换
        String IniSentence= p(inSentence,ten,10);
        //左移
        String left=shift(shift(IniSentence.substring(0,5)));
        String right=shift(shift(IniSentence.substring(5)));

        //子密钥2
        return p(left+right,eight,8);
    }

    /**
     * 置换
     * @param inSentence
     * @param transform
     * @param Num
     * @return
     */

    public String p(String inSentence, int[] transform, int Num) {
        String outSequence="";
        for(int i=0;i<Num;i++)
        {
            outSequence+=inSentence.charAt(transform[i]-1);
        }
        return outSequence;
    }

    /**
     * 对字符串进行左移操作
     * @param inSentence
     * @return
     */
    public String shift(String inSentence){
        return  inSentence.substring(1)+inSentence.charAt(0);
    }


}
