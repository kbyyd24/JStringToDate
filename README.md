# String to Date

把`String`类型表示的日期转换为日期类型

支持时间戳和有一定格式类型的转换

> 如果是有一定类型的日期字符串，仅支持用空格分隔日期和时间，支持任意字符串分隔日期，仅支持":"分隔时间

### demo
```java
DateTransfer dateTranfer = new DateTransfer("2016/04/22 19:26:35", DateTransfer.formatType, "/");
dateTransfer.transform();
Calendar calendar = dateTransfer.getCalendar();
```