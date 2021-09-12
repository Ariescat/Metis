package com.ariescat.metis.functions.eml;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Main {

    /**
     * G Era 标志符 Text AD
     * y 年 Year 1996; 96
     * M 年中的月份 Month July; Jul; 07
     * w 年中的周数 Number 27
     * W 月份中的周数 Number 2
     * D 年中的天数 Number 189
     * d 月份中的天数 Number 10
     * F 月份中的星期 Number 2
     * E 星期中的天数 Text Tuesday; Tue
     * a Am/pm 标记 Text PM
     * H 一天中的小时数（0-23） Number 0
     * k 一天中的小时数（1-24） Number 24
     * K am/pm 中的小时数（0-11） Number 0
     * h am/pm 中的小时数（1-12） Number 12
     * m 小时中的分钟数 Number 30
     * s 分钟中的秒数 Number 55
     * S 毫秒数 Number 978
     * z 时区 General time zone Pacific Standard Time; PST; GMT-08:00
     * Z 时区 RFC 822 time zone -0800
     */
    public static void main(String[] args) throws IOException, ParseException {

        String path = "C:\\Users\\xxx\\yyy\\zzz";

        SimpleDateFormat parseF = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
        SimpleDateFormat outF = new SimpleDateFormat("yyyy-MM-dd");

        File[] files = new File(path).listFiles();
        for (File file : files) {
            List<String> allLines = Files.readLines(file, Charset.defaultCharset());
            String dateStr = allLines.get(13).substring(6);
            Date date = parseF.parse(dateStr);
            String format = outF.format(date);
            String outPath = file.getParent() + "\\out\\" + format + ".eml";
            System.err.println(dateStr + " -> " + outPath);

            File create = new File(outPath);
            Files.createParentDirs(create);
            create.createNewFile();
            Files.copy(file, create);
        }
    }
}
