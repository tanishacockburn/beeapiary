/* FileName: FlowerObj.java
 * Purpose: Entity for flower objects
 * Revision History
 * 		Steven Bulgin, 2017.03.26: Created
 */

package io.github.steve_bulgin.models;

public class FlowerObj {

	private int flowerID;
	private int yardID;
	private String commonName;
	private String scientificName;
	private String startofSeason;
	private String endofSeason;

	public FlowerObj() {}

	public int getFlowerID() {
		return flowerID;
	}

	public void setFlowerID(int flowerID) {
		this.flowerID = flowerID;
	}

	public int getYardID() {
		return yardID;
	}

	public void setYardID(int yardID) {
		this.yardID = yardID;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getStartofSeason() {
		return startofSeason;
	}

	public void setStartofSeason(String startofSeason) {
		this.startofSeason = startofSeason;
	}

	public String getEndofSeason() {
		return endofSeason;
	}

	public void setEndofSeason(String endofSeason) {
		this.endofSeason = endofSeason;
	}
}
