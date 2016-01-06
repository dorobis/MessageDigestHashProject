package proto.mdhash;

import java.io.File;

public class VerifyFileHash {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int argCtr = 0;
		File targetFile = null;

		try {
			FileMessageDigestBean fileMessageDigester = new FileMessageDigestBean(
					IMessageDigestConstants.ALGORITHM_MD5);
			try {
				targetFile = new File(args[0]);
				String fileHash = fileMessageDigester
						.getHashValue(targetFile);
				System.out.println(args[0]
						+ " hash value "
						+ (fileHash.equalsIgnoreCase(args[1]) ? " Matches "
								: " Does Not Match ") + args[1]);
			} catch (Exception e) {
				System.out.println("Can't get "
						+ fileMessageDigester.getMessageDigestAlgorithm()
						+ " hash value for file " + args[argCtr] + ":"
						+ e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Exception thrown - " + e.getMessage());
		}
	}
}
