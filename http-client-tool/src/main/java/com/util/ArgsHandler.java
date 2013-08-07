package com.util;

public class ArgsHandler {

	private static final String ABBREVIATED_OPTION_PREFIX = "-";
	private static final String COMPLETE_OPTION_PREFIX = "--";

	private final String[] args;

	public ArgsHandler(String[] args) {
		if (args != null) {

			this.args = args;
		} else {
			this.args = new String[0];
		}
	}

	public boolean existsAbbreviatedOption(String name) {
		String prefixedName = ABBREVIATED_OPTION_PREFIX + name;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase(prefixedName)) {
				return true;
			}
		}
		return false;
	}

	public boolean existsCompleteOption(String name) {
		String prefixedName = COMPLETE_OPTION_PREFIX + name;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase(prefixedName)) {
				return true;
			}
		}
		return false;
	}

	public boolean existsOption(String name) {
		return (existsAbbreviatedOption(name) || existsCompleteOption(name));
	}

	public String getValueAt(int i) {
		if (i >= args.length) {
			throw new IllegalArgumentException(String.format("There is no value at position '%s' - Args length is '%s'", i, args.length));
		}
		String value = args[i];
		if (isOption(value)) {
			throw new IllegalStateException(String.format("Value at position '%s' is an option", i));
		}
		return value;
	}

	public String getValueAtLast() {
		if (args.length == 0) {
			throw new IllegalStateException("There are no values to get");
		}
		String value = args[args.length - 1];
		if (isOption(value)) {
			throw new IllegalStateException("Value at position last is an option");
		}
		return value;
	}

	private boolean isAbbreviatedOption(String value) {
		return (value.startsWith(ABBREVIATED_OPTION_PREFIX) && value.length() == 2);
	}

	public boolean isCompleteOption(String value) {
		return (value.startsWith(COMPLETE_OPTION_PREFIX));
	}

	public boolean isOption(String value) {
		return (isAbbreviatedOption(value) || isCompleteOption(value));
	}

	public String getValueForOption(String option) {
		int index = getOptionIndex(option);
		if (index == -1) {
			throw new IllegalStateException(String.format("Option '%s' doesn't exist", option));
		}
		if (index + 1 == args.length || isOption(args[index + 1])) {
			throw new IllegalStateException(String.format("Option '%s' doesn't have value", option));
		}
		return args[index + 1];
	}

	private int getOptionIndex(String name) {
		String prefixedNameAbbreviated = ABBREVIATED_OPTION_PREFIX + name;
		String prefixedNameComplete = COMPLETE_OPTION_PREFIX + name;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase(prefixedNameAbbreviated) || args[i].equalsIgnoreCase(prefixedNameComplete)) {
				return i;
			}
		}
		return -1;
	}
}
