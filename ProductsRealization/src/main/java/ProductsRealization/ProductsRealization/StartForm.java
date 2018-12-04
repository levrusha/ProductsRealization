package ProductsRealization.ProductsRealization;
import ProductsRealization.ProductsRealization.Replacement;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class StartForm extends JFrame {

	private JPanel contentPane;
	private JTextField Nomer_dogovora_textField;
	private JTextField Date_dogovor_textField;
	private JTextField Name_pokupatel_textField;
	private JTextField Address_pokupatel_textField;
	private JTextField Phone_pokupatel_textField;
	private JTextField Account_pokupatel_textField;
	private JTextField BIK_pokupatel_textField;
	private JTextField OKPO_pokupatel_textField;
	private JTextField kol1_textField;
	private JTextField kol2_textField;
	private JTextField kol3_textField;
	private JTextField kol4_textField;
	private JTextField kol5_textField;
	private JTextField price_tov1_textField;
	private JTextField price_tov2_textField;
	private JTextField price_tov3_textField;
	private JTextField price_tov4_textField;
	private JTextField price_tov5_textField;
	private JComboBox<String> name_tov1_comboBox;
	private JComboBox<String> name_tov2_comboBox;
	private JComboBox<String> name_tov3_comboBox;
	private JComboBox<String> name_tov4_comboBox;
	private JComboBox<String> name_tov5_comboBox;
	private double Kolichestvo = 0;
	private double Total_NDS = 0;
	private double Total_No_NDS = 0;
	private double Total_With_NDS = 0;

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
		setBounds(100, 100, 952, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Договор купли-продажи");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label.setBounds(373, 11, 203, 25);
		contentPane.add(label);
		
		Nomer_dogovora_textField = new JTextField();
		Nomer_dogovora_textField.setText("12");
		Nomer_dogovora_textField.setBounds(223, 42, 86, 20);
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
		
		JLabel label_3 = new JLabel("Название");
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_3.setBounds(10, 134, 71, 14);
		contentPane.add(label_3);
		
		Date_dogovor_textField = new JTextField();
		Date_dogovor_textField.setText("05.10.18");
		Date_dogovor_textField.setBounds(223, 73, 86, 20);
		contentPane.add(Date_dogovor_textField);
		Date_dogovor_textField.setColumns(10);
		
		Name_pokupatel_textField = new JTextField();
		Name_pokupatel_textField.setText("\"Кофетайм\"");
		Name_pokupatel_textField.setBounds(141, 133, 296, 20);
		contentPane.add(Name_pokupatel_textField);
		Name_pokupatel_textField.setColumns(10);
		
		JButton generate_Button = new JButton("Сформировать накладную");
		generate_Button.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		generate_Button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				XWPFDocument document = new XWPFDocument(OPCPackage.open("f:/Realization/torg12_template.docx"));
				FileOutputStream out = new FileOutputStream("f:/Realization/torg12_new.docx");
				Replacement replacement = new Replacement();
				replacement.textReplaceInTable(document, "Name_pokupatel", Name_pokupatel_textField);
				replacement.textReplaceInTable(document, "Address_pokupatel", Address_pokupatel_textField);
				replacement.textReplaceInTable(document, "Phone_pokupatel", Phone_pokupatel_textField);
				replacement.textReplaceInTable(document, "Cheking_account_pokupatel", Account_pokupatel_textField);
				replacement.textReplaceInTable(document, "BIK_pokupatel", BIK_pokupatel_textField);
				replacement.textReplaceInTable(document, "Nomer/n_/ndogovora" , Nomer_dogovora_textField);
				replacement.textReplaceInTable(document, "Date_dogovor" , Date_dogovor_textField);
				replacement.textReplaceInTable(document, "OKPO_Pok" , OKPO_pokupatel_textField);
				replacement.textReplaceInTableForCombo(document, "Name_tovar_1" , name_tov1_comboBox);
				replacement.textReplaceInTableForCombo(document, "Name_tovar_2" , name_tov2_comboBox);
				replacement.textReplaceInTableForCombo(document, "Name_tovar_3" , name_tov3_comboBox);
				replacement.textReplaceInTableForCombo(document, "Name_tovar_4" , name_tov4_comboBox);
				replacement.textReplaceInTableForCombo(document, "Name_tovar_5" , name_tov4_comboBox);
				replacement.textReplaceInTable(document, "Kol_tov_1" , kol1_textField);
				replacement.textReplaceInTable(document, "Kol_tov_2" , kol2_textField);
				replacement.textReplaceInTable(document, "Kol_tov_3" , kol3_textField);
				replacement.textReplaceInTable(document, "Kol_tov_4" , kol4_textField);
				replacement.textReplaceInTable(document, "Kol_tov_5" , kol5_textField);
				replacement.textReplaceInTable(document, "Price_tov_1" , price_tov1_textField);
				replacement.textReplaceInTable(document, "Price_tov_2" , price_tov2_textField);
				replacement.textReplaceInTable(document, "Price_tov_3" , price_tov3_textField);
				replacement.textReplaceInTable(document, "Price_tov_4" , price_tov4_textField);
				replacement.textReplaceInTable(document, "Price_tov_5" , price_tov5_textField);
				Calculations calc = new Calculations();
				
				
				if (name_tov1_comboBox.getSelectedItem()!=" ") {
					
					Kolichestvo += Double.parseDouble(kol1_textField.getText());
					
					String summ_no_nds = "0";
					replacement.textReplaceInTableForVariables(document, "T1NONDS" ,calc.calculateEachSumm(kol1_textField, price_tov1_textField, summ_no_nds));
					Total_No_NDS += Double.parseDouble(calc.calculateEachSumm(kol1_textField, price_tov1_textField, summ_no_nds));
					
					String nds = "0";
					replacement.textReplaceInTableForVariables(document, "NDS_tov_1" , calc.calculateEachNDS(kol1_textField, price_tov1_textField, nds));
					Total_NDS += Double.parseDouble(calc.calculateEachNDS(kol1_textField, price_tov1_textField, nds));
					
					String summ_with_nds = "0";
					replacement.textReplaceInTableForVariables(document, "Total_tov_1+NDS" ,calc.calculateEachSummWithNDS(kol1_textField, price_tov1_textField, summ_with_nds));
					Total_With_NDS += Double.parseDouble(calc.calculateEachSummWithNDS(kol1_textField, price_tov1_textField, summ_with_nds));
					
					} else {
						String summ_no_nds=" ";
						replacement.textReplaceInTableForVariables(document, "T1NONDS" ,summ_no_nds);
						String nds = " ";
						replacement.textReplaceInTableForVariables(document, "NDS_tov_1" ,nds);
						String summ_with_nds = " ";
						replacement.textReplaceInTableForVariables(document, "Total_tov_1+NDS" ,summ_with_nds);
					}
				
				if (name_tov2_comboBox.getSelectedItem()!=" ") {
					
					Kolichestvo += Double.parseDouble(kol2_textField.getText());
					
					String summ_no_nds = "0";
					replacement.textReplaceInTableForVariables(document, "T2NONDS" ,calc.calculateEachSumm(kol2_textField, price_tov2_textField, summ_no_nds));
					Total_No_NDS += Double.parseDouble(calc.calculateEachSumm(kol2_textField, price_tov2_textField, summ_no_nds));
					
					String nds = "0";
					replacement.textReplaceInTableForVariables(document, "NDS_tov_2" , calc.calculateEachNDS(kol2_textField, price_tov2_textField, nds));
					Total_NDS += Double.parseDouble(calc.calculateEachNDS(kol2_textField, price_tov2_textField, nds));
					
					String summ_with_nds = "0";
					replacement.textReplaceInTableForVariables(document, "Total_tov_2+NDS" ,calc.calculateEachSummWithNDS(kol2_textField, price_tov2_textField, summ_with_nds));
					Total_With_NDS += Double.parseDouble(calc.calculateEachSummWithNDS(kol2_textField, price_tov2_textField, summ_with_nds));
					
					} else {
						String summ_no_nds=" ";
						replacement.textReplaceInTableForVariables(document, "T2NONDS" ,summ_no_nds);
						String nds = " ";
						replacement.textReplaceInTableForVariables(document, "NDS_tov_2" ,nds);
						String summ_with_nds = " ";
						replacement.textReplaceInTableForVariables(document, "Total_tov_2+NDS" ,summ_with_nds);
					}
				
				if (name_tov3_comboBox.getSelectedItem()!=" ") {
					
					Kolichestvo += Double.parseDouble(kol3_textField.getText());
					
					String summ_no_nds = "0";
					replacement.textReplaceInTableForVariables(document, "T3NONDS" ,calc.calculateEachSumm(kol3_textField, price_tov3_textField, summ_no_nds));
					Total_No_NDS += Double.parseDouble(calc.calculateEachSumm(kol3_textField, price_tov3_textField, summ_no_nds));
					
					String nds = "0";
					replacement.textReplaceInTableForVariables(document, "NDS_tov_3" , calc.calculateEachNDS(kol3_textField, price_tov3_textField, nds));
					Total_NDS += Double.parseDouble(calc.calculateEachNDS(kol3_textField, price_tov3_textField, nds));
					
					String summ_with_nds = "0";
					replacement.textReplaceInTableForVariables(document, "Total_tov_3+NDS" ,calc.calculateEachSummWithNDS(kol3_textField, price_tov3_textField, summ_with_nds));
					Total_With_NDS += Double.parseDouble(calc.calculateEachSummWithNDS(kol3_textField, price_tov3_textField, summ_with_nds));
					
					} else {
						String summ_no_nds=" ";
						replacement.textReplaceInTableForVariables(document, "T3NONDS" ,summ_no_nds);
						String nds = " ";
						replacement.textReplaceInTableForVariables(document, "NDS_tov_3" ,nds);
						String summ_with_nds = " ";
						replacement.textReplaceInTableForVariables(document, "Total_tov_3+NDS" ,summ_with_nds);
					}
				
				if (name_tov4_comboBox.getSelectedItem()!=" ") {
					
					Kolichestvo += Double.parseDouble(kol4_textField.getText());
					
					String summ_no_nds = "0";
					replacement.textReplaceInTableForVariables(document, "T4NONDS" ,calc.calculateEachSumm(kol4_textField, price_tov4_textField, summ_no_nds));
					Total_No_NDS += Double.parseDouble(calc.calculateEachSumm(kol4_textField, price_tov4_textField, summ_no_nds));
					
					String nds = "0";
					replacement.textReplaceInTableForVariables(document, "NDS_tov_4" , calc.calculateEachNDS(kol4_textField, price_tov4_textField, nds));
					Total_NDS += Double.parseDouble(calc.calculateEachNDS(kol4_textField, price_tov4_textField, nds));
					
					String summ_with_nds = "0";
					replacement.textReplaceInTableForVariables(document, "Total_tov_4+NDS" ,calc.calculateEachSummWithNDS(kol4_textField, price_tov4_textField, summ_with_nds));
					Total_With_NDS += Double.parseDouble(calc.calculateEachSummWithNDS(kol4_textField, price_tov4_textField, summ_with_nds));
					
					} else {
						String summ_no_nds=" ";
						replacement.textReplaceInTableForVariables(document, "T4NONDS" ,summ_no_nds);
						String nds = " ";
						replacement.textReplaceInTableForVariables(document, "NDS_tov_4" ,nds);
						String summ_with_nds = " ";
						replacement.textReplaceInTableForVariables(document, "Total_tov_4+NDS" ,summ_with_nds);
					}
				
				if (name_tov5_comboBox.getSelectedItem()!=" ") {
					
					Kolichestvo += Double.parseDouble(kol5_textField.getText());
					
					String summ_no_nds = "0";
					replacement.textReplaceInTableForVariables(document, "T5NONDS" ,calc.calculateEachSumm(kol5_textField, price_tov5_textField, summ_no_nds));
					Total_No_NDS += Double.parseDouble(calc.calculateEachSumm(kol5_textField, price_tov5_textField, summ_no_nds));
					
					String nds = "0";
					replacement.textReplaceInTableForVariables(document, "NDS_tov_5" , calc.calculateEachNDS(kol5_textField, price_tov5_textField, nds));
					Total_NDS += Double.parseDouble(calc.calculateEachNDS(kol5_textField, price_tov5_textField, nds));
					
					String summ_with_nds = "0";
					replacement.textReplaceInTableForVariables(document, "Total_tov_5+NDS" ,calc.calculateEachSummWithNDS(kol5_textField, price_tov5_textField, summ_with_nds));
					Total_With_NDS += Double.parseDouble(calc.calculateEachSummWithNDS(kol5_textField, price_tov5_textField, summ_with_nds));
					
					} else {
						String summ_no_nds=" ";
						replacement.textReplaceInTableForVariables(document, "T5NONDS" ,summ_no_nds);
						String nds = " ";
						replacement.textReplaceInTableForVariables(document, "NDS_tov_5" ,nds);
						String summ_with_nds = " ";
						replacement.textReplaceInTableForVariables(document, "Total_tov_5+NDS" ,summ_with_nds);
					}
				
				replacement.textReplaceInTableForVariables(document, "СуммаБезНДС" ,Double.toString(Total_No_NDS));
				replacement.textReplaceInTableForVariables(document, "Kolvo" ,Double.toString(Kolichestvo));
				replacement.textReplaceInTableForVariables(document, "СуммаНДС" ,Double.toString(Total_NDS));
				replacement.textReplaceInTableForVariables(document, "ОбщаяСумма" ,Double.toString(Total_With_NDS));
				
				document.write(out);
				out.close();
				if (Desktop.isDesktopSupported()) {
					   Desktop.getDesktop().open(new File("f:/Realization/torg12_new.docx"));
						}
				}
				catch (Exception e1) {
						System.out.println(e1);
				}
				
			}
		});
		generate_Button.setBounds(373, 338, 235, 33);
		contentPane.add(generate_Button);
				
		Address_pokupatel_textField = new JTextField();
		Address_pokupatel_textField.setText("г. Уфа, ул. Космонавтов, 15");
		Address_pokupatel_textField.setBounds(141, 164, 296, 20);
		contentPane.add(Address_pokupatel_textField);
		Address_pokupatel_textField.setColumns(10);
		
		JLabel label_4 = new JLabel("Адрес");
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_4.setBounds(10, 165, 51, 14);
		contentPane.add(label_4);
		
		Phone_pokupatel_textField = new JTextField();
		Phone_pokupatel_textField.setText("89176677888");
		Phone_pokupatel_textField.setColumns(10);
		Phone_pokupatel_textField.setBounds(141, 195, 296, 20);
		contentPane.add(Phone_pokupatel_textField);
		
		JLabel label_5 = new JLabel("Телефон");
		label_5.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_5.setBounds(10, 196, 65, 14);
		contentPane.add(label_5);
		
		Account_pokupatel_textField = new JTextField();
		Account_pokupatel_textField.setText("12345123451234512345");
		Account_pokupatel_textField.setColumns(10);
		Account_pokupatel_textField.setBounds(141, 226, 296, 20);
		contentPane.add(Account_pokupatel_textField);
		
		JLabel label_6 = new JLabel("Рассчетный счет");
		label_6.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_6.setBounds(10, 227, 114, 14);
		contentPane.add(label_6);
		
		BIK_pokupatel_textField = new JTextField();
		BIK_pokupatel_textField.setText("888898898");
		BIK_pokupatel_textField.setColumns(10);
		BIK_pokupatel_textField.setBounds(141, 257, 296, 20);
		contentPane.add(BIK_pokupatel_textField);
		
		JLabel label_7 = new JLabel("БИК");
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_7.setBounds(10, 258, 36, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Товар 1");
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_8.setBounds(478, 133, 58, 16);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Товар 2");
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_9.setBounds(478, 164, 58, 16);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Товар 3");
		label_10.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_10.setBounds(478, 195, 58, 16);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("Товар 4");
		label_11.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_11.setBounds(478, 226, 58, 16);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Товар 5");
		label_12.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_12.setBounds(478, 257, 58, 16);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Организация-покупатель");
		label_13.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_13.setBounds(113, 100, 203, 23);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("Заказ");
		label_14.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_14.setBounds(656, 100, 51, 23);
		contentPane.add(label_14);
		
		JLabel lblOkpo = new JLabel("ОКПО");
		lblOkpo.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblOkpo.setBounds(10, 290, 51, 14);
		contentPane.add(lblOkpo);
		
		OKPO_pokupatel_textField = new JTextField();
		OKPO_pokupatel_textField.setText("5565643521");
		OKPO_pokupatel_textField.setColumns(10);
		OKPO_pokupatel_textField.setBounds(141, 288, 296, 20);
		contentPane.add(OKPO_pokupatel_textField);
		
		name_tov1_comboBox = new JComboBox<String>();
		name_tov1_comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "Диван Monro", "Диван Kernik", "Диван Grog", "Кресло Voyage", "Кресло Merry"}));
		name_tov1_comboBox.setBounds(546, 133, 114, 20);
		contentPane.add(name_tov1_comboBox);
		
		name_tov2_comboBox = new JComboBox<String>();
		name_tov2_comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "Диван Monro", "Диван Kernik", "Диван Grog", "Кресло Voyage", "Кресло Merry"}));
		name_tov2_comboBox.setBounds(546, 164, 114, 20);
		contentPane.add(name_tov2_comboBox);
		
		name_tov3_comboBox = new JComboBox<String>();
		name_tov3_comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "Диван Monro", "Диван Kernik", "Диван Grog", "Кресло Voyage", "Кресло Merry"}));
		name_tov3_comboBox.setBounds(546, 195, 114, 20);
		contentPane.add(name_tov3_comboBox);
		
		name_tov4_comboBox = new JComboBox<String>();
		name_tov4_comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "Диван Monro", "Диван Kernik", "Диван Grog", "Кресло Voyage", "Кресло Merry"}));
		name_tov4_comboBox.setBounds(546, 226, 114, 20);
		contentPane.add(name_tov4_comboBox);
		
		name_tov5_comboBox = new JComboBox<String>();
		name_tov5_comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "Диван Monro", "Диван Kernik", "Диван Grog", "Кресло Voyage", "Кресло Merry"}));
		name_tov5_comboBox.setBounds(546, 257, 114, 20);
		contentPane.add(name_tov5_comboBox);
		
		kol1_textField = new JTextField();
		kol1_textField.setColumns(10);
		kol1_textField.setBounds(671, 133, 36, 20);
		contentPane.add(kol1_textField);
		
		kol2_textField = new JTextField();
		kol2_textField.setColumns(10);
		kol2_textField.setBounds(671, 164, 36, 20);
		contentPane.add(kol2_textField);
		
		kol3_textField = new JTextField();
		kol3_textField.setColumns(10);
		kol3_textField.setBounds(670, 198, 36, 20);
		contentPane.add(kol3_textField);
		
		kol4_textField = new JTextField();
		kol4_textField.setColumns(10);
		kol4_textField.setBounds(671, 226, 36, 20);
		contentPane.add(kol4_textField);
		
		kol5_textField = new JTextField();
		kol5_textField.setColumns(10);
		kol5_textField.setBounds(670, 257, 36, 20);
		contentPane.add(kol5_textField);
		
		JLabel label_20 = new JLabel("шт. по цене");
		label_20.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_20.setBounds(717, 133, 86, 16);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel("шт. по цене");
		label_21.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_21.setBounds(717, 164, 86, 16);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel("шт. по цене");
		label_22.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_22.setBounds(716, 195, 87, 16);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel("шт. по цене");
		label_23.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_23.setBounds(717, 226, 86, 16);
		contentPane.add(label_23);
		
		JLabel label_24 = new JLabel("шт. по цене");
		label_24.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_24.setBounds(716, 257, 86, 16);
		contentPane.add(label_24);
		
		price_tov1_textField = new JTextField();
		price_tov1_textField.setColumns(10);
		price_tov1_textField.setBounds(805, 133, 71, 20);
		contentPane.add(price_tov1_textField);
		
		price_tov2_textField = new JTextField();
		price_tov2_textField.setColumns(10);
		price_tov2_textField.setBounds(805, 164, 71, 20);
		contentPane.add(price_tov2_textField);
		
		price_tov3_textField = new JTextField();
		price_tov3_textField.setColumns(10);
		price_tov3_textField.setBounds(805, 195, 71, 20);
		contentPane.add(price_tov3_textField);
		
		price_tov4_textField = new JTextField();
		price_tov4_textField.setColumns(10);
		price_tov4_textField.setBounds(805, 226, 71, 20);
		contentPane.add(price_tov4_textField);
		
		price_tov5_textField = new JTextField();
		price_tov5_textField.setColumns(10);
		price_tov5_textField.setBounds(805, 257, 71, 20);
		contentPane.add(price_tov5_textField);
		
		JLabel label_15 = new JLabel("руб.");
		label_15.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_15.setBounds(886, 133, 36, 16);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("руб.");
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_16.setBounds(886, 167, 36, 16);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("руб.");
		label_17.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_17.setBounds(886, 198, 36, 16);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("руб.");
		label_18.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_18.setBounds(886, 229, 36, 16);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel("руб.");
		label_19.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label_19.setBounds(886, 260, 36, 16);
		contentPane.add(label_19);
	}
}
