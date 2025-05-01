### java.sql.Timestamp – Overview

java.sql.Timestamp is a class from the java.sql package that represents a date and time value, including nanoseconds,
and corresponds to the SQL TIMESTAMP type.

#### Class Declaration

public class Timestamp extends java.util.Date

It extends java.util.Date and adds support for nanoseconds (up to 9 digits of fractional seconds).

#### Purpose

To represent both date and time, including fractional seconds (up to nanoseconds).
Designed for use with SQL columns of type TIMESTAMP (not TIME or DATE).
Used extensively in JDBC to store and retrieve timestamps from databases.

#### Components

Year, month, day
Hour, minute, second
Nanoseconds (0–999,999,999)

#### Common Usage

✅ Create from milliseconds

```
long millis = System.currentTimeMillis();
Timestamp ts = new Timestamp(millis);
```

✅ Set nanoseconds

```
ts.setNanos(123456789);
```

✅ Create from string

```
Timestamp ts = Timestamp.valueOf("2025-04-30 15:45:30.123456789");
```

✅ Convert from LocalDateTime (Java 8+)

```
LocalDateTime ldt = LocalDateTime.now();
Timestamp ts = Timestamp.valueOf(ldt);
```

✅ Convert back to LocalDateTime

```
LocalDateTime ldt = ts.toLocalDateTime();
```

#### Time Zone Notes

Timestamp does not store time zone.
It is interpreted in the JVM's default time zone when converting from Instant, LocalDateTime, or during serialization.
If time zone handling is important, use OffsetDateTime, ZonedDateTime, or Instant.

#### Nanosecond Precision

java.util.Date supports milliseconds, but Timestamp allows nanosecond precision via the nanos field.

However:

Not all databases support nanosecond precision.

JDBC drivers may round/truncate the nanoseconds based on DB support.

#### Deprecated Methods Inherited from java.util.Date

Like other JDBC time classes, many methods like getHours(), getMonth(), etc. are deprecated.

Use the java.time API instead.

#### JDBC Example

```
PreparedStatement ps = conn.prepareStatement("INSERT INTO logs (event_time) VALUES (?)");
Timestamp now = Timestamp.valueOf(LocalDateTime.now());
ps.setTimestamp(1, now);
ps.executeUpdate();
```

#### Comparison Table

```
Class	                    Date	Time	Fractional Seconds	    Time Zone	    Precision	    Since
java.sql.Date	            ✅	    ❌	    ❌	                    ❌	            day	            JDK 1.1
java.sql.Time	            ❌	    ✅	    ❌	                    ❌	            second	        JDK 1.1
java.sql.Timestamp	        ✅	    ✅	    ✅ (nanoseconds)	    ❌	            nanosecond	    JDK 1.1
java.time.LocalDateTime	    ✅	    ✅	    ✅	                    ❌	            nanosecond	    Java 8
java.time.Instant	        ✅	    ✅	    ✅	                    ✅ (UTC)	    nanosecond	    Java 8
```

#### Best Practice

Use java.time.LocalDateTime or Instant in application logic, and only convert to/from java.sql.Timestamp when
interacting with JDBC.