*** Settings ***
Test Setup  Initalazing connection database
Test Teardown    Clean connection database
Library    com.robotframework.Device    
Library    com.robotframework.ConnectDatabase    
*** Test Cases ***
Get all device available
     [Tags]    deviceNumber
    ${list}  Get All Device Name 
    ${size}  Get Length    ${list}
    Should Be True    ${size} > 0  
*** Keywords ***
Initalazing connection database
    ${init}  Init Connect    root    admin    Hibernate_JPA
    Should Be Equal    '${init}'    'Connected'    
    ${dev_0}  Create Device    AWSD1    8080
    Should Be Equal    '${dev_0}'    '[AWSD1/8080] created'    
     ${dev_1}  Create Device    AWSD2    8080
    Should Be Equal    '${dev_1}'    '[AWSD2/8080] created'   
Clean connection database
    ${dev_0}  Delete Device    AWSD1    8080
    Should Be Equal    '${dev_0}'    '[AWSD1/8080] deleted'    
    ${dev_1}  Delete Device    AWSD2    8080
    Should Be Equal    '${dev_1}'    '[AWSD2/8080] deleted'
    Run Keyword And Expect Error   Empty list device  Get All Device Name
