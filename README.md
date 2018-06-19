# BusInfoSystem
基于maven项目管理软件配置的SSM框架的车辆信息管理软件
  
  1、maven是一款基于项目全生命周期的资源管理软件，可以在此基础上快速地完成项目基础工程建设；
  
  2、提供jar本地中间库，方便项目导入jar包提供管理；
 
关于SSM框架实现web项目跨域访问，采用Rest控制器编写规则，因此配置项目跨域请求的时候新建了一个FilterCORSFilter.class过滤器类，基于web.xml配置如下：
  
   <filter>  
       
       <filter-name>SimpleCORSFilter</filter-name>  
       <filter-class>Filter.SimpleCORSFilter</filter-class>  
       <init-param>  
           <param-name>IsCross</param-name>  
           <param-value>true</param-value>  
       </init-param>  
   </filter>  
   <filter-mapping>  
       
       <filter-name>SimpleCORSFilter</filter-name>  
       <url-pattern>/*</url-pattern>  
   
   </filter-mapping>

其中该过滤器配置需要在项目编码过滤器配置之前。另外一种方式就是配置maven的jar包导入文件，映入cors-filter.jar,然后配置web.xml,这种方式不适合@RestController,初步判断适合@Controller+@ResponseBody规范类控制接口类。

  3、添加数据导出excle表格工具类：ExcleUtil.java
  
 
  package com.sansan.common;


  
  import org.apache.poi.hssf.usermodel.*;

  
  public class ExcelUtil {
    
    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
    
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String []title, String [][]values, HSSFWorkbook wb){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }
}
实现数据生成Excle表格的功能。
