/*
 * package com.example.interestcalculatorpostgres.utils;
 * 
 * import java.io.IOException; import java.util.Date; import java.util.List;
 * import javax.servlet.ServletOutputStream; import
 * javax.servlet.http.HttpServletResponse; import
 * org.apache.poi.ss.usermodel.CellStyle; import
 * org.apache.poi.xssf.usermodel.XSSFCell; import
 * org.apache.poi.xssf.usermodel.XSSFFont; import
 * org.apache.poi.xssf.usermodel.XSSFRow; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook; import
 * com.example.interestcalculatorpostgres.dao.TotalInterest;
 * 
 * public class TotalInterestExcelExporter { private XSSFWorkbook workbook;
 * private XSSFSheet sheet; private TotalInterest ti;
 * 
 * public TotalInterestExcelExporter(TotalInterest ti) { this.ti = ti; workbook
 * = new XSSFWorkbook(); }
 * 
 * private void writeHeaderLine() { sheet =
 * workbook.createSheet("Loan Details"); XSSFRow row = sheet.createRow(0);
 * CellStyle style = workbook.createCellStyle(); XSSFFont font =
 * workbook.createFont(); font.setBold(true); font.setFontHeight(16);
 * style.setFont(font); createCell(row, 0, "total Interest", style);
 * createCell(row, 1, "total Amount",style); }
 * 
 * private void createCell(XSSFRow row, int columnCount, Object value, CellStyle
 * style) { sheet.autoSizeColumn(columnCount); XSSFCell cell =
 * row.createCell(columnCount); if (value instanceof Integer) {
 * cell.setCellValue((Integer) value); } else if (value instanceof Date) {
 * cell.setCellValue((Date) value); }else { cell.setCellValue((String) value); }
 * cell.setCellStyle(style); }
 * 
 * private void writeDataLines() { int rowCount = 1; CellStyle style =
 * workbook.createCellStyle(); XSSFFont font = workbook.createFont();
 * font.setFontHeight(14); style.setFont(font); for() { XSSFRow row =
 * sheet.createRow(rowCount++); int columnCount = 0; createCell(row,
 * columnCount++, ti.totalInterest(), style); createCell(row, columnCount++,
 * ti.totalAmount(), style); } }
 * 
 * public void export(HttpServletResponse response) throws IOException {
 * writeHeaderLine(); writeDataLines(); ServletOutputStream outputStream =
 * response.getOutputStream(); workbook.write(outputStream); workbook.close();
 * outputStream.close(); } }
 */