package com.kaishengit.tms.controller.Base;


import com.kaishengit.tms.entity.TicketOfficeInfermation;
import com.kaishengit.tms.service.TicketOfficeService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.AnonymousCOSCredentials;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;


/**
 *@Description:关于售票点的controller
 *@Author: 邱志辉
 *@Date 2016/4/19 0019下午 4:23
 */
@Controller
@RequestMapping("/base/office")
public class TicketOfficeController {

    @Autowired
    TicketOfficeService ticketOfficeService;

    /**
     *@描述:访问售票点目录
     *@参数:[model] 访问目录的传值对象，装有售票点List
     *@返回值java.lang.String
     */
    @GetMapping
    public  String home(Model model){

        List<TicketOfficeInfermation> officeList = ticketOfficeService.findAllTicketOffices();

        model.addAttribute("officeList",officeList);
        return "base/office/home";
    }


    /**
     *@描述:请求转发到新增售票点的页面
     *@参数:[]
     *@返回值java.lang.String
     */
    @GetMapping("/new")
    public String newOffice(){

        return "base/office/new";
    }

    /**
     *@描述:接收提交的售票点信息并存到数据库
     *@参数:[]
     *@返回值java.lang.String
     */
    @PostMapping("/new")
    public String saveOffice(TicketOfficeInfermation ticketOfficeInfermation,
                             RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("message","储存成功");
        return "redirect:/base/office";
    }



}
class test {
    public static void main(String[] args) {
        String bucketName = "qiuhui-tms-1256188839";
        String key = "/";
        Date expirationTime = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
        // 1 初始化用户身份信息, 匿名身份不用传入ak sk
        COSCredentials cred = new AnonymousCOSCredentials();

        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);


        URL url = cosclient.generatePresignedUrl(bucketName, key, expirationTime, HttpMethodName.POST);
        System.out.println(url);
    }
}

class test2{
    public static void main(String[] args) {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKIDd5IFwN3WcUCqHSu1RdnkV2LVTCgvniFY ", "ECvNZYIn4B7pKacPxGJ6evwhCRu9AwUn");
// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
// 3 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = "qiuhui-tms-1256188839";

        File localFile = new File("D:\\1.jpg");
// 指定要上传到 COS 上的路径
        String key = "/img";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
    }
}
