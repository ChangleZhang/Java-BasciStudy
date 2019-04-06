/**
 * Created by z00444920 on 2018/8/21.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * main_fun
 *
 * @author z00444920
 * @version [CDN V100R002C00, 2018��08��21��]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
 */
public class main_fun {
    public static final String domainRegex = ",www.ucdn.test.com.c.cdnhwc1.com";
    String regex = "([1-9]|[1-9]\\\\d|1\\\\d{2}|2[0-4]\\\\d|25[0-5])(\\\\.(\\\\d|[1-9]\\\\d|1\\\\d{2}|2[0-4]\\\\d|25[0-5])){3}";

    public static void main(String args[]) {
        List<String> record = readList("D:\\����IP��\\DNSrizhi\\hw_gslb.log.1");
//        List<String> ipTable = readList("D:\\����IP��\\mydata4vipday2.txtx.bac");

        //�õ�testCase List
        Set<String> res = new TreeSet<>();
        for (String rc : record) {
            if (rc.contains(domainRegex)) {
                int index = rc.indexOf(domainRegex);
                String result = rc.substring(index - 15, index);
                int bIndex = result.indexOf(" ");
                if (bIndex != -1) {
                    result = result.substring(bIndex).trim();
                }
                res.add(result);
            }
        }

        List<String> testCase = new ArrayList<>(res);

        List<String> finalRes = new ArrayList<>();

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            String str = "";
            fis = new FileInputStream("D:\\����IP��\\mydata4vipday1.txt");
            isr = new InputStreamReader(fis,"utf-8");
            br = new BufferedReader(isr);
            while ((str = br.readLine()) != null) {
                List<String> ipTable = new ArrayList<>();
                ipTable.add(str);
                List<String> resBuffer = findIpTable(testCase, ipTable);
                for (String s : resBuffer)
                {
                    finalRes.add(s);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("�Ҳ���ָ���ļ�");
        } catch (IOException e) {
            System.out.println("��ȡ�ļ�ʧ��");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (String s : finalRes) {
            System.out.println(s);
        }
    }

    public static List<String> readList(String path) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        List<String> list = new LinkedList();
        try {
            fis = new FileInputStream(path);// FileInputStream
            // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
            isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
            br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
            String str = "";
            while ((str = br.readLine()) != null) {
                list.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("�Ҳ���ָ���ļ�");
        } catch (IOException e) {
            System.out.println("��ȡ�ļ�ʧ��");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //���ƴ��
    private static List<String> findIpTable(List<String> testCase, List<String> ipTable) {
        List<String> result = new ArrayList<>();

        for (String cases : testCase) {
            int[] caseArr = convertString2Int(cases.split("\\."));
            for (String ipString : ipTable) {
                String[] splitArr = ipString.split("\t");
                //�����һ���ʺ�
                splitArr[0] = splitArr[0].substring(1);

                int[] lowArr = convertString2Int(splitArr[0].split("\\."));
                int[] highArr = convertString2Int(splitArr[1].split("\\."));

                if (checkIn(caseArr, lowArr, highArr)) {
                    result.add(cases + " belongs to " + ipString);
                }
            }
        }

        return result;
    }

    //����ת��
    private static int[] convertString2Int(String[] arr) {
        int[] caseNumArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            caseNumArr[i] = Integer.valueOf(arr[i]);
        }
        return caseNumArr;
    }

    //����У��
    private static boolean checkIn(int[] caseArr, int[] lowArr, int[] highArr) {
        if (caseArr.length != 4 || lowArr.length != 4 || highArr.length != 4) {
            return false;
        }
        boolean res = true;
        for (int i = 0; i < 4; i++) {
            res = res && (caseArr[i] >= lowArr[i] && caseArr[i] <= highArr[i]);
            if (!res) {
                return false;
            }
        }
        return true;
    }
}
