package com.example.springbootbasic.controller.yaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RestController
@RequestMapping("/test")
public class YamlController {

    @Value("${address}")
    private String address;

    @Value("${address2}")
    private String address2;

    @Value("${address3}")
    private String address3;

    @Value("${count}")
    private Integer count;

    @Value("${price}")
    private Float price;

    @Value("${date}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Autowired
    private LangArrYAML langArr;

    @Value("${lang[2]}")
    private String langEn;

    @Autowired
    private UserYaml user;

    @GetMapping("yaml")
    public String readYaml() {
        StringBuilder sb = new StringBuilder();
        sb.append("read yaml: \n");
        sb.append("读取字符串: " + address + ", " + address2 + ", " + address3 + " \n");
        sb.append("读取数字:" + count + ", " + price + "\n");
        sb.append("读取日期: " + date.toString() + "\n");
        sb.append("读取对象: " + user.toString() + "\n");
        sb.append("读取数组: " + Arrays.toString(langArr.getLang()) + ", " + Arrays.toString(langArr.getUsers()) + ", " + langEn + "\n");
        return sb.toString();
    }

}
