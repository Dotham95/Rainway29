package backend;

import java.util.ArrayList;
import entity.News;
import utils.ScannerUtil;

public class Exercise1 {
	ArrayList<News> listNews = new ArrayList<News>();

	public void question1() {
		loadMenu();
	}

	private void loadMenu() {
		while (true) {
			System.out.println("~~~~~~~~~~ Mời bạn lựa chọn chức năng bạn muốn sử dụng ~~~~~~~");
			System.out.println("1. Insert news");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("4. Exit");
			int selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1:
				System.out.println("Mời bạn nhập vào  Title");
				String title = ScannerUtil.scanStr();
				System.out.println("Mời bạn nhập vào PublishDate");
				String publishDate = ScannerUtil.scanStr();
				System.out.println("Mời bạn nhập vào Author");
				String author = ScannerUtil.scanStr();
				System.out.println("Mời bạn nhập vào Content");
				String content = ScannerUtil.scanStr();
				System.out.println("Mời bạn nhập vào đánh giá 1");
				int rate1 = ScannerUtil.scanInt();
				System.out.println("Mời bạn nhập vào đánh giá 2");
				int rate2 = ScannerUtil.scanInt();
				System.out.println("Mời bạn nhập vào đánh giá 3");
				int rate3 = ScannerUtil.scanInt();
				int[] rates = { rate1, rate2, rate3 };
				News news = new News(title, publishDate, author, content, rates);
				listNews.add(news);
				break;
			case 2:
				for (News news1 : listNews) {
					news1.display();
				}
				break;
			case 3:
				System.out.println("Đánh giá trung bình Rate");
				for (News news1 : listNews) {
					System.out.println("Title: " + news1.getTitle() + " RateAVG: " + news1.calculate());
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Bạn đã chọn sai chức năng mời chọn lại!!");
				break;
			}
		}
	}
}
