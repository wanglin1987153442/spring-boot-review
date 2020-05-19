package com.soft1851.spring.boot.schedule.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wl
 * @ClassNamesad
 * @Description 定时器任务工具类
 * @Date 2020/5/18
 * @Version 1.0
 */
public class QuartzCronDateUtil {
    /**
     * 转换日期格式
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String timeStr = null;
        if (date != null) {
            timeStr = sdf.format(date);
        }
        return timeStr;
    }

    /**
     * 日期转换cron表达式时间格式
     *
     * @param date 日期
     * @return
     */
    public static String getCron(Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }
}