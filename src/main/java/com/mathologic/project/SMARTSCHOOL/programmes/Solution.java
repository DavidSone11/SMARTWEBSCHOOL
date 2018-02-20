package com.mathologic.project.SMARTSCHOOL.programmes;

public class Solution {
    public static int solution(int[] a) {
        int Unpaired = a[0];
        for (int i = 1; i < a.length; i++) {
            Unpaired = Unpaired ^ a[i];
        }
        System.out.println(Unpaired);
        return 0;
    }

    public static void main(String args[]) {
        int[] arr = new int [args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
            System.out.print(""+arr[i]);
            //solution();

        }
    }
}