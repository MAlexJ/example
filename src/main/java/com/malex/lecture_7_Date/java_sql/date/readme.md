#### java.sql.Date – Overview

`java.sql.Date` is a class in the `java.sql` package that represents **only a date** (year, month, day),
without a time component.

It corresponds to the SQL DATE type in databases.

#### Purpose

To handle SQL DATE values when interacting with a relational database via JDBC.
It excludes time-of-day information (unlike java.util.Date or java.sql.Timestamp).

#### Class Declaration

public class Date extends java.util.Date

Despite extending java.util.Date, java.sql.Date overrides some methods to hide the time component.

#### Time Component Behavior

The time part is set to 00:00:00.000 (midnight).
Any time information in the java.util.Date will be truncated when converted to java.sql.Date.

#### Time Zone and Locale

java.sql.Date does not store or handle time zones or locales.

It relies on the JVM system time zone when converting from milliseconds or during display.

#### Common Usage

✅ Create from milliseconds

```
long millis = System.currentTimeMillis();
java.sql.Date sqlDate = new java.sql.Date(millis);
```

✅ Create from LocalDate (Java 8+)

```
LocalDate localDate = LocalDate.now();
java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
```

✅ Convert back to LocalDate

```
LocalDate date = sqlDate.toLocalDate();
```

✅ Create from string

```
java.sql.Date date = java.sql.Date.valueOf("2025-04-30");
```

❌ Deprecated/Overridden Methods

The following java.util.Date methods are deprecated or overridden in java.sql.Date to emphasize that time values are not
used:

```
getHours()
getMinutes()
getSeconds()
```

#### Cautions

Do not use java.sql.Date if your date includes time or time zones.

Use java.time.LocalDate (Java 8+) for most date-only operations.

Be careful with serialization/deserialization (e.g., JSON), as some libraries may incorrectly treat it like a full
DateTime.

#### JDBC Integration Example

```
PreparedStatement ps = conn.prepareStatement("INSERT INTO users (birthdate) VALUES (?)");
LocalDate birthdate = LocalDate.of(1990, 1, 1);
ps.setDate(1, java.sql.Date.valueOf(birthdate));
ps.executeUpdate();
```

#### Comparison With Other Classes

```
Class	                Time	    Time Zone	            Since
java.sql.Date	        No	        No	                    JDK 1.1
java.util.Date	        Yes	        No (uses system TZ)	    JDK 1.0
java.sql.Timestamp	    Yes	        No	                    JDK 1.1
java.time.LocalDate	    No	        No	                    Java 8
java.time.Instant	    Yes	        Always UTC	            Java 8
```

#### Recommended Usage (Java 8+)

Prefer java.time.LocalDate for date-only values, and convert it to/from java.sql.Date only when interacting with JDBC.