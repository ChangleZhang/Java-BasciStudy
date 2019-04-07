package swordoffer.mindwiding;

public class Add {
    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.Add_Solution(3,4));
    }
    public int Add_Solution(int num1,int num2) {
        int sum =0;
        int carry = 0;
        do {
            sum = num1 ^ num2;
            carry = num1 & num2;

            num1 = sum;
            num2 = carry;
        } while(num2 !=0);
        return num1;
    }
}
