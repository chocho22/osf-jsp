package com.osf.test.vo;

public class PhotoBoardVO {
	
	private Integer pbNum;
	private String pbTitle;
	private String pbContent;
	private String pbCredat;
	private String pbCretim;
	private String pbFilePath;
	private String pbRealPath;
	
	public Integer getPbNum() {
		return pbNum;
	}
	public void setPbNum(Integer pbNum) {
		this.pbNum = pbNum;
	}
	public String getPbTitle() {
		return pbTitle;
	}
	public void setPbTitle(String pbTitle) {
		this.pbTitle = pbTitle;
	}
	public String getPbContent() {
		return pbContent;
	}
	public void setPbContent(String pbContent) {
		this.pbContent = pbContent;
	}
	public String getPbCredat() {
		return pbCredat;
	}
	public void setPbCredat(String pbCredat) {
		this.pbCredat = pbCredat;
	}
	public String getPbCretim() {
		return pbCretim;
	}
	public void setPbCretim(String pbCretim) {
		this.pbCretim = pbCretim;
	}
	public String getPbFilePath() {
		return pbFilePath;
	}
	public void setPbFilePath(String pbFilePath) {
		this.pbFilePath = pbFilePath;
	}
	public String getPbRealPath() {
		return pbRealPath;
	}
	public void setPbRealPath(String pbRealPath) {
		this.pbRealPath = pbRealPath;
	}
	@Override
	public String toString() {
		return "PBoardVO [pbNum=" + pbNum + ", pbTitle=" + pbTitle + ", pbContent=" + pbContent + ", pbCredat="
				+ pbCredat + ", pbCretim=" + pbCretim + ", pbFilePath=" + pbFilePath + ", pbRealPath=" + pbRealPath
				+ "]";
	}
}
