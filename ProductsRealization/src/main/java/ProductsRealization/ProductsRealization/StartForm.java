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

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartForm extends JFrame {

	private JPanel contentPane;
	private JTextField Nomer_dogovora_textField;
	private JTextField Date_dogovor_textField;
	private JTextField Name_prodavec_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartForm frame = new StartForm();
					frame.setVisible(true);
					}
				 catch (Exception e) {
					e.printStackTrace();
				 	}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public StartForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Договор купли-продажи");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label.setBounds(373, 11, 203, 14);
		contentPane.add(label);
		
		Nomer_dogovora_textField = new JTextField();
		Nomer_dogovora_textField.setBounds(307, 41, 86, 20);
		contentPane.add(Nomer_dogovora_textField);
		Nomer_dogovora_textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Номер договора");
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_1.setBounds(10, 42, 203, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Дата заключения договора");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_2.setBounds(10, 75, 203, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Название организации-продавца");
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_3.setBounds(10, 109, 237, 14);
		contentPane.add(label_3);
		
		Date_dogovor_textField = new JTextField();
		Date_dogovor_textField.setBounds(307, 72, 86, 20);
		contentPane.add(Date_dogovor_textField);
		Date_dogovor_textField.setColumns(10);
		
		Name_prodavec_textField = new JTextField();
		Name_prodavec_textField.setBounds(307, 103, 86, 20);
		contentPane.add(Name_prodavec_textField);
		Name_prodavec_textField.setColumns(10);
		
		JButton generate_Button = new JButton("Сформировать накладную");
		generate_Button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				XWPFDocument document = new XWPFDocument(OPCPackage.open("f:/Realization/nakladnaya_template.docx"));
				FileOutputStream out = new FileOutputStream("f:/Realization/nakladnaya_new.docx");
				Replacement replacement = new Replacement();
				replacement.textReplaceInStrings(document, "Nomer_dogovora" , Nomer_dogovora_textField);
				replacement.textReplaceInTable(document, "Nomer_dogovora" , Nomer_dogovora_textField);
				document.write(out);
				out.close();
				if (Desktop.isDesktopSupported()) {
					   Desktop.getDesktop().open(new File("f:/Realization/nakladnaya_new.docx"));
						}
				}
				catch (Exception e1) {
						System.out.println(e1);
				}
			}
		});
		generate_Button.setBounds(389, 163, 169, 33);
		contentPane.add(generate_Button);
	}
}
