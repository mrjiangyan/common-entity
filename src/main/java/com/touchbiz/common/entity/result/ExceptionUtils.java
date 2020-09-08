package com.touchbiz.common.entity.result;

import java.util.HashMap;
import java.util.Map;

/**
 * 此类是异常关键信息提取工具类
 *
 * @author wenzhiqiang
 * @date 2017年3月28日
 */
final class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static Map getExceMainInfo(Throwable e) {
        if (e == null) {
            return null;
        } else {
            Map<String, Map<String, Object>> exceptionInfoMap = new HashMap<>();
            Throwable t = e.getCause() != null ? e.getCause() : e;
            Map<String, Object> rootInfoMap = new HashMap<>();
            rootInfoMap.put("原因", t.getMessage());
            rootInfoMap.put("类型", t.getClass().getName());
            if( e.getStackTrace().length>0) {
                rootInfoMap.put("行号", t.getStackTrace()[0].getLineNumber());
                rootInfoMap.put("方法名", t.getStackTrace()[0].getMethodName());
                rootInfoMap.put("类名", t.getStackTrace()[0].getClassName());
            }
            exceptionInfoMap.put("异常信息", rootInfoMap);
            int len = e.getStackTrace().length;
            int loop = 0;
            while (loop < len) {
                if (e.getStackTrace()[loop].getClassName().startsWith("com.byh")) {
                    Map<String, Object> localCallInfoMap = new HashMap<>();
                    localCallInfoMap.put("行号", e.getStackTrace()[loop].getLineNumber());
                    localCallInfoMap.put("方法名", e.getStackTrace()[loop].getMethodName());
                    localCallInfoMap.put("类名", e.getStackTrace()[loop].getClassName());
                    exceptionInfoMap.put("调用信息", localCallInfoMap);
                    break;
                }
                loop++;
            }
            return exceptionInfoMap;
        }
    }
}
