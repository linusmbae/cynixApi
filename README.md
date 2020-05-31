# Project Name
####[cynixApi](https://github.com/linusmbae/cynixApi.git)
# Author Name
Mbae Linus Mutugi

# Project Setup
### Database Setup
Click [here](https://www.postgresql.org/download/) to install postgreSQL if you don't have one.

for ubuntu users use the following in the terminal:

> sudo apt-get update

> sudo apt-get install postgresql postgresql-contrib libpq-dev

 ##### creating database
* open your terminal and paste the following:
> psql <destroy.sql 

* This will destroy the databases created with same name

> psql <create.sql

* This will create all tables required for the system

### cloning project

Click [here](https://github.com/linusmbae/cynixApi.git) and fork this repository to your github.

Copy the clone link.

Navigate through your local storage to your favourite directory using terminal.

Clone the App to your local storage and launch it using the inteliJ IDEA.
 
 
 # Getting things ready
 * navigate to your project and make necessary changes to the following files;
 #### path
 > CynixApi/src/main/java/App

>>  String connectionString = "jdbc:postgresql://localhost:5432/cynix_database";

>>  Sql2o sql2o = new Sql2o(connectionString, "user", "pass");

> CynixApi/src/test/java/models/dao/

* make necessary changes to the database links in the test files

>>  String connectionString = "jdbc:postgresql://localhost:5432/cynix_test_database";

>>  Sql2o sql2o = new Sql2o(connectionString, "user", "pass");

 ## Live Link
 Live Link ~ [Home](https://cynix-shop.herokuapp.com/)
 
 ### How to use app in heroku
 
 You can use postman to test the following keys.
 * Download postman [here](https://www.postman.com/downloads/) if you don't have it.
 
 Steps on how to use the API
 
 *Replace ":id" with the id you intend to use eg (https://cynix-shop.herokuapp.com/shop/1)
 
  SHOPS
 * New Shop 
 > https://cynix-shop.herokuapp.com/shops/new (Method~Post)
* Fetch All Shops
 > https://cynix-shop.herokuapp.com/shops (Method~get)
* Fetch Shop By Id
> https://cynix-shop.herokuapp.com/shop/:id (Method~get)
* Remove Shop By Id
> https://cynix-shop.herokuapp.com/shop/:id/remove (Method~Post)
* Clear The Database
> https://cynix-shop.herokuapp.com/shop/clear (Method~Post)

FASHIONS
* MEN'S WEAR

* New Wear
> https://cynix-shop.herokuapp.com/fashion/men/new (Method~Post)
* Fetch All Men's Wear
> https://cynix-shop.herokuapp.com/fashion/men (Method~get)
* Fetch Men's Wear By Id
> https://cynix-shop.herokuapp.com/fashion/men/:id (Method~get)
* Remove Men's Wear By Id
> https://cynix-shop.herokuapp.com/fashion/men/:id/remove (Method~Post)
* Clear The Database
> https://cynix-shop.herokuapp.com/fashion/men/clear (Method~Post)
 
## Reach me
[Email](linusmutugi5178@gmail.com) 

# CopyRight & License
MIT License

#### Cynix-Shop-Api

Copyright (c) [2020] [Linus Mutugi Mbae]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
