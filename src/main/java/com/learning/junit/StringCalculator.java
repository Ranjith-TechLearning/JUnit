package com.learning.junit;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public long calculate(String numbers) {
        long sum = 0;
        if ("".equals(numbers))
            sum = 0;
        else {
            String delimiter = "";
            String tempString ="";

            if(numbers.startsWith("//")){
                delimiter = getStrCalcDelimiter(numbers);
                tempString = numbers.replaceFirst("//", "").replaceFirst(delimiter,"")
                        .replaceAll("\\[|\\]","");
            }else{
                delimiter = "[/\n,]";
                tempString = numbers;
            }

            String arrNumbers[] = tempString.split(delimiter);
            System.out.println("Delimiter : "+ delimiter);


            Arrays.stream(arrNumbers).forEach((a)->System.out.println("Array"+a));

            for (String number : arrNumbers) {
                long temp  = Long.parseLong(number);
                if(temp<0){
                    throw new NumberFormatException("Number is Negative");
                }else if(temp <=1000)
                    sum += Long.parseLong(number);
            }
        }
        return sum;
    }

    private String getStrCalcDelimiter(String numbers){
        StringBuffer str = new StringBuffer();
       for (int i=2 ; i< numbers.length();i++){
           if(!Character.isDigit(numbers.charAt(i))){
               if(numbers.charAt(i)!=']' && numbers.charAt(i)!='[')
               str.append(numbers.charAt(i));
           }else{
               return str.toString();
           }
        }
        return str.toString();
    }

    public static void main(String arg[]){
        StringCalculator calc= new StringCalculator();
        calc.calculate("//[###]10###20###10001");
        //calc.calculate("10,20\n10001");

        String str = "//#10#20#10001";
        String str1 = str.replaceAll("\\[|\\]","");
        System.out.println("Removed Expression..."+str1);

    }

}
