# version 1
## Simple java application using jdbc template to insert data in mysql database;

# version 2
## Converting the simple java application to java spring application

# version 3
## replacing xml configuration with annotation (spring)

# version 4
## adding code for delete, select, insert in batch 


# Eclipse Shortcuts
## ctrl + shift + f --------> format the code
## ctrl + shift + o --------> remove unnecessary imports


# Add spring support in eclipse 
##	 Spring Roo is a Rapid Application Development (RAD) tool that aims to deliver fast, and instant results focused on Spring web applications and newer Spring technologies. It allows us to generate boilerplate code and project structure for Spring applications with simple to use commands.
##	 Roo can be used as a standalone application running from the operating system command line. There's no requirement to use Eclipse, Spring Tool Suite (STS) or any other IDE; in fact, we can use any text editor to write code!
###    Help > Eclipse market.
###	   Type spring and search.
###    Find Spring IDE Roo Support and click install.
###    Accept terms and click finish.
###    Restart Eclipse.
###    File > New > Others > Spring > Spring Bean configuration file.


# Difference between jdbcTemplate vs NamedParameterJdbcTemplate


When you use JdbcTemplate you give it SQL that has a ? placeholder for each parameter you want substituted into the SQL. When you assign parameters in the code you have to pass in arguments in an array and they get used in the order in which they appear in the array, like this:

Object[] args = new Object[] {"x", "y"};
String sql = "select * from foo where a = ? and b = ?";
jdbcTemplate.query(sql, args, resultSetExtractor);

so the SQL that gets run is select * from foo where a = 'x' and b = 'y'.

NamedParameterJdbcTemplate allows you to assign names to the parameter placeholders and pass in a map so the template can match the map names to the placeholders. So your code would look like:

String sql = "select * from foo where a = :mya and b = :myb";
Map<String, Object> argMap = new HashMap<String, Object>();
argMap.put("mya", "x");
argMap.put("myb", "y");
namedParameterJdbcTemplate.query(sql, argMap, resultSetExtractor);

generating the same SQL as the first example.
Running the query is the time-intensive part, the performance of the argument insertion is a non-issue.

The idea is that matching the arguments by name is less error-prone than having to specify them in a particular order. In real-life applications I've worked on, typically we store the SQL in a separate file from the DAO code, and it may be easy to accidentally get the parameters in the wrong order.


# @Component vs @Repository and @Service in Spring
### @Componenet
We can use @Component across the application to mark the beans as Spring's managed components. Spring only pick up and registers beans with @Component  and doesn't look for @Service and @Repository in general.
They are registered in ApplicationContext because they themselves are annotated with @Component.
@Service and @Repository are special cases of @Component. They are technically the same but we use them for the different purposes.
### Repository
@Repository’s job is to catch persistence specific exceptions and rethrow them as one of Spring’s unified unchecked exception.
### Service
We mark beans with @Service to indicate that it's holding the business logic. So there's not any other specialty except using it in the service layer.


