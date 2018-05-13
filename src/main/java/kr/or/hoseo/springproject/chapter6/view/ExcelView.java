package kr.or.hoseo.springproject.chapter6.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import kr.or.hoseo.springproject.chapter6.vo.Music;

public class ExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String fileName = String.format("music-%s.xls",
				DateTimeFormatter.ofPattern("yyyy-MM-dd hhmm").format(LocalDateTime.now()));
		
		List<Music> list = (List<Music>)model.get("list");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		Sheet sheet = workbook.createSheet("뮤우직 순위");
		
		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerStyle.setAlignment(HorizontalAlignment.CENTER);
		
		Row headerRow = sheet.createRow(0);
		String[] headers = {"제목", "아티스트"};
		for(int i = 0 ; i < 2 ; i ++) {
			Cell headerCell = headerRow.createCell(i);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue(headers[i]);
		}
		
		
		int idx = 1;
		for(Music music : list) {
			Row row = sheet.createRow(idx++);
			row.createCell(0).setCellValue(music.getTitle());
			row.createCell(1).setCellValue(music.getArtist());
		}
	}

}
