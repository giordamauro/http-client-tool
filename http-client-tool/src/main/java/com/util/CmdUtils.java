package com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class CmdUtils {

	private static final Log logger = LogFactory.getLog(CmdUtils.class);

	private CmdUtils() {
	}

	public static String excecListOptions(List<String> options) {

		String command = "";

		for (String option : options) {
			command += option + " ";
		}

		if (!options.isEmpty()) {
			command = command.substring(0, command.length() - 1);
		}

		return execCommand(command);
	}

	public static String excecOptions(String[] options) {
		logger.info("Excecuting command : " + options);

		ProcessBuilder builder = new ProcessBuilder(options);

		return execute(builder);
	}

	public static String execCommand(String command) {

		logger.info("Excecuting command : '" + command + "'");

		String[] options = command.split(" ");
		ProcessBuilder builder = new ProcessBuilder(options);

		return execute(builder);
	}

	private static String execute(ProcessBuilder builder) {

		try {
			builder.redirectErrorStream(true);
			Process process = builder.start();
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			StringBuilder strBuilder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				strBuilder.append("\n" + line);
			}

			logger.info(strBuilder);

			return strBuilder.toString();

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
