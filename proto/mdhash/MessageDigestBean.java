package proto.mdhash;

/*
 * Created on Aug 11, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.security.MessageDigest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.StringBuffer;
import java.lang.Integer;

/**
 * @author p6248e9
 *
 * MessageDigestBean
 * 
 * This class is responsible for calculating hashes 
 * for a message digest specifed algorithm.
 */
public class MessageDigestBean implements IMessageDigestConstants {
	
	private final MessageDigest md;
	
	/**
	 * <pre>
	 * MessageDigestBean
	 * default ctor implementing MD5 algorithm.
	 * </pre>
	 */
	public MessageDigestBean() throws Exception {
		this.md = MessageDigest.getInstance(ALGORITHM_MD5);
	}
	
	public MessageDigestBean(String mdAlgorithm) throws Exception {
		try {
			this.md = MessageDigest.getInstance(mdAlgorithm);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public String getMessageDigestAlgorithm() {
		return md.getAlgorithm();
	}
	
	protected String calculateMessageDigest(ByteArrayOutputStream bos) {
		int idx = 0;
		byte[] result = md.digest(bos.toByteArray());
		StringBuffer sb = new StringBuffer();

		int aByte = 0;
		int bByte = 0;
		for (idx = 0; idx < result.length; idx++) {
			aByte = bByte = new Byte(result[idx]).intValue();
			aByte >>= 4;
			sb.append(Integer.toHexString(0x0000000f & aByte));
			sb.append(Integer.toHexString(0x0000000f & bByte));
		}
		
		return sb.toString();
	}

	public String getHashValue(InputStream inputStream) throws Exception {
		int count = inputStream.available();
		ByteArrayOutputStream bos = new ByteArrayOutputStream(count);
		int available = inputStream.available();
		if (available > 0) {
			byte[] inputBuffer = new byte[available];
			int len = 0;
			while ((len = inputStream.read(inputBuffer)) != -1) {
				bos.write(inputBuffer, 0, len);
			}
		}
		
		return calculateMessageDigest(bos);
	}
}
