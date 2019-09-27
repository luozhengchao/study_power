package com.luo.nio;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author luozhengchao
 * @Date 2019/3/14 7:39 PM
 */
public class DownLoadFile {

    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }


        System.out.println("info:"+url+" download success");

    }



    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void main(String[] args) {
        try{
//            String name = "2b117eee-74d7-4cf1-9ec4-1680852fd7c5";
//            String name = "ae37d946-3f59-4c40-9dd8-c833824227cf";
//            String name = "4031bc53-d86a-4789-901d-15d7277949f0";
//            String name = "11bbd860-bcdf-4e1f-882f-721057adb2a8";//c
            String name = "48be2e72-2702-4f3e-9461-fe010e84ef57";//c
            String urlPre = "http://stg.iobs.pingan.com.cn/download/peimcadmin-sf-dev/";
            downLoadFromUrl(urlPre + name,
                    name.substring(0,6) + ".zip","/Users/luozhengchao/Desktop");
        }catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
