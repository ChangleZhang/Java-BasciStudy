package swordoffer.knowledge.migrate;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    /**
     * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
     * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
     * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
     * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
     * �������:
     * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
     */

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(3));
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        int total = 0;
        while (end < sum) {
            if (total == sum) {
                res.add(printRes(start, end));
                start ++;
                total -= start;
            } else if (total < sum) {
                end ++;
                total +=end;
            } else {
                start ++;
                total -= start;
            }
        }
        return res;
    }

    private static ArrayList<Integer> printRes(int start, int end) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = start+1; i <= end; i++) {
            res.add(i);
        }
        return res;
    }
}
