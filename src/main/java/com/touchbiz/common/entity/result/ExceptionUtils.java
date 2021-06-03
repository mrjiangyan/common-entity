package com.touchbiz.common.entity.result;

import java.util.HashMap;
import java.util.Map;

/**
 * 此类是异常关键信息提取工具类
 *
 * @author wenzhiqiang
 * @date 2017年3月28日
 */
public class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static Map getExceMainInfo(Throwable e) {
        if (e == null) {
            return null;
        } else {
            Map<String, Map<String, Object>> exceptionInfoMap = new HashMap<>();
            Throwable t = e.getCause() != null ? e.getCause() : e;
            Map<String, Object> rootInfoMap = new HashMap<>();
            rootInfoMap.put("reason", t.getMessage());
            rootInfoMap.put("type", t.getClass().getName());
            if(e.getStackTrace().length>0) {
                rootInfoMap.put("line", t.getStackTrace()[0].getLineNumber());
                rootInfoMap.put("method", t.getStackTrace()[0].getMethodName());
                rootInfoMap.put("class", t.getStackTrace()[0].getClassName());
            }
            exceptionInfoMap.put("errorInfo", rootInfoMap);
            int len = e.getStackTrace().length;
            int loop = 0;
            while (loop < len) {
                if (e.getStackTrace()[loop].getClassName().startsWith("com.touchbiz")) {
                    Map<String, Object> localCallInfoMap = new HashMap<>();
                    localCallInfoMap.put("line", e.getStackTrace()[loop].getLineNumber());
                    localCallInfoMap.put("method", e.getStackTrace()[loop].getMethodName());
                    localCallInfoMap.put("class", e.getStackTrace()[loop].getClassName());
                    exceptionInfoMap.put("callInfo", localCallInfoMap);
                    break;
                }
                loop++;
            }
            return exceptionInfoMap;
        }
    }


}
