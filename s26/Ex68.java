package s26;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

/**
 * თქვენი ამოცანაა გრაფიკული პროგრამის საშუალებით გააკეთოთ ჩატი.
 * 
 * ფანჯარაზე, SOUTH რეგიონზე უნდა გქონდეთ ერთი ტექსტფილდი და ერთი ღილაკი ტექტით
 * Enter. ტექსტფილდში ტექსტის შეყვანის მერე Enter ჭილაკზე დაჭერით ტექსტი უნდა
 * იწერებოდეს(იხატებოდეს) კანვასზე, ხოლო ტექსტფილდში კი ტექსტი იშლებოდეს.
 * ხელახლა ტექსტის შეყვანისას ახალი ტექსტი წინა ტექსტის ქვემოთ უნდა გამოჩნდეს
 * (როგორც ჩატში ხდება ხოლმე). თუკი ტექსტი ჩაცდება ეკრანს არაუშავს.
 */
public class Ex68 extends GraphicsProgram {

	JTextField messageInput;
	JButton addButton;
	int totalMessages;

	@Override
	public void init() {
		totalMessages = 0;

		// Initialize text field
		messageInput = new JTextField(20);
		add(messageInput, SOUTH);
		messageInput.addActionListener(this);

		// Initialize button
		addButton = new JButton("Add");
		add(addButton, SOUTH);

		addActionListeners();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == messageInput || e.getSource() == addButton) {
			// 1. Get message
			String message = messageInput.getText();
			
			// 2. Add message on canvas
			GLabel messageLabel = new GLabel(message);
			int x = 5; // Offset from left
			int y = (int) ((totalMessages + 1) * messageLabel.getAscent());
			add(messageLabel, x, y);
			
			// 3. Increment message count
			totalMessages += 1;
		}
	}
}
