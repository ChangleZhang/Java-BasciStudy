import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 根据域名+ip库匹配dns日志中所有目标地域访问来源的请求次数
 * domainRegex : 域名信息
 * ip_interval： ip库检索信息
 */
public class getTotalCount {
    public static final String domainRegex = ",appdl.hicloud.com";
    //正则匹配ip地址
    String regex = "([1-9]|[1-9]\\\\d|1\\\\d{2}|2[0-4]\\\\d|25[0-5])(\\\\.(\\\\d|[1-9]\\\\d|1\\\\d{2}|2[0-4]\\\\d|25[0-5])){3}";

    public static void main(String args[]) {

        Map<String,Integer> res = new TreeMap<String, Integer>();

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        //每行读取文件
        try {
            String str = "";
            fis = new FileInputStream("E:\\DNS日志\\logs\\华东-上海二\\20181106-170122e267\\query.log-2018-11-06-15-43.0199");
            isr = new InputStreamReader(fis,"utf-8");
            br = new BufferedReader(isr);
            while ((str = br.readLine()) != null) {
                if (str.contains(domainRegex)) {
                    int index = str.indexOf(domainRegex);
                    String result = str.substring(index - 15, index);
                    int bIndex = result.indexOf(" ");
                    if (bIndex != -1) {
                        result = result.substring(bIndex).trim();
                    }
                    if (res.containsKey(result))
                    {
                        res.put(result, res.get(result)+1);
                    }
                    else
                    {
                        res.put(result, 1);
                    }
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (String s : res.keySet()) {
            removeInfo(s);
            int[] caseArr = ip_interval.convertString2Int(s);
            if (ip_interval.checkin(caseArr))
            {
                System.out.println(s + " : " + res.get(s));
            }
        }
    }

    /**
     * 拿掉info:前缀
     * @param str 待去除前缀ip
     * @return 去除前缀后的结果
     */
    public static String removeInfo(String str)
    {
        if (str.contains(":"))
        {
            str = str.split(":")[1];
        }
        return str;
    }
}
