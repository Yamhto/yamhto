package com.yamhto.util;

import java.text.NumberFormat;

public class NumberFormatUtil {

	public static NumberFormat format (int length) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMaximumIntegerDigits(length);
		nf.setMinimumIntegerDigits(length);
		
		return nf;
	}
}
