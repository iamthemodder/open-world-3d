/**
 * @author Alex Martin
 */
package ca.iamthemodder.a3dgame.main;

import java.sql.Date;
import java.time.Instant;

/**
 * @author Alex Martin
 *
 */
public class Logging {

	public static void info(String info) {
		System.out.println("[" + Date.from(Instant.now()).toString() + "]" + "[INFO]: " + info);
	}
	
	public static void warn(String warn) {
		System.err.println("[" + Date.from(Instant.now()).toString() + "]" + "[WARNING]: " + warn);
	}
	
	public static void crit(String crit) {
		System.err.println("[" + Date.from(Instant.now()).toString() + "]" + "[CRITICAL]: " + crit);
	}
	
}
