package com.woniuxy.operator.util;

import org.lionsoul.ip2region.xdb.Searcher;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPUtil {
    /**
     * 获取ip地址
     * @param request request对象
     * @return 返回对应IP地址
     */
    public static String getIpAddress(HttpServletRequest request){
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("X-Forwarded-For");
            if (ipAddress != null && ipAddress.length() != 0 && !"unknown".equalsIgnoreCase(ipAddress)) {
                // 多次反向代理后会有多个ip值，第一个ip才是真实ip
                if (ipAddress.contains(",")) {
                    ipAddress = ipAddress.split(",")[0];
                }
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ipAddress;
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            if (ipAddress != null && ipAddress.length() > 15) {
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        return ipAddress;
    }

    /**
     * 获取ip属地(文件扫描)
     * @param ip IP地址
     * @return 返回地址
     */
    public static String getCityInfoByFile(String ip) {
        // 1、创建 searcher 对象
        String dbPath = "parkingsys-operator/src/main/resources/ipdb/ip2region.xdb";
        Searcher searcher;
        try {
            searcher = Searcher.newWithFileOnly(dbPath);
        } catch (IOException e) {
            return null;
        }

        // 2、查询
        try {
            String region = searcher.search(ip);
            return region;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        // 3、备注：并发使用，每个线程需要创建一个独立的 searcher 对象单独使用。
    }
}
