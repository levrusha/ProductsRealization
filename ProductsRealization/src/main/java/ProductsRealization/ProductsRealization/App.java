package ProductsRealization.ProductsRealization;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.awt.Desktop;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class App 
{
	public static void main(String[] args) throws Exception {
		 
		try {
			
		XWPFDocument document = new XWPFDocument(OPCPackage.open("f:/Realization/nakladnaya_template.docx"));
		
		String find_text_massiv[] = {"word0","word1"};
		
		
		//textReplaceInStrings(document);
		//textReplaceInTable(document);
		
		FileOutputStream out = new FileOutputStream("f:/Realization/nakladnaya_new.docx");
		document.write(out);
		out.close();
		
		if (Desktop.isDesktopSupported()) {
		       Desktop.getDesktop().open(new File("f:/Realization/nakladnaya_new.docx"));
		}
	}catch (Exception e) {
		System.out.println(e);
	}
		System.out.println("done");
				
	}
	
	public static void textReplaceInStrings(XWPFDocument document, String find_text, String insert_text)
	{
		for (XWPFParagraph p : document.getParagraphs()) {
		    List<XWPFRun> runs = p.getRuns();
		    if (runs != null) {
		        for (XWPFRun r : runs) {
		            String text = r.getText(0);
		            if (text != null && text.contains(find_text)) {
		                text = text.replace(find_text, insert_text);
		                r.setText(text, 0);
		            }
		        }
		    }
		}
	}
	
	public static void textReplaceInTable (XWPFDocument document, String find_text, String insert_text)
	{
		for (XWPFTable tbl : document.getTables()) {
			   for (XWPFTableRow row : tbl.getRows()) {
			      for (XWPFTableCell cell : row.getTableCells()) {
			         for (XWPFParagraph p : cell.getParagraphs()) {
			            for (XWPFRun r : p.getRuns()) {
			              String text = r.getText(0);
			              if (text != null && text.contains(find_text)) {
			                text = text.replace(find_text, insert_text);
			                r.setText(text,0);
			              }
			            }
			         }
			      }
			   }
			}
	}
	
}

