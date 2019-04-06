import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ip_interval {
    static String location = "D:\\现网问题定位\\江苏电信比例问题\\js_ip_qujian.txt";

    public static Boolean checkin(int[] caseArr){
        List<String> ipTable = readList(location);
        for (String ip : ipTable)
        {
            String[] ips = ip.split("\\s+");
            String lowStr = ips[0];
            String highStr = ips[1];
            int[] lowArr = convertString2Int(lowStr);
            int[] highArr = convertString2Int(highStr);
            if (isIn(caseArr,lowArr,highArr))
            {
                //System.out.println(lowStr + "---" + highStr + " contains ||| " + caseArr[0] + "." + caseArr[1]+ "." + caseArr[2]+ "." + caseArr[3]);
                return true;
            }
        }
        return false;
    }

    //类型转换
    public static int[] convertString2Int(String str) {
        //System.out.println("convert :"+ str);
        String[] strIp = str.split("\\.");
        int[] res = new int[4];
        for (int i=0;i<strIp.length;i++)
        {
            res[i] = Integer.parseInt(strIp[i]);
        }
        //System.out.println("generate "+ res[0] + "." + res[1]+ "." + res[2]+ "." + res[3]);
        return res;
    }

    public static Boolean isIn(int[] caseArr, int[] lowArr, int[] highArr) {
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

    private static List<String> readList(String path) {
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
}
