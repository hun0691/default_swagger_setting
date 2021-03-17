package com.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Lotto {

	@Id
	private int round;
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getRow1() {
		return row1;
	}
	public void setRow1(int row1) {
		this.row1 = row1;
	}
	public int getRow2() {
		return row2;
	}
	public void setRow2(int row2) {
		this.row2 = row2;
	}
	public int getRow3() {
		return row3;
	}
	public void setRow3(int row3) {
		this.row3 = row3;
	}
	public int getRow4() {
		return row4;
	}
	public void setRow4(int row4) {
		this.row4 = row4;
	}
	public int getRow5() {
		return row5;
	}
	public void setRow5(int row5) {
		this.row5 = row5;
	}
	public int getRow6() {
		return row6;
	}
	public void setRow6(int row6) {
		this.row6 = row6;
	}
	private int row1;
	private int row2;
	private int row3;
	private int row4;
	private int row5;
	private int row6;
	private int row7;
	public int getRow7() {
		return row7;
	}
	public void setRow7(int row7) {
		this.row7 = row7;
	}

	
}
