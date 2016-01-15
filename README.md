# extractable_v0.1

Extract a large table into CSV file.

ETL testing involves comparing source files with the loaded staging tables. Often the source files contains large data rows. Testing the flat load from source files to staging table requires one to one row comparison. Extracting the large table into CSV or excel files is challenge because of buffer size and cache limits of database tools. It gets more complicated when there is no unique keys in the data. The developed system resolves this problem and also provides a very flexible set of opportunities to get it done in few seconds.

# System Requirements
JRE 7 or above

# Getting Started
•	Unzip the downloaded package at your desired directory.

•	Configure the db file available under resources/ directory. (Follow configuration guide given in next topic.)

•	Open command prompt.

•	Go to the directory where the package is unzipped.

•	Run the command in command prompt: java –jar extractable_v0.1.jar 

•	Your desired CSV files will be created in your root directory.

# db properties Configuration Guide

The file contains database and other configurations:

•	Database configuration:

DB_DRIVER_CLASS=com.mysql.jdbc.Driver

DB_URL=jdbc:mysql://<database-server-ip>:<port>/<database-name>

DB_USERNAME=<user-name>

DB_PASSWORD=<password>

•	This is the table you want to extract:

TABLENAME=<table-name>

•	This is the column name, if you want to split your files on based of some column values.

COL=<column-name>

•	Provide values (or set of values) for the splitting column.

GRP1='3','4'

GRP2='17'

GRP3=

GRP4=

•	If you leave all GRP variable blank, one file will be created with all data.

•	Otherwise: Files with GRP values will be created,

•	One more file will be created with NOT IN given values.



Few notes: 

•	No Comma at the end. (eg. ‘1’,’2’,) 

•	No blank GRP in between. (eg. GRP1=<blank> GRP=’1’,’2’)

•	One more file will be created with NOT IN given values.


Please feel free to suggest an improvement. 

