package com.learning.junit;

public class PalindromeExample {

    public String makePalindrom (String txt){
        StringBuffer reverseTxt = new StringBuffer();
        for(int i= txt.length();i>0;i--){
            reverseTxt.append( txt.charAt(i-1));
        }
        return reverseTxt.toString();
    }
    public boolean isPalindrom (String txt){
        StringBuffer reverseTxt = new StringBuffer();
        for(int i= txt.length();i>0;i--){
           reverseTxt.append( txt.charAt(i-1));
        }

        return txt.equals(reverseTxt.toString());
    }

}
