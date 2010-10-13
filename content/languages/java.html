--- 
title: Floating-point cheat sheet for Java
description: Tips for using floating-point and decimal numbers in Java
--- 

Floating-Point Types
--------
Java has [IEEE 754](/formats/fp/) single and double precision types supported by keywords:

		float f = 0.1f; // 32 bit float, note f suffix
		double d = 0.1d; // 64 bit float, suffix optional
		
The `strictfp` keyword on classes, interfaces and methods forces all intermediate results of floating-point calculations to be IEEE 754 values as well, guaranteeing identical results on all platforms. Without that keyword, implementations can use an extended exponent range where available, resulting in more precise results and faster execution on many common CPUs.
		
Decimal Types
-------------
Java has an [arbitrary-precision](/formats/exact/) decimal type named <code>java.math.BigDecimal</code>, which
also allows to choose the [rounding mode](/errors/rounding/).

		BigDecimal a = new BigDecimal("0.1");
		BigDecimal b = new BigDecimal("0.2");
		BigDecimal c = a.add(b); // returns a BigDecimal representing exactly 0.3


How to Round
------------
To get a String:

		String.format("%.2f", 1.2399) // returns "1.24"
		String.format("%.3f", 1.2399) // returns "1.240"
		String.format("%.2f", 1.2) // returns "1.20"
		
To print to standard output (or any <code>PrintStream</code>):

		System.out.printf("%.2f", 1.2399) // same syntax as String.format()
		
If you don't want trailing zeroes:

		new DecimalFormat("0.00").format(1.2)// returns "1.20"
		new DecimalFormat("0.##").format(1.2)// returns "1.2"
		
If you need a specific [rounding mode](/errors/rounding/):

		new BigDecimal("1.25").setScale(1, RoundingMode.HALF_EVEN); // returns 1.2


Resources 
---------
* [Java Language Specification](http://java.sun.com/docs/books/jls/third_edition/html/j3TOC.html)  
   * [Floating-Point Types, Formats, and Values](http://java.sun.com/docs/books/jls/third_edition/html/typesValues.html#4.2.3)
* [Java Standard API](http://java.sun.com/javase/6/docs/api/)
   * [BigDecimal](http://download.oracle.com/javase/6/docs/api/java/math/BigDecimal.html)
   * [DecimalFormat](http://download.oracle.com/javase/6/docs/api/java/text/DecimalFormat.html)
   * [String.format()](http://download.oracle.com/javase/6/docs/api/java/lang/String.html#format(java.lang.String,%20java.lang.Object...))
