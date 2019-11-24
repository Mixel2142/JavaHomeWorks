package com.sbt.javaschool.rnd;

 public class test {
     public static void main(String[] args) {
         Integer integer = new Integer(10);
         System.out.println(integer);
         foo(integer);
         System.out.println(integer);

     }

     private static void foo(Integer integer) {
         integer=integer+10;
         System.out.println(integer);
     }
}
