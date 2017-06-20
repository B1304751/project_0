*** Settings ***
Library    com.robotframework.Device    
*** Test Cases ***
Test create deivce method for pass
    ${dev_0}  Create Device    QWSE1    8080
    Run Keyword If    '${dev_0}' == '[QWSE1/8080] created'   Log  "Test passed"
Test create deivce method for fail
    ${dev_1}  Create Device    1010  8080
   Run Keyword If    '${dev_1}' == "Invalid type arguments"    Log  "Test passed! Happen an exceptions"  
Test delete deivce method for pass
    ${dev_2}  Delete Device    QWSE2    8080
    Run Keyword If    '${dev_2}' == '[QWSE2/8080] deleted'   Log  "Test passed"
Test delete deivce method for fail
    ${dev_1}  Delete Device    1011  8080
   Run Keyword If    '${dev_1}' == "Invalid type arguments"    Log  "Test passed! Happen an exceptions"
Test get all deivce method for pass
    Create Device    QWSE1    8080
    ${dev_3}  Get All Device Name
    Run Keyword If    '${dev_3}' == '[QWSE1/8080]'   Log  "Test passed"
Test get deivce method for fail
    Create Device    "QWSE4"  0
    ${dev_4}  Get All Device Name
   Run Keyword If    '${dev_4}' == 'Empty device list'    Log  "Test passed! Happen an exceptions"       
