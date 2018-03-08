# EMVCoParser
| Tag | Len | Subtag | Len | Value |
| --- | ---- | --- | --- | --- |
| 01 | 07 | - | - | JohnDoe |
| 02 | 08 | - | - | MarieAnn |
| 03 | 09 | 01 | 07 | Jakarta |
| 04 | 09 | 02 | 07 | Bangkok |

A QR Code is an ISO 18004-compliant encoding and visualization of data. And then EMV technologies create specifications pertaining to the use of QR Code for payment purposes. Above are example of EMVCo QR mapping result. And this library are created to parsing those EMVCo Spesification. 

# How to use
Example : You want to get value JAKARTA, then you should know the Tag, and Subtag of it. In case JAKARTA the tag is 03 and the subtag is 01.
Here is you qr string :
```
String qrString = "0107JohnDoe0208MarieAnn03090107Jakarta04090207Bangkok";
```
And if your tag and subtag refer to table above are seems like bellow :
```
int tag = 01; int subtag = 03;
```
What will you do are familliar with this :
```
String result = new EMVCoParser(qrString, tag, subtag).getParsingValue();
```
and if you have a subtag to return, then just do it.
```
String result = new EMVCoParser(qrString, tag).getParsingValue();
```

Have a good code!
It just a simple library for simple purpose. So feel free to advise me.


