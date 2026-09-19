package main;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*utilizes the flyweight design pattern to cache fonts in memory 
so as to not duplicate fonts
*/
public class FontFactory {
	
	static Map<String, Font> fonts = new HashMap<>();
	
	public static Font getFont(String fontName, int fontType, int fontSize) {
		return createFont(fontName, fontType, fontSize);
	}
	
	private static Font createFont(String fontName, int fontType, int fontSize) {
		List<String> characteristics = new ArrayList<>();
		characteristics.add(fontName);
		characteristics.add(Integer.toString(fontType));
		characteristics.add(Integer.toString(fontSize));
		
		String key = String.join("_", characteristics);
		
		//create new Font object if not existing in map cache
		fonts.putIfAbsent(key, new Font(fontName, fontType, fontSize));
		return fonts.get(key);
	}
}
