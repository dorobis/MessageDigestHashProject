package proto.mdhash;

import java.io.File;

public class ComputeFileHash {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int argCtr = 0;
		File targetFile = null;

		try {
			FileMessageDigestBean fileMessageDigester = new FileMessageDigestBean(
					IMessageDigestConstants.ALGORITHM_MD5);
			while (argCtr < args.length) {
				try {
					targetFile = new File(args[argCtr]);
					System.out.println(
							args[argCtr] 
							     + " --> " 
							     + fileMessageDigester.getHashValue(targetFile)
							     );
				}
				catch(Exception e) {
					System.out.println(
							"Can't get " 
							+ fileMessageDigester.getMessageDigestAlgorithm() 
							+ " hash value for file "
							+ args[argCtr]
							+ ":"
							+ e.getMessage()
							);
				}
				finally {
					argCtr++;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception thrown - " + e.getMessage());
		}
	}

}
