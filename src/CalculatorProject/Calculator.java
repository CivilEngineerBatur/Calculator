package CalculatorProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField display;
	
	Double n1, n2, result, memory;
	String operator, sum, subtraction, multiply, divide;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setTitle("CALCULATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 549);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"0");
			}
		});
		btn_0.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_0.setForeground(new Color(0, 0, 51));
		btn_0.setBackground(SystemColor.textHighlight);
		btn_0.setBounds(29, 388, 70, 50);
		contentPane.add(btn_0);
		
		JButton btn_00 = new JButton("00");
		btn_00.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_00.setForeground(new Color(0, 0, 102));
		btn_00.setBackground(SystemColor.textHighlight);
		btn_00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!display.getText().equals("")) {
					if (operator == null) {
		                n1 = Double.parseDouble(display.getText());
		                n1 *= 100;
		                display.setText(Double.toString(n1));
		            } else {
		                n2 = Double.parseDouble(display.getText());
		                n2 *= 100;
		                display.setText(Double.toString(n2));
		            }
				}
			}
		});
		btn_00.setBounds(109, 388, 70, 50);
		contentPane.add(btn_00);
		
		JButton btn_dot = new JButton(".");
		btn_dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = display.getText();
				 if (!text.contains(".") && operator == null) {
			            display.setText(text + ".");
			        }
			}
		});
		btn_dot.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_dot.setForeground(new Color(0, 0, 51));
		btn_dot.setBackground(SystemColor.textHighlight);
		btn_dot.setBounds(189, 388, 70, 50);
		contentPane.add(btn_dot);
		
		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"1");
			}
		});
		btn_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_1.setForeground(new Color(0, 0, 51));
		btn_1.setBackground(SystemColor.textHighlight);
		btn_1.setBounds(29, 328, 70, 50);
		contentPane.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"2");
			}
		});
		btn_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_2.setForeground(new Color(0, 0, 51));
		btn_2.setBackground(SystemColor.textHighlight);
		btn_2.setBounds(109, 328, 70, 50);
		contentPane.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"3");
			}
		});
		btn_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_3.setForeground(new Color(0, 0, 51));
		btn_3.setBackground(SystemColor.textHighlight);
		btn_3.setBounds(189, 328, 70, 50);
		contentPane.add(btn_3);
		
		JButton btn_sum = new JButton("+");
		btn_sum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!display.getText().equals("")) {
					n1 = Double.parseDouble(display.getText());
					operator = "toplama";
					display.setText("");	
				}
			}
		});
		btn_sum.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_sum.setForeground(new Color(0, 255, 51));
		btn_sum.setBackground(SystemColor.textHighlight);
		btn_sum.setBounds(269, 328, 70, 110);
		contentPane.add(btn_sum);
		
		JButton btn_equal = new JButton("=");
		btn_equal.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!display.getText().isEmpty() && n1 != null && operator != null) {
		            n2 = Double.parseDouble(display.getText());
		            switch (operator) {
		                case "sum":
		                    result = n1 + n2;
		                    break;
		                case "subtraction":
		                    result = n1 - n2;
		                    break;
		                case "multiply":
		                    result = n1 * n2;
		                    break;
		                case "divide":
		                    if (n2 != 0) {
		                        result = n1 / n2;
		                    } else {
		                        display.setText("ERROR!");
		                        return;
		                    }
		                    break;
		                case "perCent":
		                    result = (n1 * n2) / 100;
		                    break;
		                default:
		                    display.setText("ERROR!");
		                    return;
		            }
		            display.setText(Double.toString(result));
		            operator = null;
		        }
		    }
		});

		btn_equal.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_equal.setForeground(new Color(0, 255, 51));
		btn_equal.setBackground(SystemColor.textHighlight);
		btn_equal.setBounds(349, 328, 70, 110);
		contentPane.add(btn_equal);
		
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"4");
			}
		});
		btn_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_4.setForeground(new Color(0, 0, 51));
		btn_4.setBackground(SystemColor.textHighlight);
		btn_4.setBounds(29, 268, 70, 50);
		contentPane.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"5");
			}
		});
		btn_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_5.setForeground(new Color(0, 0, 51));
		btn_5.setBackground(SystemColor.textHighlight);
		btn_5.setBounds(109, 268, 70, 50);
		contentPane.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"6");
			}
		});
		btn_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_6.setForeground(new Color(0, 0, 51));
		btn_6.setBackground(SystemColor.textHighlight);
		btn_6.setBounds(189, 268, 70, 50);
		contentPane.add(btn_6);
		
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"7");
			}
		});
		btn_7.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_7.setForeground(new Color(0, 0, 51));
		btn_7.setBackground(SystemColor.textHighlight);
		btn_7.setBounds(29, 214, 70, 50);
		contentPane.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"8");
			}
		});
		btn_8.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_8.setForeground(new Color(0, 0, 51));
		btn_8.setBackground(SystemColor.textHighlight);
		btn_8.setBounds(109, 214, 70, 50);
		contentPane.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText()+"9");
			}
		});
		btn_9.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_9.setForeground(new Color(0, 0, 51));
		btn_9.setBackground(SystemColor.textHighlight);
		btn_9.setBounds(189, 214, 70, 50);
		contentPane.add(btn_9);
		
		JButton btn_multiply = new JButton("x");
		btn_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!display.getText().equals("")) {
				n1 = Double.parseDouble(display.getText());
				operator = "multiply";
				display.setText("");	
				
			}
			}
		});
		btn_multiply.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_multiply.setForeground(new Color(0, 0, 51));
		btn_multiply.setBackground(SystemColor.textHighlight);
		btn_multiply.setBounds(269, 268, 70, 50);
		contentPane.add(btn_multiply);
		
		JButton btn_subtraction = new JButton("-");
		btn_subtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!display.getText().equals("")) {
					n1 = Double.parseDouble(display.getText());
					operator = "subtraction";
					display.setText("");	
					
				}
			}
		});
		btn_subtraction.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_subtraction.setForeground(new Color(0, 0, 51));
		btn_subtraction.setBackground(SystemColor.textHighlight);
		btn_subtraction.setBounds(349, 268, 70, 50);
		contentPane.add(btn_subtraction);
		
		JButton btn_perCent = new JButton("%");
		btn_perCent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!display.getText().equals("")) {
					n1 = Double.parseDouble(display.getText());
					operator = "perCent";
					display.setText("");	
					
				}
			}
		});
		btn_perCent.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_perCent.setForeground(new Color(0, 0, 51));
		btn_perCent.setBackground(SystemColor.textHighlight);
		btn_perCent.setBounds(269, 214, 70, 50);
		contentPane.add(btn_perCent);
		
		JButton btn_divide = new JButton("/");
		btn_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!display.getText().equals("")) {
					n1 = Double.parseDouble(display.getText());
					operator = "divide";
					display.setText("");	
					
				}
			}
		});
		btn_divide.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_divide.setForeground(new Color(0, 0, 51));
		btn_divide.setBackground(SystemColor.textHighlight);
		btn_divide.setBounds(349, 214, 70, 50);
		contentPane.add(btn_divide);
		
		JButton btn_clear = new JButton("C");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText("");
			}
		});
		btn_clear.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_clear.setForeground(new Color(0, 255, 51));
		btn_clear.setBackground(SystemColor.textHighlight);
		btn_clear.setBounds(29, 154, 150, 50);
		contentPane.add(btn_clear);
		
		JButton btn_show_memory = new JButton("M");
		btn_show_memory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText(Double.toString(memory));
			}
		
		});
		btn_show_memory.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_show_memory.setForeground(new Color(0, 0, 51));
		btn_show_memory.setBackground(SystemColor.textHighlight);
		btn_show_memory.setBounds(189, 154, 70, 50);
		contentPane.add(btn_show_memory);
		
		JButton btn_get_memory = new JButton("M+");
		btn_get_memory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memory = Double.parseDouble(display.getText());
				display.setText("");
			}
		});
		btn_get_memory.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn_get_memory.setForeground(new Color(0, 0, 51));
		btn_get_memory.setBackground(SystemColor.textHighlight);
		btn_get_memory.setBounds(269, 154, 70, 50);
		contentPane.add(btn_get_memory);
		
		JButton btn_back_space = new JButton("<-");
		btn_back_space.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = display.getText();
		        if (!currentText.isEmpty()) { 
		            String newText = currentText.substring(0, currentText.length() - 1);
		            display.setText(newText);
		        }
			}
		});
		btn_back_space.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_back_space.setForeground(new Color(0, 0, 51));
		btn_back_space.setBackground(SystemColor.textHighlight);
		btn_back_space.setBounds(349, 154, 70, 50);
		contentPane.add(btn_back_space);
		
		display = new JTextField();
		display.setForeground(Color.WHITE);
		display.setBackground(Color.BLACK);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setFont(new Font("DialogInput", Font.BOLD, 56));
		display.setBounds(29, 34, 390, 110);
		contentPane.add(display);
		display.setColumns(10);
	}

}
