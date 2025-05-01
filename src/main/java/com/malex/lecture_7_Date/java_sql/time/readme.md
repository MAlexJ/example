### java.sql.Time – Overview

java.sql.Time is a class in the java.sql package that represents only a time value (hours, minutes, seconds),
without a date.
It corresponds to the SQL TIME type in relational databases.

#### Purpose

Used to store and retrieve time-only values (without date or timezone) from a database via JDBC.
Represents a specific time of day in the local time zone, with the date part set to January 1, 1970 (epoch start).

#### Class Declaration

`public class Time extends java.util.Date`

Like java.sql.Date, it extends java.util.Date, but hides the date part.

#### Time Component

Stores:
- Hours (0–23)
- Minutes (0–59)
- Seconds (0–59)

Does not store milliseconds in SQL (but internally may use them).

#### Does Not Handle

- Time zone
- Date
- Localization
- Daylight Saving Time

#### Common Usage

#### Create from milliseconds

```
long millis = System.currentTimeMillis();
java.sql.Time time = new java.sql.Time(millis);
```

#### The date part will be present internally but ignored or hidden.

#### Create from string

```
java.sql.Time time = java.sql.Time.valueOf("15:45:30"); // 3:45:30 PM
```

#### Get values

int hour = time.getHours(); // deprecated
int minute = time.getMinutes(); // deprecated
int second = time.getSeconds(); // deprecated
These methods are deprecated — avoid using them in new code.

#### Modern Usage (Java 8+)

Use java.time.LocalTime and convert when needed:

```
LocalTime localTime = LocalTime.of(15, 45, 30);
java.sql.Time sqlTime = java.sql.Time.valueOf(localTime);
```

Convert back:

```
LocalTime localTime = sqlTime.toLocalTime();
```

#### Important Notes

Always interpreted in JVM's local time zone unless explicitly handled otherwise.
Should be used only for time-of-day without dates (e.g., business hours, alarm clocks).

#### Comparison Table

```
Class	                Date	Time	Time Zone	Recommended
java.sql.Time	        ❌	    ✅	    ❌	        ❌ (legacy)
java.util.Date	        ✅	    ✅	    ❌	        ❌
java.sql.Timestamp	    ✅	    ✅	    ❌	        ✅ (for datetime)
java.time.LocalTime	    ❌	    ✅	    ❌	    ✅ (Java 8+)
```

#### JDBC Example

```
PreparedStatement ps = conn.prepareStatement("INSERT INTO events (start_time) VALUES (?)");
LocalTime startTime = LocalTime.of(9, 30);
ps.setTime(1, java.sql.Time.valueOf(startTime));
ps.executeUpdate();
```
