package com.allianz.pa.common.util;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;


public class ResourceUtil {
	private static final String RESOURCE_FILE = "res.RestBundle";
	private static final Logger log = Logger.getLogger(ResourceUtil.class);

	public static String getPropertyWithParams(String propertyKey,Object... args) {
		ResourceBundle bundle = getBundle();
		String mssage="";
		try {
			mssage = new String(bundle.getString(propertyKey).getBytes("ISO-8859-1"), "UTF8");
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		}
		return String.format(mssage, args);
	}

	public static String errorCodeMsg(String key, Object... args) {
		String errorKey = "error.msg." + key;
		ResourceBundle bundle = getBundle();
		String mssage="";
		try {
			mssage = new String(bundle.getString(errorKey).getBytes("ISO-8859-1"), "UTF8");
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		}
		return String.format(mssage, args);
	}

	public static ResourceBundle getBundle() {
		ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_FILE);
		return bundle;
	}
}
