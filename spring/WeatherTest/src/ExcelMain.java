import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMain {

	public static void main(String[] args) {
		ZipSecureFile.setMinInflateRatio(0);
		try {
			FileInputStream fis = new FileInputStream("position.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);//엑셀 시트 번호
			
			System.out.println("전체 행 개수 : " + sheet.getPhysicalNumberOfRows());
			System.out.println("해당 라인의 컬럼 수 : "+sheet.getRow(0).getPhysicalNumberOfCells());
			System.out.println("4행 5열에 있는 셀값 : "+sheet.getRow(3).getCell(4));
			
			for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
				String row = "";
				for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++) {
					row += sheet.getRow(i).getCell(j) + "\t";
				}
				System.out.println(row);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
