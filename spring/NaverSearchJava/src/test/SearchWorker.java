package test;

public class SearchWorker extends Thread{
	private String text;
	
	
	public SearchWorker(String text) {
		this.text = text;
	}


	@Override
	public void run() {
		while(true) {
				try {
					sleep(1000*10);
					SearchTotal.run(text);
					System.out.println(text+" 검색 수행");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
	
}
