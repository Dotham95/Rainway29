package entity;

public class News implements INews {
	private int id;
	private String Title;
	private String PublishDate;
	private String Author;
	private String Content;
	private Float AverageRate;
	private int[] rate;
	public static int COUNT = 0;

	public News(String title, String publishDate, String author, String content, int[] rate) {
		super();
		COUNT++;
		this.id = COUNT;
		Title = title;
		PublishDate = publishDate;
		Author = author;
		Content = content;
		AverageRate = getAverageRate();
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Float getAverageRate() {
		return AverageRate;
	}

	public void setAverageRate(Float averageRate) {
		AverageRate = averageRate;
	}

	public int[] getRate() {
		return rate;
	}

	public void setRate(int[] rate) {
		this.rate = rate;
	}

	@Override
	public void display() {
		System.out.println(
				"News [title=" + getTitle() + ", publishDate=" + getPublishDate() + ", author=" + getAuthor() + "]");

	}

	@Override
	public float calculate() {
		AverageRate = (float) ((rate[0] + rate[1] + rate[2]) / 3);
		return AverageRate;
	}

}
