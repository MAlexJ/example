package com.malex.lecture_7_Date.java_time.local_date_time;

import com.malex.utils.AbstractUtils;
import java.time.LocalDateTime;
import org.junit.Test;

/*
* LocalDateTime.toString() follows the ISO-8601 standard, even though it's implemented in Java.
* So while the method is Java-specific, the format is not.
*
* This matches the ISO-8601 date-time format: yyyy-MM-dd'T'HH:mm:ss.SSS
*
* What this means:
* - Interoperable: Can be parsed by most programming languages (Python, JavaScript, etc.).
* - Reliable for APIs: Perfect for JSON, REST, GraphQL, etc.
* - Safe for storage: Databases and logs handle ISO well.
*
* ISO-8601 format pattern yyyy-MM-dd'T'HH:mm:ss.SSS with what each part means:
*

* Pattern	    Meaning                           Example
* yyyy	        4-digit year	                    2025
* MM	        2-digit month (01–12)	            04 (April)
* dd	        2-digit day of the month (01–31)	23
* 'T'	        Literal 'T' separating date/time	T
* HH	        Hour (00–23, 24-hour format)	    14
* mm	        Minutes (00–59)	                    00
* ss	        Seconds (00–59)	                    00
* SSS	        Milliseconds (000–999)	            123
*
* Example:
* 2025-04-23T14:00:00.123
* Means: April 23, 2025, at 2:00:00 PM and 123 milliseconds (in 24-hour format)
* This format is:
*
* Human-readable
* Machine-readable
* Time zone agnostic (unless extended with Z or ±HH:mm)
*/
public class LocalDateTime_class extends AbstractUtils {

  @Test
  public void test() {
    LocalDateTime now = LocalDateTime.now();
    println("ISO-8601 - ", "now:", now);
  }
}
