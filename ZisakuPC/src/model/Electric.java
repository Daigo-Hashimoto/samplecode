package model;

public class Electric {
	private String elcId;
	private String elcModelNo;
	private String capacity;
	private String url;
	private String date;

	public Electric (String elcId,String elcModelNo,double capacity,String url,String date) {
		this.elcId = elcId;
		this.elcModelNo = elcModelNo;
		this.capacity = new Double( capacity ).toString();
		this.url = url;
		this.date = date;
	}
	public String getElcId() { return elcId; }
	public String getElcModelNo() { return elcModelNo; }
	public String getCapacity() {return capacity; }
	public String getUrl() { return url; }
	public String getDate() { return date; }
}