package proto.mdhash;

import java.io.ByteArrayOutputStream;

public class StringMessageDigestBean extends MessageDigestBean {
	public StringMessageDigestBean() throws Exception {
		super();
	}

	public StringMessageDigestBean(String mdAlgorithm) throws Exception {
		super(mdAlgorithm);
	}
	
	public String getHashValue(String source) throws Exception {
		int bufferLength = source.getBytes().length;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(bufferLength);
		if (bufferLength > 0) {
			byte[] inputBuffer = source.getBytes();
			bos.write(inputBuffer, 0, bufferLength);
		}
		
		return calculateMessageDigest(bos);
	}
}
