package com.joe.sys.utils;

import com.joe.sys.entity.Result;
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
public class ImportExcelUtils4 {

    public List<Result> upload(InputStream is) throws Exception{
        Workbook workbook = new XSSFWorkbook(is);
        List<Result> resultList = new ArrayList<>();
        int number = workbook.getNumberOfSheets(); // 获取sheet值
        for (int i = 0; i < number; i++) {
            Sheet sheet = workbook.getSheetAt(i); // 获取表格页码
            if (sheet != null){
                int rowNum = sheet.getLastRowNum(); // 获取该页表共有多少行
                for (int j = 1; j <= rowNum; j++) {  // 一般来说第一行是标题,所以第二行开始读取
                    Row row = sheet.getRow(j); // 获取表格行
                    Result result = new Result();
                    row.getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC); // 将该单元格获取出来的值设为double类型
                    result.setXr(row.getCell(0).getNumericCellValue()); // 获取表格单元格并给Result设置值
                    row.getCell(1).setCellType(Cell.CELL_TYPE_NUMERIC);
                    result.setYr(row.getCell(1).getNumericCellValue());
                    row.getCell(2).setCellType(Cell.CELL_TYPE_NUMERIC);
                    result.setArg(row.getCell(2).getNumericCellValue());
                    row.getCell(3).setCellType(Cell.CELL_TYPE_NUMERIC);
                    result.setError(row.getCell(3).getNumericCellValue());
                    row.getCell(4).setCellType(Cell.CELL_TYPE_NUMERIC);
                    result.setCdfx(row.getCell(4).getNumericCellValue());
                    row.getCell(5).setCellType(Cell.CELL_TYPE_NUMERIC);
                    result.setCdfy(row.getCell(5).getNumericCellValue());
                    row.getCell(6).setCellType(Cell.CELL_TYPE_NUMERIC);
                    result.setPerror(row.getCell(6).getNumericCellValue());

                    resultList.add(result);
                }
            }
        }
        return resultList;

    }
}
