/* ===========================================================================
Created:	2015/06/26
Author:		Thomas Nguyen - thomas_ejob@hotmail.com
Purpose:	Keep all URL locations
=========================================================================== */

package config;

import java.io.File;

public class Paths {
	public static final String HOME_FOLDER = System.getProperty("user.dir");
	public static final String CHROME_FILE = ".\\vendor\\chromedriver.exe";

	public static final String SCREENSHOT_FOLDER = ".\\src\\test\\java\\screenshot\\";
	public static final String DEFAULT_SCREENSHOT_FILENAME = "screenshot.png";
	public static final String TMP_FOLDER = ".\\build\\tmp\\";

	public static final String BASE_URL = "http://www.google.com";
	public static final String FLICKR_URL = "https://www.flickr.com/explore";
	public static final String MORGAGECALCULATOR_URL = "http://www.mortgagecalculator.org";
	public static final String RECTANGLES_TEST_URL = "file://" + System.getProperty("user.dir") + File.separator + "html" + File.separator + "rect.html";
	public static final String SORTER_URL = "file://" + System.getProperty("user.dir") + File.separator + "html" + File.separator + "sorter.html";
	public static final String TEST_PAINTING_URL = "file://" + System.getProperty("user.dir") + File.separator + "html" + File.separator + "paint.html";
	public static final String WORDPRESS_URL = "https://yes4me.wordpress.com";
}