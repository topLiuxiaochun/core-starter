package com.liuxc.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class AttributeViewTest {

	public static void main(String[] args) throws IOException {
		AttributeViewTest test = new AttributeViewTest();
		test.useFileAttributeView();
		manipulateFiles();
	}

	public void useFileAttributeView() throws IOException {
		Path path = Paths.get("signal.properties");
		
		DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
		
		if (view != null) {
			DosFileAttributes attrs = view.readAttributes();
			System.out.println(attrs.isReadOnly());
		} else {

		}
	}
	
	public static void manipulateFiles() throws IOException {
		Path newFile = Files.createFile(Paths.get("src/main/resources/newContent.txt").toAbsolutePath());
		
		List<String> content = new ArrayList<String>();
		
		content.add("startWith files");
		
		content.add("endWith end");
		
		Files.write(newFile, content, Charset.forName("UTF-8"));
		
		Files.size(newFile);
		
		byte[] bytes = Files.readAllBytes(newFile);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		Files.copy(newFile, out);
		
		
		
		
		
		
	}
}
