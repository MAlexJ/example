#### java.time (Java 8+ — modern API)

Recommended API introduced in Java 8 to replace legacy Date and Calendar.

`LocalDate`    Date only (no time)
`LocalTime`    Time only (no date)
`LocalDateTime`    Date and time (no timezone)
`ZonedDateTime`    Date, time, and timezone
`OffsetDateTime`    Date and time with UTC offset
`Instant`    Timestamp in UTC (like Unix epoch)
`Duration`    Time between two moments (hours, minutes, seconds)
`Period`    Date-based amount of time (years, months, days)
`ZoneId`    Time zone ID
`DateTimeFormatter`    Formatting and parsing date/time
`Clock`    Source of time (useful for testing/mocking)
`TemporalAdjusters`    Adjust dates (e.g., first day of month, next Monday)