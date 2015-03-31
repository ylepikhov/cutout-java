package cutout.java.util;

public class JavaStringLiteralUtil {
	
	static public CharSequence escape(CharSequence value) {
		
		if (value == null) return null;
		
		int lastFound = -1;
		StringBuilder sb = null;
		
		for (int i = 0; i < value.length(); i++) {
		
			char c = value.charAt(i);
			String replace;
			switch (c) {
			
			case '\b':
				replace = "\\b";
				break;
			case '\t':
				replace = "\\t";
				break;
			case '\n':
				replace = "\\n";
				break;
			case '\f':
				replace = "\\f";
				break;
			case '\r':
				replace = "\\r";
				break;
			case '\"':
				replace = "\\\"";
				break;
			case '\'':
				replace = "\\\'";
				break;
			case '\\':
				replace = "\\\\";
				break;
			default:
				continue;
			}
			
			if (sb == null) sb = new StringBuilder();
			if (lastFound + 1 < i) sb.append(value.subSequence(lastFound + 1, i));
			sb.append(replace);
			lastFound = i;
		}
		
		if (sb == null) return value;
		if (lastFound + 1 < value.length()) sb.append(value.subSequence(lastFound + 1, value.length()));
		
		return sb;
	}
}
