/* FileName: YardObj.java
 * Purpose: Entity for Yard object
 * Revision History
 * 		Steven Bulgin, 2017.03.26: Created
 */

package io.github.steve_bulgin.models;

public class YardObj {

	private int yardID;
	private String location;
	private String landDescription;

	public YardObj() {}

	public int getYardID() {
		return yardID;
	}

	public void setYardID(int yardID) {
		this.yardID = yardID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLandDescription() {
		return landDescription;
	}

	public void setLandDescription(String landDescription) {
		this.landDescription = landDescription;
	}
}
