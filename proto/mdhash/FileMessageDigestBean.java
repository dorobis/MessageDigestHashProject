package proto.mdhash;

import java.io.File;
import java.io.FileInputStream;
import java.lang.Integer;

public class FileMessageDigestBean extends MessageDigestBean {
	public FileMessageDigestBean() throws Exception {
		super();
	}

	public FileMessageDigestBean(String mdAlgorithm) throws Exception {
		super(mdAlgorithm); 
	}
	
	public String getHashValue(File targetFile) throws Exception {
		if(targetFile.length() > Integer.MAX_VALUE) {
			throw new Exception(
					"File size greater than maximum integer value");
		}
		
		FileInputStream fis = new FileInputStream(targetFile);
		return super.getHashValue(fis);
	}
}
