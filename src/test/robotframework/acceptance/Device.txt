*** Settings ***
Library    com.robotframework.Device    
*** Test Cases ***
Test create deivce method for pass
    [Tags]    createDevice  device
    ${dev_0}  Create Device    QWSE1    8080
    Should Be Equal    ${dev_0}    [QWSE1/8080] created    
Test create deivce method for fail
    [Tags]    createDevice  device
    Run Keyword And Expect Error    IllegalArgumentException    Create Device  1011  8080    
Test delete deivce method for pass
    [Tags]    deleteDevice  device
    ${dev_0}  Delete Device    QWSE1    8080
    Should Be Equal As Strings    ${dev_0}    [QWSE1/8080] deleted    
Test delete deivce method for fail
    [Tags]    deleteDevice  device
    Run Keyword And Expect Error  IllegalArgumentException  Delete Device    1011  8080
Test get all deivce method for pass
    [Tags]    getAllDevice  device
    Create Device    QWSE1    8080
    ${list}  Get All Device Name
    ${size}  Get Length    ${list}
    Should Be Equal As Integers    ${size}    1    
    Delete Device    QWSE1    8080
Test get deivce method for fail
    [Tags]    getAllDevice  device
    Run Keyword And Expect Error    Empty list device    Get All Device Name    
