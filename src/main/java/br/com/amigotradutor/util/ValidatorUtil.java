package br.com.amigotradutor.util;

import java.util.Collection;
import java.util.Map;

public class ValidatorUtil {

	public static boolean isEmpty(Object obj) {
		
		if (obj == null)
			return true;
		
		if (obj instanceof String) {
			return ((String) obj).trim().isEmpty();
		} else if (obj instanceof Number) {
			if (obj instanceof Integer)
				return ((Integer) obj).intValue() == 0;
			else if (obj instanceof Long)
				return ((Long) obj).longValue() == 0l;
			else if (obj instanceof Double)
				return ((Double) obj).doubleValue() == 0d;
			else if (obj instanceof Float)
				return ((Float) obj).floatValue() == 0f;
			else if (obj instanceof Short)
				return ((Short) obj).shortValue() == 0;
			else if (obj instanceof Byte)
				return ((Byte) obj).byteValue() == 0;
			else 
				return true;
		} else if (obj instanceof Collection) {
			return ((Collection) obj).isEmpty();
		} else if (obj instanceof Map) {
			return ((Map) obj).isEmpty();
		}
		
		return false;
	}
	
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
	
}
