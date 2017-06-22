*** Settings ***
Library    com.robotframework.Demo
*** Test Cases ***
Test addition method
    [Tags]    addition  demo
    ${status}  Addition  9  9
    Should Be Equal As Integers    ${status}    18    
Test division method for pass
    [Tags]    division  demo
    ${div}  Division  4  2
    Should Be Equal As Numbers    ${div}    2.0    
Test division method for fail
    [Tags]    division  demo
    Run Keyword And Expect Error    ArithmeticException    Division  4  0    
Test count method
    [Tags]    count  demo
    ${count}  Count    4    6
    Should Be Equal As Integers    ${count}    -2    