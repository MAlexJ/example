### java.util (legacy, still used)

1. `Date`      Represents a point in time — legacy
2. `Calendar`  Mutable date/time with fields — legacy
3. `TimeZone`  Represents time zones

#### java.util.Date

✅ What it is:

* Represents a specific point in time (milliseconds since January 1, 1970 UTC).
* It has no time zone awareness, and both date and time are included.

❌ Limitations:

* Mutability (unsafe in multithreading)
* Poor formatting support
* Deprecated methods like getYear(), getMonth(), etc.

✅ Example:

```
import java.util.Date;

public class DateExample {
public static void main(String[] args) {
Date now = new Date();
System.out.println("Current date and time: " + now);

        long millis = now.getTime(); // milliseconds since epoch
        System.out.println("Milliseconds since epoch: " + millis);

        Date future = new Date(millis + 1000 * 60 * 60); // add 1 hour
        System.out.println("One hour later: " + future);
    }
}
```

### java.util.Calendar

✅ What it is:

* A more flexible alternative to Date that can represent specific fields like year, month, day, hour, etc.
* Supports locale, time zone, and field-based manipulation.

❌ Limitations:

* Verbose and error-prone
* Months are zero-based (0 = January, 11 = December)
* Also mutable

✅ Example:

```
import java.util.Calendar;

public class CalendarExample {
public static void main(String[] args) {
Calendar calendar = Calendar.getInstance(); // default time zone and locale
calendar.set(2025, Calendar.APRIL, 21); // Year, Month (zero-based), Day

        System.out.println("Date: " + calendar.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, 7); // Add 7 days
        System.out.println("One week later: " + calendar.getTime());

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("Hour of day: " + hour);
    }
}
```

#### java.util.TimeZone

✅ What it is:

* Represents a time zone (like Europe/Moscow, UTC, etc.)
* Used in conjunction with Calendar to handle date-time calculations across zones.

✅ Example:

```
import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneExample {

    public static void main(String[] args) {
        // Get default time zone
         TimeZone defaultZone = TimeZone.getDefault();
         System.out.println("Default TimeZone: " + defaultZone.getID());

        // Set a specific time zone (e.g., UTC)
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        System.out.println("UTC time: " + calendar.getTime());

        // Switch to New York time zone
        calendar.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println("New York time: " + calendar.getTime());
    }
}
```

#### Summary

* `Date`        Simple timestamp (legacy)    Use only when required by APIs
* `Calendar`    Field-level manipulation of date Better than Date but clunky
* `TimeZone`    Time zone representation Works with Calendar, supports DST

🔁 Bonus Tip: Convert Date to LocalDateTime (modern API)

```
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

Date legacyDate = new Date();
LocalDateTime modern = legacyDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
```

Let me know if you want examples combining these with SimpleDateFormat or how to migrate legacy code to java.time.