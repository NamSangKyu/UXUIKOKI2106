package org.korea.dto;

import java.io.File;

import org.apache.ibatis.type.Alias;
@Alias("file")
public class FileDTO {
	private int fno;
	private int bno;
	private String writer;
	private String fdate;
	private String path;
	private String fileName;
	private String type;

	public FileDTO() {
	}
	
	public FileDTO(File file) {
		this.path = file.getAbsolutePath();
		this.fileName = file.getName();
		switch (fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase()) {
		case "png":
		case "bmp":
		case "jpg":
		case "gif":
			type = "image";
			break;
		default:
			type = "normal";
		}
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public int getFileNo() {
		return fno;
	}

	public void setFileNo(int fileNo) {
		this.fno = fileNo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "FileDTO [fno=" + fno + ", bno=" + bno + ", writer=" + writer + ", fdate=" + fdate + ", path=" + path
				+ ", fileName=" + fileName + ", type=" + type + "]";
	}
	

}
