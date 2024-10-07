package com.edu.cqu.teamwork01.ymy.Controller.Impl;

import com.edu.cqu.teamwork01.ymy.Controller.PBox;

public class PBoxImpl implements PBox {
    @Override
    public String p(String inSentence, int[] transform, int Num) {
        String outSentence="";
        for(int i=0;i<Num;i++)
        {
            outSentence+=inSentence.charAt(transform[i]-1);
        }
        return outSentence;
    }
}
