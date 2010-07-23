/*
 * Created on Nov 18, 2004
 */
package test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author moroff
 *
 * 
 * 
 */
public class Utils {

	public static void main(String[] args) {
	}

	public static Map createPathMap(String[] args) {
		return createPathMap(args, 1);
	}
	
	/**
	 * @param args
	 * @return
	 */
	public static Map createPathMap(String[] args, int startingArg) {
		Map pathMap = new HashMap();
	    Pattern pattern = Pattern.compile("(\\$\\w+)=(.+)");
	    for ( int i=startingArg; i<args.length; ++i) {
	    	Matcher matcher = pattern.matcher(args[i]);
	    	if ( matcher.find() ) {
		    	String key = matcher.group(1);
		    	String path = matcher.group(2);
		    	pathMap.put(key,path);
	    	}
	    }
		return pathMap;
	}
}
