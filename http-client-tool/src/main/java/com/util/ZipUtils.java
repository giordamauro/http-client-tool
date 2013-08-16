package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ZipUtils {

	private final static Log logger = LogFactory.getLog(ZipUtils.class);

	public static void main(String[] args) {

		String INPUT_ZIP_FILE = "api-proxy.zip";
		String OUTPUT_FOLDER = "C:\\outputzip";

		ZipUtils.unZipFile(INPUT_ZIP_FILE, OUTPUT_FOLDER);
	}

	public static void unZipFile(String zipFile, String outputFolder) {

		File folder = new File(outputFolder);
		if (folder.exists()) {
			FileUtils.deleteFolder(folder);
		}
		folder.mkdir();

		byte[] buffer = new byte[1024];

		try {

			// get the zip file content
			ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
			// get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();

			while (ze != null) {

				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);

				logger.info("UnZiping file : " + newFile.getAbsoluteFile());

				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

			logger.info("Done");

		} catch (IOException ex) {
			throw new IllegalStateException(ex);
		}
	}
}