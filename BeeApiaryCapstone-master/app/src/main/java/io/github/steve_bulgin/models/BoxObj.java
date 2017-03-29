/* FileName: BoxObj.java
 * Purpose: Entity for hive boxes
 * Revision History
 * 		Steven Bulgin, 2017.03.26: Created
 */

package io.github.steve_bulgin.models;

public class BoxObj {

	private int boxID;
	private String boxType;
	private int numberofFrames;
	private String frameMaterial;
	private String installationDate;
	private String harvestDate;
	private double honeyWeight;
	private int hiveID;

	public BoxObj() {}

	public int getBoxID() {
		return boxID;
	}

	public void setBoxID(int boxID) {
		this.boxID = boxID;
	}

	public String getBoxType() {
		return boxType;
	}

	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}

	public int getNumberofFrames() {
		return numberofFrames;
	}

	public void setNumberofFrames(int numberofFrames) {
		this.numberofFrames = numberofFrames;
	}

	public String getFrameMaterial() {
		return frameMaterial;
	}

	public void setFrameMaterial(String frameMaterial) {
		this.frameMaterial = frameMaterial;
	}

	public String getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(String installationDate) {
		this.installationDate = installationDate;
	}

	public String getHarvestDate() {
		return harvestDate;
	}

	public void setHarvestDate(String harvestDate) {
		this.harvestDate = harvestDate;
	}

	public int getHiveID() {
		return hiveID;
	}

	public void setHiveID(int hiveID) {
		this.hiveID = hiveID;
	}

	public double getHoneyWeight() {
		return honeyWeight;
	}

	public void setHoneyWeight(double honeyWeight) {
		this.honeyWeight = honeyWeight;
	}

}
