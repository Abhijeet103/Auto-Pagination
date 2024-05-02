# Auto Pagination Library
Pagination of an API can be straightforward when using Spring Data. However, when dealing with protocols like LDAP or legacy systems lacking clear organization, pagination becomes challenging. This library simplifies the process, enhancing your workflow. It handles the pagination of your controller output, typically of type List<T>, and incorporates caching to improve performance.

# How to use it 

1) git clone
2) mvn install
3) include dependency
  <dependency>
    <groupId>com.autopagination</groupId>
    <artifactId>page</artifactId>
    <version>1.0.0</version>
</dependency>

4) make your controller pageable 
     @GetMapping("/employee")
public List<Employee> getAllEmployees(Pageable pageable) {
    // Your implementation here
}

5) add  this in your main application file
   @ComponentScan(basePackages = {"your package ", "com.autopagination.page"})


This will paginate your output in 3 steps and also perform caching  
note : Pagable interface is from spring data common  library 


