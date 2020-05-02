package model;

public class Pc {
	private String pcId;
	private String pcClass;
	private String rank;
	private String genNo;
	private String modelNo;
	private String url;
	private String date;

	public Pc (String pcId,String pcClass,String rank,String genNo,String modelNo,String url,String date) {
		this.pcId = pcId;
		this.pcClass = pcClass;
		this.rank = rank;
		this.genNo = genNo;
		this.modelNo = modelNo;
		this.url = url;
		this.date = date;
	}
	public String getPcId() { return pcId; }
	public String getPcClass() { return pcClass; }
	public String getRank() { return rank; }
	public String getGenNo() { return genNo; }
	public String getModelNo() { return modelNo; }
	public String getUrl() { return url; }
	public String getDate() { return date; }
}