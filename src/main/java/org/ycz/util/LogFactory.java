package org.ycz.util;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogFactory.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss:SSS");

    public static void writeEnterLog(String className,String methodName,Object... params){
        LOGGER.info(sdf.format(new Date())+" :INTO "+className+"."+methodName+" params:"+params+"");
    }
    public static void writeEnterLog(String className, String methodName, HttpServletRequest request){
        Map parameters= request.getParameterMap();
        Map<String,Object> m = new HashMap<String,Object>();
        Set set = parameters.keySet();
        for (Object o : set){
            String o1 = request.getParameter(o.toString());
            m.put(o.toString().trim(),o1.trim());
        }
        String body = null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            String str, wholeStr = "";
            while((str = reader.readLine()) != null){
                wholeStr += str;
            }
            body = wholeStr;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        LOGGER.info(sdf.format(new Date())+" :HttpRequest:INTO "+className+"."+methodName+" \nparams:"+m+" \nbody:"+body+"\n-----------------\n");
    }

    public static void writeOutLog(String className,String methodName,Object... returnValue){
        LOGGER.info(sdf.format(new Date())+" :LEAVE "+className+"."+methodName+" returnValue:"+returnValue+"");
    }
}
