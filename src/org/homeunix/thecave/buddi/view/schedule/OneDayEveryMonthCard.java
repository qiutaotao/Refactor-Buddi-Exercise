/*
 * Created on Aug 18, 2007 by wyatt
 */
package org.homeunix.thecave.buddi.view.schedule;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import org.homeunix.thecave.buddi.i18n.BuddiKeys;
import org.homeunix.thecave.buddi.i18n.keys.ScheduleFrequencyFirstWeekOfMonth;
import org.homeunix.thecave.buddi.model.ScheduledTransaction;
import org.homeunix.thecave.buddi.plugin.api.util.TextFormatter;
import org.homeunix.thecave.buddi.view.swing.TranslatorListCellRenderer;
import org.homeunix.thecave.moss.swing.components.JScrollingComboBox;
import org.homeunix.thecave.moss.swing.window.MossPanel;

public class OneDayEveryMonthCard extends MossPanel implements ScheduleCard {
	public static final long serialVersionUID = 0;

	private final JScrollingComboBox monthlyFirstDayChooser;
	
	public OneDayEveryMonthCard() {
		super(true);
		monthlyFirstDayChooser = new JScrollingComboBox(ScheduleFrequencyFirstWeekOfMonth.values());	
		open();
	}
	
	@Override
	public void init() {
		super.init();

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(new JLabel(TextFormatter.getTranslation(BuddiKeys.AND_REPEATING_ON_THE)));
		this.add(monthlyFirstDayChooser);
		this.add(new JLabel(TextFormatter.getTranslation(BuddiKeys.OF_EACH_MONTH)));
		
		monthlyFirstDayChooser.setRenderer(new TranslatorListCellRenderer());
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		
		monthlyFirstDayChooser.setEnabled(enabled);
	}
	
	public int getScheduleDay() {
		return monthlyFirstDayChooser.getSelectedIndex();
	}
	
	public int getScheduleWeek() {
		return 0;
	}
	
	public int getScheduleMonth() {
		return 0; //TODO This used to be -1.  Check if this change is correct or not.
	}
	
	public void loadSchedule(ScheduledTransaction s) {
		monthlyFirstDayChooser.setSelectedIndex(s.getScheduleDay());	
	}
}
