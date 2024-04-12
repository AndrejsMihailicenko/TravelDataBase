# TravelDataBase
## Overview
TravelData is a console-based application developed for a university project. The program manages a database of travel information, which includes travel identifier, city, date, number of days, price, and mode of transport. This information is stored and manipulated within a .csv file, db.csv, located in the current directory of the application.
## Features
TravelData supports various operations to interact with the travel database:

- Viewing travel data in a tabulated format.<br>
- Adding new travel entries to the database.<br>
- Deleting existing travel entries based on their unique identifier.<br>
- Editing details of existing travel entries.<br>
- Sorting travel entries by date in ascending order.<br>
- Finding travel entries where the price does not exceed a specified value.<br>
- Calculating the average price of all travel entries.<br>

## Requirements
Java Runtime Environment (JRE) to run the Java application.

## Usage

```
git clone https://github.com/AndrejsMihailicenko/TravelDataBase.git
cd TravelDataBase
javac Main.java
java Main
```

## Examples
After starting the application, you can enter commands according to the supported features. For example:
```
add 200;Riga;01/12/2024;3;100.00;BUS
```

## Supported Commands

add <id>; <city>; <date>; <days>; <price>; <vehicle>: Adds a new travel entry.<br>
del <id>: Deletes a travel entry by its identifier.<br>
edit <id>; <city>; <date>; <days>; <price>; <vehicle>: Edits an existing travel entry. Partial edits are supported; leave fields blank to retain existing values.<br>
print: Displays all travel entries in a tabulated format.<br>
sort: Sorts all travel entries by date in ascending order.<br>
find <price>: Finds all travel entries with a price less than or equal to the specified amount.<br>
avg: Calculates and displays the average price of all travel entries.<br>
exit: Exits the application and saves changes to the database.<br>

