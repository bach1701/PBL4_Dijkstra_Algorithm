package Djistra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField tfnguon;
	private JTextField tfduongdi;
	private JTextField tfkhoangcach;
	private JTextField tfdich;
	public static int _algoWorkers;
	public static int _algoWorkert;
	public static View MainFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame = new View();
					MainFrame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel alo = new JPanel();
		alo.setBounds(22, 25, 141, 97);
		contentPane.add(alo);
		alo.setLayout(null);
		
		tfnguon = new JTextField();
		tfnguon.setBounds(16, 29, 36, 23);
		alo.add(tfnguon);
		tfnguon.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nguồn");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(16, 11, 36, 14);
		alo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đích");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(85, 11, 46, 14);
		alo.add(lblNewLabel_1_1);
		
		//
		JButton btnNewButton = new JButton("Chọn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Đọc dữ liệu từ trường văn bản và thiết lập chúng cho biến s và t
		        try {
		        	Algorithm algoWorker = new Algorithm();
		        	//algoWorker.s = Integer.parseInt(tfnguon.getText());
		        	_algoWorkers = Integer.parseInt(tfnguon.getText());
		        	//algoWorker.t = Integer.parseInt(tfdich.getText());
		        	_algoWorkert = Integer.parseInt(tfdich.getText());
		        	Client client = new Client();
		        	try {
						client.pullTextbox();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        	//algoWorker.runAlgorithm();
		            
					//System.out.println("updating result");
					//MainFrame.updateResults(algoWorker);
					
		        } catch (NumberFormatException ex) {
		            // Xử lý trường hợp người dùng nhập dữ liệu không phải là số
		            System.out.println("Vui lòng nhập số hợp lệ.");
		        }    
		    }
		});
		btnNewButton.setBounds(26, 63, 89, 23);
		alo.add(btnNewButton);
		
		tfdich = new JTextField();
		tfdich.setColumns(10);
		tfdich.setBounds(95, 30, 36, 23);
		alo.add(tfdich);
		
		JLabel lblNewLabel = new JLabel("Chọn trạm trên mạng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(22, 11, 141, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 153, 141, 97);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Bảng chỉ dẫn");
		lblNewLabel_2.setForeground(new Color(153, 51, 204));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(22, 133, 141, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Kết thúc");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(282, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		tfduongdi = new JTextField();
		tfduongdi.setBackground(new Color(204, 255, 255));
		tfduongdi.setBounds(240, 165, 160, 20);
		contentPane.add(tfduongdi);
		tfduongdi.setColumns(10);
		
		tfkhoangcach = new JTextField();
		tfkhoangcach.setBackground(new Color(204, 255, 255));
		tfkhoangcach.setColumns(10);
		tfkhoangcach.setBounds(240, 196, 160, 20);
		contentPane.add(tfkhoangcach);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(240, 25, 160, 121);
		contentPane.add(panel);
		
		JLabel lblThMng = new JLabel("Đồ thị mạng");
		lblThMng.setHorizontalAlignment(SwingConstants.CENTER);
		lblThMng.setBounds(251, 11, 141, 14);
		contentPane.add(lblThMng);
	}
	public void updateResults(Algorithm algoResult) 
	{
		System.out.println("step 1");
		System.out.println(algoResult.getPath());
		System.out.println("step 2");
		System.out.println(algoResult.getDistance());
		System.out.println("step end");
		
        tfduongdi.setText(algoResult.getPath());
        tfkhoangcach.setText(algoResult.getDistance());
        //MainFrame.repaint();
    }
	public void _updateResults(String algoResult) 
	{
		System.out.println("step 1");
		System.out.println(algoResult);
		System.out.println("step 2");
		System.out.println(algoResult);
		System.out.println("step end");
		
        tfduongdi.setText(algoResult);
        //tfkhoangcach.setText(algoResult);
        View MainFrame = new View();
        MainFrame.revalidate();
        MainFrame.repaint();

    
        	
        
    }
}
