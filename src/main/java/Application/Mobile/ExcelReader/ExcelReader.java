package Application.Mobile.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	
	public ExcelReader(String path) throws IOException
	{
		this.path=path;
		fis=new FileInputStream(path);
		workbook= new XSSFWorkbook(fis);
		
	}

	@SuppressWarnings("unused")
	public String getCellData(String sheetName,String colName,int rowNum)
	{
		int colNum=0;
		int index=workbook.getSheetIndex(sheetName);
		sheet=workbook.getSheetAt(index);
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().equals(colName))
			{
			colNum=i;
			break;	
			}
		}
		row=sheet.getRow(rowNum-1);
		
		cell=row.getCell(colNum);
		
		if(cell.getCellType()==cell.CELL_TYPE_STRING)
		{
			return cell.getStringCellValue();
		}
		else if(cell.getCellType()==cell.CELL_TYPE_BLANK)
		{
			return ""; 
		}
		
		
		return null;
		
	}
}
