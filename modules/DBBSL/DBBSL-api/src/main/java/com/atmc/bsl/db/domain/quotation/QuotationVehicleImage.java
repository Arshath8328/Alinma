package com.atmc.bsl.db.domain.quotation;


/**
 * @author Kareem Kahil
 *
 */

public class QuotationVehicleImage
{
	private long imageID;
	
	private int imageTitle;

	private String imageMedia;

	private String imageDateTime;

	private double imageLong;
	
	private double imageLat;

	public long getImageID() {
		return imageID;
	}

	public void setImageID(long imageID) {
		this.imageID = imageID;
	}

	public int getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(int imageTitle) {
		this.imageTitle = imageTitle;
	}

	public String getImageMedia() {
		return imageMedia;
	}

	public void setImageMedia(String imageMedia) {
		this.imageMedia = imageMedia;
	}

	public String getImageDateTime() {
		return imageDateTime;
	}

	public void setImageDateTime(String imageDateTime) {
		this.imageDateTime = imageDateTime;
	}

	public double getImageLong() {
		return imageLong;
	}

	public void setImageLong(double imageLong) {
		this.imageLong = imageLong;
	}

	public double getImageLat() {
		return imageLat;
	}

	public void setImageLat(double imageLat) {
		this.imageLat = imageLat;
	}

}

