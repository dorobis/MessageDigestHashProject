package proto.mdhash.test;

import proto.mdhash.FileMessageDigestBean;
import java.io.File;
import java.lang.Exception;
import junit.framework.TestCase;

public class TestMessageDigestHash extends TestCase {

	public void testHashValueCalculation() {
		try {
			FileMessageDigestBean mdCalculator = new FileMessageDigestBean(
					"MD5");

			assertEquals("testHashValueCalculation.assertEquals",
					"31147cb998eaa9ee30cda279cf607591", mdCalculator
							.getHashValue(new File(
									"c:/downloads/db-derby-10.4.2.0-bin.zip")));
		} catch (Exception e) {
			System.out
					.println("TestMessageDigestHash.testHashValueCalculation :Exception:"
							+ e.getMessage());
		}
	}
}
