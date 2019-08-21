package com.adi.reactive.linkshortner.controller;

public class Solution {

  public static int nextPalindrome(int n){

    char num[] = String.valueOf(n).toCharArray();

    int length = num.length;
    int count =0;
    for(int  i =0;i<length;i++){
      if(num[i] == '9')
        count++;
    }
    int nextNum =1;
    if(count == length) {
      for (int i = 0; i <= length; i++)
        nextNum = nextNum * 10;
      nextNum +=1;
      return nextNum;
    }
    else {
      if (num.length % 2 == 0) {
        int mid = (length - 1) / 2;
        int s = Integer.parseInt(num[mid] + "");

        if (s == 9) {
          num[mid] = '0';
          num[mid + 1] = '0';
          num[mid-1] = ((Integer.parseInt(num[mid-1] + "")+1)+"").toCharArray()[0];
          num[mid+2] = ((Integer.parseInt(num[mid+1] + "")+1)+"").toCharArray()[0];
          //nextPal(n)

        } else {
          num[mid] =  ((s + 1)+"").toCharArray()[0];
          num[mid + 1] = num[mid];
        }
        String result = num.toString();

        return Integer.parseInt(result);

      } else {

        int mid = (length) / 2;
        int s = Integer.parseInt(num[mid] + "");
        if (s == 9){
          //replace below three lines with the commented code
          num[mid] = '0';
          num[mid-1] = ((Integer.parseInt(num[mid-1] + "")+1)+"").toCharArray()[0];
          num[mid+1] = ((Integer.parseInt(num[mid+1] + "")+1)+"").toCharArray()[0];}
        //nextPal(n)
        else
          num[mid] = ((s+1)+"").toCharArray()[0];
        String result = num.toString();
        return Integer.parseInt(result);

      }
    }


  }
  public static int nextPal(int n){
    char num[] = String.valueOf(n).toCharArray();
    int mid= num.length-1/2;
    for(int i=num.length/2,j =0; i < num.length;i++,j++){
      if(num[i] == '9'){
        if(i == mid && num.length%2==0){
          num[i] = '0';
          num[i+1] = '0';}
        else{
          if(i == mid)
          num[i] = '0';
          else
            num[i] = '0';
            num[j] = '0';
        }
      }
      else{

        num[i] = ((Integer.parseInt(num[i+1] + "")+1)+"").toCharArray()[0];
        break;
      }
    }
    return n;
  }
  public static void main(String[] args) {
    System.out.println(nextPalindrome(1221));
  }
}
