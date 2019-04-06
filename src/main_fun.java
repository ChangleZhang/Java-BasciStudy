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
 * @version [CDN V100R002C00, 2018年08月21日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class main_fun {
    public static final String domainRegex = ",www.ucdn.test.com.c.cdnhwc1.com";
    String regex = "([1-9]|[1-9]\\\\d|1\\\\d{2}|2[0-4]\\\\d|25[0-5])(\\\\.(\\\\d|[1-9]\\\\d|1\\\\d{2}|2[0-4]\\\\d|25[0-5])){3}";

    public static void main(String args[]) {
        List<String> record = readList("D:\\现网IP库\\DNSrizhi\\hw_gslb.log.1");
//        List<String> ipTable = readList("D:\\现网IP库\\mydata4vipday2.txtx.bac");

        //拿到testCase List
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
            fis = new FileInputStream("D:\\现网IP库\\mydata4vipday1.txt");
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
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
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
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            String str = "";
            while ((str = br.readLine()) != null) {
                list.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //查表拼接
    private static List<String> findIpTable(List<String> testCase, List<String> ipTable) {
        List<String> result = new ArrayList<>();

        for (String cases : testCase) {
            int[] caseArr = convertString2Int(cases.split("\\."));
            for (String ipString : ipTable) {
                String[] splitArr = ipString.split("\t");
                //处理第一个问号
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

    //类型转换
    private static int[] convertString2Int(String[] arr) {
        int[] caseNumArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            caseNumArr[i] = Integer.valueOf(arr[i]);
        }
        return caseNumArr;
    }

    //区间校验
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
