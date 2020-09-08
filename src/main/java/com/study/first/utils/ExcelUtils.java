package com.study.first.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * User: YHC
 * Date: 2020/9/7 16:56
 * DESC:
 */
public class ExcelUtils {

    public static void export(HttpServletResponse response, List<?> importList, String[] attributeNames){

        List<?> datalist = importList;

        //声明工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        //设置列宽度
        sheet.setDefaultColumnWidth(18);
        //获取字段名数组
        String[] tableAttributeName = attributeNames;
        //获取对象属性
        Field[] fields = ClassUtil.getClassAttribute(importList.get(0));

        //获取对象get方法
        List<Method> methodList = ClassUtil.getMethodGet(importList.get(0));

        //创建标题行
        Row row = sheet.createRow(0);
        for (int j=0; j< tableAttributeName.length; j++) {
            Cell cell = row.createCell(j);
            //设置单元格类型为String
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(transCellType(tableAttributeName[j]));
        }

        //创建普通行
        for (int i=0; i< datalist.size(); i++) {
            //从第二行开始创建
            row = sheet.createRow(i + 1);
            //第一行设置为标题行
            Object targetobj= datalist.get(i);
            for (int j=0; j< fields.length; j++) {
                //创建列
                Cell cell = row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                //
                try {
                    Object value = methodList.get(j).invoke(targetobj, new Object[]{});
                    cell.setCellValue(transCellType(value));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        response.setContentType("application/octet-stream");
        //默认Excel名称
        response.setHeader("Content-Disposition", "attachment;fileName="+"test.xls");

        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String transCellType(Object value){
        String str;
        if (value instanceof Date){
            Date date = (Date) value;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            str = sdf.format(date);
        }else{
            str = String.valueOf(value);
            if (str == "null"){
                str = "";
            }
        }
        return str;
    }
}
