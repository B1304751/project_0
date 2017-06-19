*** Settings ***
Library    com.robotframework.Demo
*** Variables ***
${/zero}  "/ by zero"
*** Test Cases ***
Test addition method
    ${sum}  Addition    9    9
    Run Keyword If    '${sum}' == '18'    Log  "Test passed"
Test division method for pass
    ${div}  Division  4  2
    Run Keyword If  '${div}' == '2.0'  Log  "Test passed"
Test division method for fail
    ${div}  Division  4  0
    Run Keyword If    '${div}' == '${/zero}'    Log    "Test passed! Division by zero exception"       
Test count method
    ${count}  Count    4    6
    Run Keyword If    '${count}' == '-2'    Log  "Test passed"            
