package com.ariescat.metis.functions.eml;

import org.apache.commons.lang3.StringUtils;

import javax.mail.Address;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * base from https://blog.csdn.net/supershuyun/article/details/88691548
 */
public class Main2 {

    public static void main(String[] args) throws Exception {

        String pathname = "C:\\Users\\xxx\\yyy\\周报 2020-09-04.eml";

        Session mailSession = Session.getDefaultInstance(new Properties(), null);
        File file = new File(pathname);
        System.err.println("path: " + file.getAbsolutePath());

        FileInputStream source = new FileInputStream(file);
        MimeMessage msg = new MimeMessage(mailSession, source);

        Address[] froms = msg.getFrom();
        if (froms != null) {
            // System.out.println("发件人信息:" + froms[0]);
            InternetAddress addr = (InternetAddress) froms[0];
            System.out.println("发件人地址:" + addr.getAddress());
            System.out.println("发件人显示名:" + addr.getPersonal());
        }
        System.out.println("邮件主题:" + msg.getSubject());
        // getContent() 是获取包裹内容, Part相当于外包装
        Object o = msg.getContent();
        if (o instanceof Multipart) {
            Multipart multipart = (Multipart) o;
            reMultipart(multipart);
        } else if (o instanceof Part) {
            Part part = (Part) o;
            rePart(part);
        } else {
            System.out.println("类型" + msg.getContentType());
            System.out.println("内容" + msg.getContent());
        }
    }

    /**
     * @param part 解析内容
     */
    private static void rePart(Part part) throws Exception {

        if (part.getDisposition() != null) {

            String strFileNmae = part.getFileName();
            if (!StringUtils.isEmpty(strFileNmae)) {    // MimeUtility.decodeText解决附件名乱码问题
                strFileNmae = MimeUtility.decodeText(strFileNmae);
                System.out.println("发现附件: " + strFileNmae);

                InputStream in = part.getInputStream();// 打开附件的输入流
                // 读取附件字节并存储到文件中
                java.io.FileOutputStream out = new FileOutputStream(strFileNmae);
                int data;
                while ((data = in.read()) != -1) {
                    out.write(data);
                }
                in.close();
                out.close();

            }

            System.out.println("内容类型: " + MimeUtility.decodeText(part.getContentType()));
            System.out.println("附件内容:" + part.getContent());

        } else {
            if (part.getContentType().startsWith("text/plain")) {
                System.out.println("文本内容：" + part.getContent());
            } else {
                // System.out.println("HTML内容：" + part.getContent());
            }
        }
    }

    /**
     * @param multipart // 接卸包裹（含所有邮件内容(包裹+正文+附件)）
     */
    private static void reMultipart(Multipart multipart) throws Exception {
        // System.out.println("邮件共有" + multipart.getCount() + "部分组成");
        // 依次处理各个部分
        for (int j = 0, n = multipart.getCount(); j < n; j++) {
            // System.out.println("处理第" + j + "部分");
            Part part = multipart.getBodyPart(j);// 解包, 取出 MultiPart的各个部分,
            // 每部分可能是邮件内容,
            // 也可能是另一个小包裹(MultipPart)
            // 判断此包裹内容是不是一个小包裹, 一般这一部分是 正文 Content-Type: multipart/alternative
            if (part.getContent() instanceof Multipart) {
                Multipart p = (Multipart) part.getContent();// 转成小包裹
                // 递归迭代
                reMultipart(p);
            } else {
                rePart(part);
            }
        }
    }

}
