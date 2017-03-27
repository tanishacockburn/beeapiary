/* FileName: MediaObj.java
 * Purpose: Media object class
 * Revision History
 * 		Steven Bulgin, 2017.03.26: Created
 */

package io.github.steve_bulgin.models;

public class MediaObj {

	private int mediaID;
	private int hiveID;
	private String hiveImageStr;
	private String hiveVideoStr;

	public MediaObj() {}

	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	public int getHiveID() {
		return hiveID;
	}

	public void setHiveID(int hiveID) {
		this.hiveID = hiveID;
	}

	public String getHiveImageStr() {
		return hiveImageStr;
	}

	public void setHiveImageStr(String hiveImageStr) {
		this.hiveImageStr = hiveImageStr;
	}

	public String getHiveVideoStr() {
		return hiveVideoStr;
	}

	public void setHiveVideoStr(String hiveVideoStr) {
		this.hiveVideoStr = hiveVideoStr;
	}

}
