# Auto Pagination Library

Pagination of an API can be straightforward when using Spring Data. However, when dealing with protocols like LDAP or legacy systems lacking clear organization, pagination becomes challenging. This library simplifies the process, enhancing your workflow. It handles the pagination of your controller output, typically of type List<T>, and incorporates caching to improve performance.

## How to Use

1. **Clone Repository**: Clone the repository from Git.

    ```
    git clone <repository_url>
    ```

2. **Install with Maven**: Install the library using Maven.

    ```
    mvn install
    ```

3. **Include Dependency**: Add the library as a dependency in your project's `pom.xml` file.

    ```xml
    <dependency>
        <groupId>com.autopagination</groupId>
        <artifactId>page</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```

4. **Make Your Controller Pageable**: Modify your controller to incorporate pagination. Add a `Pageable` parameter to the controller method you want to paginate.

    ```java
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(Pageable pageable) {
        // Your implementation here
    }
    ```

5. **Add to Main Application File**: Ensure that the package containing your controllers and the `com.autopagination.page` package are scanned by Spring. Add the following annotation to your main application file.

    ```java
    @ComponentScan(basePackages = {"your_package", "com.autopagination.page"})
    ```

This library simplifies pagination and caching in just a few steps, enhancing the efficiency of your API. Note that `Pageable` interface is from the Spring Data Commons library.
