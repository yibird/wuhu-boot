package com.fly.common.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.lionsoul.ip2region.xdb.Searcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description ip工具类
 * @Author zchengfeng
 * @Date 2023/3/14 10:16
 */
public class IpUtils {
    /**
     * 从HttpServletRequest获取ip地址
     *
     * @param request HttpServletRequest
     * @return 返回ip地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        if (request == null) return "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : getMultistageReverseProxyIp(ip);
    }

    /**
     * 获取多阶段反向代理IP,从反向代理中，获得第一个非 unknown IP地址
     *
     * @param ip ip地址
     * @return ip地址
     */
    public static String getMultistageReverseProxyIp(String ip) {
        // 反向代理检测
        if (ip.indexOf(",") > 0) {
            final String[] ips = ip.trim().split(",");
            for (String sub : ips) {
                if (!"unknown".equalsIgnoreCase(sub)) {
                    ip = sub;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 根据ip地址获取对应的区域
     * @param ip ip地址
     * @return 区域
     */
    public static String getIpRegion(String ip) {
        String dbPath = "ip2region.xdb file path";
        Searcher searcher = null;
        try {
            searcher = Searcher.newWithFileOnly(dbPath);
        } catch (IOException e) {
            System.out.printf("failed to create searcher with `%s`: %s\n", dbPath, e);
        }
        try {
            long sTime = System.nanoTime();
            String region = searcher.search(ip);
            long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
            System.out.printf("{region: %s, ioCount: %d, took: %d μs}\n", region, searcher.getIOCount(), cost);
            return region;
        } catch (Exception e) {
            System.out.printf("failed to search(%s): %s\n", ip, e);
        }
        return "";
    }
}
