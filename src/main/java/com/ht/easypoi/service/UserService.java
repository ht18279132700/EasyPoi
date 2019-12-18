package com.ht.easypoi.service;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.ht.easypoi.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author ht
 * @create 2019-12-13 14:28
 */
@Slf4j
@Service
public class UserService {



    /**
     * 输出Excel
     * @param request
     * @param response
     */
    public void easypoiSingleExcelView(HttpServletRequest request, HttpServletResponse response, Integer num) {
        ExportParams params = new ExportParams("注解导出View用法", "sheet1", ExcelType.XSSF);
        Map map = new HashMap();
        List list = list(num);
        map.put(NormalExcelConstants.DATA_LIST, list);
        map.put(NormalExcelConstants.CLASS, User.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put("注解导出View用法", utf8("注解导出View用法",response));
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }


    /**
     * 输出Excel
     * @param request
     * @param response
     * @param num
     */
    public void nowExcel(HttpServletRequest request, HttpServletResponse response, Integer num) {
        List list = list(num);
        try {
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(utf8("普通导出用户", response, ".xls"), "sheet1"),
                    User.class, list);
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.error("导出Excel异常，" + e);
        }
    }

    public void bigExcel(HttpServletRequest request, HttpServletResponse response, Integer num){
        Workbook workbook = null;
        for(Integer j = 0; j < num;){
            List list = list(10000);
            workbook = ExcelExportUtil.exportBigExcel(new ExportParams(utf8("Excel大数据导出", response, ".xlsx"), "sheet1"), User.class, list);
            list.clear();
            j += 10000;
        }
        ExcelExportUtil.closeExportBigExcel();
        try {
            workbook.write(response.getOutputStream());
        }catch (IOException e){
            log.error("导出Excel异常，" + e);
        }
    }

    private List<User> list(Integer num){
        List<User> list = new ArrayList<User>();
        for (Integer i = 0; i < num; i++){
            User user = new User();
            user.setUserId(i);
            user.setBrandId(i + 1000000l);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setMobile("电话号码");
            user.setSerialId(i + 1000000l);
            user.setNickName("昵称");
            user.setStatus(0);
            user.setWxName("微信名字");
            list.add(user);
        }
        return list;
    }

    /**
     * 解决导出文件名乱码
     * @param fileName
     * @param response
     * @return
     */
    private String utf8(String fileName ,HttpServletResponse response) {
        try {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            return fileName;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解决导出文件名乱码
     * @param fileName
     * @param response
     * @return
     */
    private String utf8(String fileName , HttpServletResponse response, String suffix) {
        try {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1") + suffix);
            return fileName;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
