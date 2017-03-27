package io.github.steve_bulgin.models;

public class HiveObj {

	private int hiveID;
	private String hiveName;
	private String splitType;
	private String hiveType;
	private int yearbeeswereSourced;
	private String hiveConfiguration;
	private int yardID;

    public HiveObj() {}

	public int getHiveID() {
		return hiveID;
	}

	public void setHiveID(int hiveID) {
		this.hiveID = hiveID;
	}

	public String getHiveName() {
		return hiveName;
	}

	public void setHiveName(String hiveName) {
		this.hiveName = hiveName;
	}

	public String getSplitType() {
		return splitType;
	}

	public void setSplitType(String splitType) {
		this.splitType = splitType;
	}

	public String getHiveType() {
		return hiveType;
	}

	public void setHiveType(String hiveType) {
		this.hiveType = hiveType;
	}

	public int getYearbeeswereSourced() {
		return yearbeeswereSourced;
	}

	public void setYearbeeswereSourced(int yearbeeswereSourced) {
		this.yearbeeswereSourced = yearbeeswereSourced;
	}

	public String getHiveConfiguration() {
		return hiveConfiguration;
	}

	public void setHiveConfiguration(String hiveConfiguration) {
		this.hiveConfiguration = hiveConfiguration;
	}

	public int getYardID() {
		return yardID;
	}

	public void setYardID(int yardID) {
		this.yardID = yardID;
	}
}
