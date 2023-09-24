package com.joe.sys.utils;

import com.joe.sys.entity.Truth;
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
public class ImportExcelUtils3 {
    // 将表格中的数据添加到List集合中
    public List<Truth> upload(String fileName, InputStream is) throws Exception{
        Workbook workbook = new XSSFWorkbook(is);
        List<Truth> truthList = new ArrayList<>();
        int number = workbook.getNumberOfSheets(); // 获取sheet值
        for (int i = 0; i < number; i++) {
            Sheet sheet = workbook.getSheetAt(i); // 获取表格页码
            if (sheet != null){
                int rowNum = sheet.getLastRowNum(); // 获取该页表共有多少行
                for (int j = 1; j <= rowNum; j++) {  // 一般来说第一行是标题,所以第二行开始读取
                    Row row = sheet.getRow(j); // 获取表格行
                    Truth truth = new Truth();
                    row.getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC); // 将该单元格获取出来的值设为double类型
                    truth.setStep((int)row.getCell(0).getNumericCellValue()); // 获取表格单元格并给Truth设置值
                    row.getCell(1).setCellType(Cell.CELL_TYPE_NUMERIC);
                    truth.setXt(row.getCell(1).getNumericCellValue());
                    row.getCell(2).setCellType(Cell.CELL_TYPE_NUMERIC);
                    truth.setYt(row.getCell(2).getNumericCellValue());

                    truthList.add(truth);
                }
            }
        }
        return truthList;
    }
}
