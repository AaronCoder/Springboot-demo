package cn.ypf.Tool;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;

/**
 *实际项目中:
 * 1.excel上传到某云上(*)
 * 2.然后下载下来，然后解析做业务处理(一般也就是数据库落地)
 * 3.中间可以做一个进度条(**)
 *
 * */
public class sheetOperator {

    public static void main(String args[]){
        System.out.println("Hello Worlds~");
        try {
            sheetImport();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            sheetExport();
            System.out.print("表格导出结束`");
        } catch (IOException e) {
            System.out.println("发生异常了呦~");
        }*/
    }

    private static void sheetExport() throws IOException {
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("sheet0");
        //创建HSSFRow对象
        HSSFRow row = sheet.createRow(0);
        //创建HSSFCell对象
        HSSFCell cell=row.createCell(0);
        //设置单元格的值
        cell.setCellValue("学员考试成绩一览表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        //在sheet里创建第二行
        HSSFRow row2=sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("姓名");
        row2.createCell(1).setCellValue("班级");
        row2.createCell(2).setCellValue("笔试成绩");
        row2.createCell(3).setCellValue("机试成绩");

        //在sheet里创建第三行
        HSSFRow row3=sheet.createRow(2);
        row3.createCell(0).setCellValue("李明");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue(87);
        row3.createCell(3).setCellValue(78);

        //在sheet里面创建第四行
        HSSFRow row4=sheet.createRow(3);
        row4.createCell(0).setCellValue("闫朋飞");
        row4.createCell(1).setCellValue("As177");
        row4.createCell(2).setCellValue(100);
        row4.createCell(3).setCellValue(100);

        //输出Excel文件
        FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
        wb.write(output);
        output.flush();
        wb.close();
    }

    private static void sheetImport() throws IOException {

        File file = new File("d:\\workbook.xls");
        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet hssfSheet= workbook.getSheetAt(0);

        //得到sheet的行数
        int lastRowNum = hssfSheet.getLastRowNum();
        for(int i = 0;i<lastRowNum;i++){
           HSSFRow hssfRow = hssfSheet.getRow(i);
           int lastCellNum = hssfRow.getLastCellNum();
           for(int j = 0;j<lastCellNum;j++){
               HSSFCell hssfCell = hssfRow.getCell(j);
               System.out.print(hssfCell);
               System.out.print(" ");
           }
           System.out.println();
        }








    }

}

