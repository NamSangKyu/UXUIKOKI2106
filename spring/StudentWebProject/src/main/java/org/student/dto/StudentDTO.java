package org.student.dto;

import org.apache.ibatis.type.Alias;

@Alias("student")
public class StudentDTO {
	private String sno;
	private String name;
	private String major;
	private double score;

	public StudentDTO() {
	}

	public StudentDTO(String sno, String name, String major, double score) {
		this.sno = sno;
		this.name = name;
		this.major = major;
		this.score = score;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
