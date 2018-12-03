package ProductsRealization.ProductsRealization;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JTextField;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.awt.Desktop;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Replacement {
	
	public void textReplaceInStrings(XWPFDocument document, String find_text, JTextField textfield)
	{
		for (XWPFParagraph p : document.getParagraphs()) {
		    List<XWPFRun> runs = p.getRuns();
		    if (runs != null) {
		        for (XWPFRun r : runs) {
		            String text = r.getText(0);
		            if (text != null && text.contains(find_text)) {
		                text = text.replace(find_text, textfield.getText());
		                r.setText(text, 0);
		            }
		        }
		    }
		}
	}
	
	public void textReplaceInTable (XWPFDocument document, String find_text, JTextField textfield)
	{
		for (XWPFTable tbl : document.getTables()) {
			   for (XWPFTableRow row : tbl.getRows()) {
			      for (XWPFTableCell cell : row.getTableCells()) {
			         for (XWPFParagraph p : cell.getParagraphs()) {
			            for (XWPFRun r : p.getRuns()) {
			              String text = r.getText(0);
			              if (text != null && text.contains(find_text)) {
			                text = text.replace(find_text, textfield.getText());
			                r.setText(text,0);
			              }
			            }
			         }
			      }
			   }
			}
	}
	
	public void textReplaceInTableForCombo (XWPFDocument document, String find_text, JComboBox combobox)
	{
		for (XWPFTable tbl : document.getTables()) {
			   for (XWPFTableRow row : tbl.getRows()) {
			      for (XWPFTableCell cell : row.getTableCells()) {
			         for (XWPFParagraph p : cell.getParagraphs()) {
			            for (XWPFRun r : p.getRuns()) {
			              String text = r.getText(0);
			              if (text != null && text.contains(find_text)) {
			                text = text.replace(find_text, (String)combobox.getSelectedItem());
			                r.setText(text,0);
			              }
			            }
			         }
			      }
			   }
			}
	}
	
	public void textReplaceInTableForVariables (XWPFDocument document, String find_text, String variable)
	{
		for (XWPFTable tbl : document.getTables()) {
			   for (XWPFTableRow row : tbl.getRows()) {
			      for (XWPFTableCell cell : row.getTableCells()) {
			         for (XWPFParagraph p : cell.getParagraphs()) {
			            for (XWPFRun r : p.getRuns()) {
			              String text = r.getText(0);
			              if (text != null && text.contains(find_text)) {
			                text = text.replace(find_text, variable);
			                r.setText(text,0);
			              }
			            }
			         }
			      }
			   }
			}
	}

}
