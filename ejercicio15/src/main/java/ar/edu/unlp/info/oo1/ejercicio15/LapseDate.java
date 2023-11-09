package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LapseDate {
	private LocalDate to;
	private LocalDate from;
	
	public LapseDate(LocalDate from, LocalDate to) {
		this.to = to;
		this.from = from;
	}
	
	public LocalDate getTo() {
		return to;
	}
	
	public LocalDate getFrom() {
		return from;
	}
	
	public int sizeInDays() {
		return (int) this.getFrom().until(this.getTo(), ChronoUnit.DAYS);
	}
	
	public boolean includesDate(LocalDate other) {
		return (other.isAfter(this.getFrom()) || other.isEqual(this.getFrom())) && (other.isBefore(this.getTo()) || other.isEqual(this.getTo()));
	}
	
	public boolean overlaps(LapseDate anotherDateLapse) {
		return (this.includesDate(anotherDateLapse.getFrom()) || this.includesDate(anotherDateLapse.getTo()));
	}
}