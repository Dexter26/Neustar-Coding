Neustar Category Counter Application

Overview:
Read a file (name passed in as 1st argument to program).  Each line of the file has a category, a space, and a sub-category (sub-category can have whitespace within it).  Want to:
- Only process the pair (category, sub-category) once
- If a pair appears twice, ignore the second one
- Keep track of the order of the first occurrence of each pair
- Keep track of the count for each category
- Legal category values are: PERSON PLACE ANIMAL COMPUTER OTHER
- Illegal category values should be ignored

Requirements:
- JDK (version 8 or later)
- Apache Maven (version 3.8.0 or later)

Settings:
- Set JAVA and MVN bin paths and verify the versions.

Guidelines:
1. Run "maven-build.sh" shell script  which will build the jar and copies the dependencies to the executable jar.
2. Run "runMe.sh" shell script which will run the program with file named "givenInput.txt" as input argument

Approaches and Decisions taken:
1. Considering this coding assignment as a POC, I wanted to showcase my software engineering practices by developing a complete Java application that can be deployed on other environments as an executable jar. I have put together a finished project document which covers everything from JavaDoc to installation/run steps.
2. Writing this code logic in Java gives us some additional advantages such as future proofing for rest API, bundling as micro-service with Springboot framework or integrating with present code base etc,.
3. Configured maven as a build automation tool which performs steps such as - Download and install dependencies, compile, package the resources, run tests suite and build/bundle with executable jar (Entry point - main.class)
4. Configured and used log4j logging utility which appends logs to file with RollingFileAppender policy (Disable console output for demonstration purpose)
5. Used JUnit5 (JUnit Jupiter) to write various unit tests. (Maven will run these automated tests during build process)
6. For the detailed code logic decisions, please refer to JavaDoc(comments) in the source code provided.

Author - Anup Lingaraj