package giang.hust.qlsv.utils;

import giang.hust.qlsv.entity.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class FileUtils {

    public static void writeFile(String fileName, List<Student> list) {
        try {
            Workbook workbook = new XSSFWorkbook();

            //  Create new sheet
            Sheet sh = workbook.createSheet("Students");
            String[] columHeadings = {"STT", "Name", "ID", "Age", "CPA", "Address"};

//            Font headFont = workbook.createFont();
//            headFont.setBold(true);
//            headFont.setFontHeight((short)12);
//            headFont.setColor(IndexedColors.BLACK.index);

//            CellStyle headerStyle = workbook.createCellStyle();
//            headerStyle.setFont(headFont);
//            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

            Row headerRow = sh.createRow(0);
            for (int i = 0; i < columHeadings.length; i++){
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columHeadings[i]);
//                cell.setCellStyle(headerStyle);
            }

            CreationHelper creationHelper = workbook.getCreationHelper();
            int rowNum = 1;
            for (Student i : list){
                Row row = sh.createRow(rowNum++);
                row.createCell(0).setCellValue(i.getId());
                row.createCell(1).setCellValue(i.getName());
                row.createCell(2).setCellValue(i.getMSSV());
                row.createCell(3).setCellValue(i.getAge());
                row.createCell(4).setCellValue(i.getCpa());
                row.createCell(5).setCellValue(i.getAddress());
            }

//            for (int i = 0; i < columHeadings.length; i++){
//                sh.autoSizeColumn(i);
//            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
            System.out.println("Completed");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName, Class<?> clazz) {

    }

}
