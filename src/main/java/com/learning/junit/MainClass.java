package com.learning.junit;

public class MainClass {
    public static void main(String arg[]){
        PalindromeExample pal=  new PalindromeExample();
        System.out.println("is Palindrom (madam)  : "+pal.isPalindrom("madam"));
        System.out.println("get palindrom of hahahahahadfdf  : "+pal.makePalindrom("hahahahahadfdf"));
    }
}
