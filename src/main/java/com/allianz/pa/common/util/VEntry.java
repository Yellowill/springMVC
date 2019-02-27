package com.allianz.pa.common.util;

import java.lang.annotation.Annotation;
import java.util.Map.Entry;

public interface VEntry<K, V> extends Entry<K, V> {
	public Class getType();

	public boolean canRead();

	public boolean canWrite();

	public Object getAnnotation(Class<? extends Annotation> o);

}
