import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GetIpCount {
    //域名匹配标识符
    private static final String domainRegex = ",hwucdn-drcn.dbankcdn.com";

    public static void main(String args[]) {
        Set<String> resultSet = new TreeSet<>();
        Map<String, Integer> resMap = new TreeMap<>();
        //文件路径
        String path="E:\\DNS日志\\hwsp_cmcc\\ALL";


        int fileNum = 0;
        int folderNum = 0;
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    System.out.println("文件夹:" + file2.getAbsolutePath());
                    list.add(file2);
                    folderNum++;
                } else {
                    excuteFile(file2.getAbsolutePath(),resMap);
                    System.out.println("文件:" + file2.getAbsolutePath());
                    fileNum++;
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        list.add(file2);
                        folderNum++;
                    } else {
                        excuteFile(file2.getAbsolutePath(),resMap);
                        System.out.println("文件:" + file2.getAbsolutePath());
                        fileNum++;
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        for (Map.Entry<String, Integer> entry : resMap.entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
    }

    public static void excuteFile(String filePath, Map<String,Integer> resMap){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        //每行读取文件
        try {
            String str;
            fis = new FileInputStream(filePath);
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
                    if (resMap.keySet().contains(result))
                    {
                        resMap.put(result, resMap.get(result)+1);
                    }
                    else
                    {
                        resMap.put(result,1);
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
    }
}
