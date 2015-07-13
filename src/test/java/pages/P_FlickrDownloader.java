/* ===========================================================================
Created:	2015/07/04
Author:		Thomas Nguyen - thomas_ejob@hotmail.com
Purpose:	Page object
=========================================================================== */

package pages;

import java.util.ArrayList;
import java.util.List;

import lib.BasePage;
import lib.Util;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import config.Paths;

public class P_FlickrDownloader extends BasePage implements PageFactory {
	@FindBy(className ="download") private WebElement DOWNLOAD_HREF;
	@FindBy(partialLinkText ="View all sizes") private WebElement VIEW_ALL_SIZE_HREF;
	@FindBy(xpath ="//div[@id='allsizes-photo']/img") private WebElement MAIN_PHOTO_PICT;

	private final static int PICTURES_DOWNLOADED_MAX = 5;	//Max number of pictures that will be downloaded

	public P_FlickrDownloader(WebDriver driver) {
		super(driver);
	}

	@Override
	public void visit() {
		visit(Paths.FLICKR_URL);
	}

	@Override
	public boolean check_page() {
		return compareURL(getCurrentURL(), Paths.FLICKR_URL);
	}

	public void downloadAllHiResPicts() {
		String pictURL = "";
		String pictFileName = "";
		int counter=0;

		//Wait for the page to load PICTURES_DOWNLOADED_MAX pictures
		List<WebElement> picture_WebElement = null;
		counter=0;
		while (counter++ < PICTURES_DOWNLOADED_MAX)
		{
			picture_WebElement = finds(By.className("overlay"));
			Util.wait(1);
			if (picture_WebElement.size() >= PICTURES_DOWNLOADED_MAX)
				break;
		}

		//Get the list of URLs
		counter=0;
		List<String> picture_url = new ArrayList<String>();
		for (WebElement webElement : picture_WebElement)
		{
			picture_url.add(counter, webElement.getAttribute("href"));
			if (++counter >= PICTURES_DOWNLOADED_MAX)
				break;
		}

		//Visit the correct page and download the pictures
		for (String url : picture_url)
		{
			visit(url);
			windowsMaximize();
			click(DOWNLOAD_HREF);
			click(VIEW_ALL_SIZE_HREF);
			pictURL = MAIN_PHOTO_PICT.getAttribute("src");
			pictFileName = FilenameUtils.getName(pictURL);
			downloadPict( pictURL, Paths.TMP_FOLDER + pictFileName);
		}
	}
}