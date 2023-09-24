package com.joe.sys.utils;

import com.joe.sys.entity.Running;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImportExcelUtils2 {
    // 将表格中的数据添加到List集合中
    public List<Running> upload(String fileName, InputStream is) throws Exception{
        Workbook workbook = new XSSFWorkbook(is);
        List<Running> runningList = new ArrayList<>();
        int number = workbook.getNumberOfSheets(); // 获取sheet值
        for (int i = 0; i < number; i++) {
            Sheet sheet = workbook.getSheetAt(i); // 获取表格页码
            if (sheet != null){
                int rowNum = sheet.getLastRowNum(); // 获取该页表共有多少行
                for (int j = 1; j <= rowNum; j++) {  // 一般来说第一行是标题,所以第二行开始读取
                    Row row = sheet.getRow(j); // 获取表格行
                    Running running = new Running();
                    row.getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC); // 将该单元格获取出来的值设为double类型
                    running.setId((int)row.getCell(0).getNumericCellValue()); // 获取表格单元格并给Position设置值
                    row.getCell(8).setCellType(Cell.CELL_TYPE_NUMERIC);
                    running.setAccx((int)row.getCell(8).getNumericCellValue());
                    row.getCell(9).setCellType(Cell.CELL_TYPE_NUMERIC);
                    running.setAccy((int)row.getCell(9).getNumericCellValue());
                    row.getCell(10).setCellType(Cell.CELL_TYPE_NUMERIC);
                    running.setAccz((int)row.getCell(10).getNumericCellValue());

                    row.getCell(11).setCellType(Cell.CELL_TYPE_NUMERIC);
                    running.setGyroscopex((int)row.getCell(11).getNumericCellValue());
                    row.getCell(12).setCellType(Cell.CELL_TYPE_NUMERIC);
                    running.setGyroscopey((int)row.getCell(12).getNumericCellValue());
                    row.getCell(13).setCellType(Cell.CELL_TYPE_NUMERIC);
                    running.setGyroscopez((int)row.getCell(13).getNumericCellValue());

                    row.getCell(14).setCellType(Cell.CELL_TYPE_NUMERIC);
                    running.setStay((int)row.getCell(14).getNumericCellValue());
                    row.getCell(17).setCellType(Cell.CELL_TYPE_STRING);
                    running.setTimestamp(row.getCell(17).getStringCellValue());
                    row.getCell(20).setCellType(Cell.CELL_TYPE_NUMERIC);
                    running.setBatch((int)row.getCell(20).getNumericCellValue());

                    runningList.add(running);
                }
            }
        }
        return runningList;

    }
}
