# Beacon_application
<br /> Application counts the number of characters in the OutputValue of the Randomness Beacon
<br /> For run application use command: 

<br /> 1. mvn compile from root folder
<br /> 2. run mvn exec:java -Dexec.mainClass="src.main.java.beacon_application.BeaconApp"

<br /> Spent time ~4h

# Task Requirements
<br /> Written in any language that you prefer
<br /> It must run on *nix OS, and shouldn't require any unusual binaries
<br /> Code should be covered by Unit/Integration tests
<br /> Don't feel obligated to solve this problem using just the some standard library. Part of engineering is knowing when to include 3rd party modules. In particular, if you know a good alternative to standard libraries, feel free to include it.
<br /> The Randomness Beacon: Sampling Chaos
The National Institute of Standards and Technology broadcasts a signed, timestamped random bit sequence once a minute, every minute, and has since Unix epoch time 1378395540 (09/05/2013 11:39 a.m.). It's called the Randomness Beacon, and you're going to analyze it.
The Randomness Beacon publishes a RESTfulAPI, through which you can retrive any given minute's beacon value as 128 hexidecimal characters, as well as a variety of other authentication data. Your first goal is to summarize the beacon's emissions over arbitrary amounts of time.
That program should retrieve the most recent event from the randomness beacon, and count the number of characters in the OutputValue the beacon returns. It should then print that output to standard out in comma-delimited format.
<br /> Example: If the randomness beacon returned the string "01AF04F" for its OutputValue, your application should print:
<br /> 0,2
<br /> 1,1
<br /> 4,1
<br /> A,1
<br /> F,2


<br /> The first value of any given line is a character. The second value is the number of times that value occurred in the OutputValue string.
<br /> Deliverables
<br /> Code as a github project
<br /> Installation (if needed) and running instructions in README.md
<br /> Tests
<br /> Information about spent time

