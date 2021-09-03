package file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		File file = null;
		try {
			file = new File("c:\\test\\test.txt");

			// 부모폴더 경로
			File parentFile = file.getParentFile();
			System.out.println(parentFile.getAbsolutePath());
			// 파일 생성, 파일 생성시 해당 경로 파악
			if (!parentFile.exists()) {
				parentFile.mkdirs();//폴더 생성에 필요한 모든 상위폴더까지 생성
				System.out.println("해당 경로 폴더 생성 완료");
			}
			file.createNewFile();
			System.out.println("파일생성 완료");
			//file.renameTo(new File("c:\\test\\rename.txt"));//파일명 바꾸기			
			//파일 삭제
			file.delete();
			
			File root = new File("c:\\");
			File list[]  = root.listFiles();
			System.out.println(list.length);
			for(File temp : list)
			{
				String fileName = temp.getName();
				long fileSize = temp.length();
				String etc = temp.isDirectory() ? "<DIR>" : "";
				
				String path = String.format("%-30s\t%s\t%dbyte",fileName,etc,fileSize);
					
				System.out.println(path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
