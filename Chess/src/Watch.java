import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Watch {
	
	JFrame SettingFrame;
	JLabel Label;
	Font fontsize = new Font("Arial", Font.PLAIN, 20);	
	Timer timer;	
	int second, minute;
	String SecString, MinString;	
	DecimalFormat dFormat = new DecimalFormat("00");
	
	public Watch() {
		
		SettingFrame = new JFrame();
		SettingFrame.setSize(300,400);
		
		Label = new JLabel("");
		Label.setBounds(100, 100, 100, 30);
		Label.setHorizontalAlignment(JLabel.CENTER);
		Label.setFont(fontsize);
		
		SettingFrame.add(Label);
		SettingFrame.setVisible(true);
		
		Label.setText("01:00");
		second = 0;
		minute = 1;
		Timer();
		timer.start();						
	}
	public void Timer() {
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent Time) {
				
				second--;
				SecString = dFormat.format(second);
				MinString = dFormat.format(minute);	
				Label.setText(MinString + ":" + SecString);
				
				if(second==-1) {
					second = 59;
					minute--;
					SecString = dFormat.format(second);
					MinString = dFormat.format(minute);	
					Label.setText(MinString + ":" + SecString);
				}
				if(minute==0 && second==0) {
					timer.stop();
				}
			}
		});		
	}		
}