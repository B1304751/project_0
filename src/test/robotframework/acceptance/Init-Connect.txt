*** Settings ***
Library    com.robotframework.ConnectDatabase    
*** Test Cases ***
Initalizing database connection for pass
    ${status}  Init Connect    root    admin    Hibernate_JPA
    Run Keyword If    '${status}' == 'Connected'    Log  "Test passed"    
Initalizing database connection for fail
    ${status}  Init Connect    root    1234    Hibernate_JPA
    Run Keyword If    '${status}' == 'Unable to build entity manager factory'    Log  "Test passed! Invalid user or pass!"  