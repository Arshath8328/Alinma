package com.atmc.web.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PropsUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tika.Tika;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

public class FileUtil {
	public  static Tika					tika;
	
	private static final Log			_log					= LogFactoryUtil.getLog(FileUtil.class);

	public static final List<String>	MAKES_LIST				= Arrays.asList("114", "91", "147", "43", "83", "95", "11", "14", "16", "17", "22", "23", "16", "27", "32", "29", "30", "8", "68",
			"109", "112", "113", "76", "130", "84", "97", "35", "1", "31", "117", "39", "70", "14", "144", "119", "87", "92", "38", "59", "63", "140", "153", "3", "142", "98", "19", "80", "89", "139",
			"54", "67", "74", "81", "36", "44", "148", "13", "11", "15", "25", "132", "116");

	public static final double			MINIMUM_ALLOWED_SIZE	= 5;

	public static final Set<String>		ACCEPTED_FILE_TYPES		= new HashSet<>(Arrays.asList("image/jpeg",																												// jpg,
																																																						// jpeg
			"image/png",																																																// png
			"application/vnd.openxmlformats-officedocument.wordprocessingml.document",																																	// docs
			"application/msword",																																														// doc
			"application/pdf"));																																														// pdf

	public static boolean isAcceptedFileType(File file, Set<String> acceptedTypes) {
		System.getProperties().remove("tika.config");
		_log.info("System.getproperty() : "+System.getProperty("tika.config") +" & system.getenv() "+System.getenv("TIKA_CONFIG"));
		tika = new Tika();
		boolean isAcceptableType = false;
		try {
			String fileType = tika.detect(file);

			_log.info("Detected File Type:" + fileType);

			if (acceptedTypes.contains(fileType)) {
				_log.info("Accepted File Type Detected.");
				isAcceptableType = true;
			} else {
				_log.info("Unaccepted File Type Detected. Will dismiss");
				isAcceptableType = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isAcceptableType;
	}

	public static boolean isExecutable(File file) {
		byte[] firstBytes = new byte[4];
		boolean isExecutable = false;

		try {
			FileInputStream input = new FileInputStream(file);
			input.read(firstBytes);

			// Check for Windows executable
			if (firstBytes[0] == 0x4d && firstBytes[1] == 0x5a) {
				isExecutable = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		_log.info(file.getName() + " Is Executable: " + isExecutable);
		return isExecutable;
	}

	/**
	 * Validates a file before it gets acted on, validations like filename, fileSize, fileExtension, acceptedFileTypes
	 * 
	 * @throws Exception
	 */
	public static boolean validateFile(File file, Set<String> acceptedTypes, double minimumAllowedSize) throws Exception {
		boolean isValid;
		String fileName = file.getName();
		if (fileName.split("[.]").length > 2 || fileName.length() > 255) {
			_log.error("Multiple Extension");
			return false;
		}

		file.setReadOnly();
		file.setExecutable(false);

		if ((double) file.length() / (1024) < minimumAllowedSize) {
			_log.error("file-size too small : "+(double) file.length() / (1024));
			return false;
		}
		isValid = isAcceptedFileType(file, acceptedTypes);
		return isValid;
	}

}
