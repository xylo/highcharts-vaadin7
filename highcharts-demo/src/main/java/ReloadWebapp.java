import java.io.IOException;
import java.util.Date;

/**
 * This is a small utility application that simplifies the development of this add-on.
 * When set up correctly, you only have to start ReloadWebapp from your IDE to compile, deploy and reload
 * the webapp in tomcat.
 * Make sure you configured the <i>scripts/settings.conf</i> properly and have run <i>scripts/linkClasses.sh</i> the first time
 * after you built the project with <i>mvn package</i>.
 *
 * @author Stefan Endrullis (endrullis@iat.uni-leipzig.de)
 */
public class ReloadWebapp {

	public static void main(String[] args) throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec("scripts/copyResources.sh");
		if (process.waitFor() != 0) {
			throw new IOException("Return code not 0");
		}

		Process process2 = Runtime.getRuntime().exec("scripts/reloadTomcatWebapp.sh");
		if (process2.waitFor() != 0) {
			throw new IOException("Return code not 0");
		}

		System.out.println(new Date().toString());
	}

}
