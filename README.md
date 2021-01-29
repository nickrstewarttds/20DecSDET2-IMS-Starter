Coverage: 54.4%
# IMS Database 

This project involves creating a database which takes in user input to allow them to create a customer, an item(s) and an order containing the customer and the item(s) they have purchased.

## Getting Started
To start, fork this repo and start up a git Bash, clone my url and set it yourself as the remote origin and my forked repo as the upstream. Once that has been done you can fetch from upstream and do a git pull to recieve any updates that I may have made on this repo. After that open your IDE and you should be able to run and use the IMS.


### Prerequisites


```
sql is required for this database, can be downloaded on mysql (any version is ok, I have 8.023).
Java is required to implement this code and run it, can find the install at oracle.com
Sonarqube can be used download of sonarqube website as free download.
```

### Installing

The development environment I used is known as Eclipse. To start with eclipse you will want to save a workspace. Mine is normally within my dektop to allow for easy access, the forked and cloned repo can be found on the left had side of the screen in an area known as package explorer. From there you can open up any files within the project and if you want to run the database go into the runner.java file and start any program.
```
1) Go to eclipseIDE.org and find the latest eclipse update to download.
2) wait for the download to finish and save it to an easily accessible location.
3) once downloaded open the file and then a prompt will appear to allow you to save a workspace
4) for convenience I put mine in desktop however it can be wherever you want.
5) the steps should be complete and you should now have a runing IDE
```

And repeat

```
steps 1-5

until finished
```

## Running the tests

To run any of the tests, you must first go into the src/test/java folder. From here you can right click on that folder and then do as follows;
run as coverage -> J unit application
To run an individual test, say for example customerDaoTest, you will navigate to src/test/java -> com.qa.ims.persistence.dao -> customerDaoTest
no right click on the file and select run as coverage as above.
This wil now show the test covered onlu for this file.

### Unit Tests 

Explain what these tests test, why and how to run them
The tests will each cover a method found within the original src/main/java classes. For example, customerDaoTest, will test a method found withing customerDao.
We run these tests to confirm that the program is working as we expect it to and to resolve any issues these tests may fine. The process to run these tests can be found above in ## Running the tests.

```->
public class CustomerDAOTest {


    private final CustomerDao DAO = new CustomerDao();

    @Before
    public void setup() {
        DatabaseUtilities.connect();
        DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql"); 
    }

    @Test
    public void testCreate() {
        final Customer created = new Customer(2L, "alan", "turner");
        assertEquals(created, DAO.create(created));
    }
```

### Integration Tests 
Integration tests are used to run on classes which implement multiple different methods and reach from different classes. This is done by using a maven dependency for Mockito which is the integration test format that is used.

```
not used as of yet
```

### And coding style tests

These are simple tests run to check if the methods within a class are running and implemented correctly, very similar to the description in ## Unit Tests.

```

```

## Deployment

To provide your projects with any updates made from this repo. Always do a git fetch upstream and git pull -u to allow for updates to be committed.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Arsalan Asad** - *development and testing of code* (https://github.com/QA-ArsalanAsad/)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Nicholas Johnson for providing aid in times of difficulty and allowing a small source from his code
* *inspiration- QA, Nicholas Johnson and Pawel for providing me with tools to complete this task
* My team who helped push each other to do better.
