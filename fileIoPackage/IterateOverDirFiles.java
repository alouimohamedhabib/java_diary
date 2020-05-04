package fileIoPackage;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class IterateOverDirFiles {
	public static void main(String[] args) {

		Path dir = Paths.get("/home/mohamed/Pictures");
		// regex to find only imgs

		PathMatcher imageFileMatcher = FileSystems.getDefault()
				.getPathMatcher("regex:.*(?i:gif)");

		try (DirectoryStream<Path> source = Files.newDirectoryStream(dir,
				item -> imageFileMatcher.matches(item.getFileName()))) {
			for (Path item : source) {
				System.out.println(item.getFileName());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
