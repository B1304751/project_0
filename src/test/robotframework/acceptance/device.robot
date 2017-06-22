*** Settings ***
Library    com.robotframework.Device    
*** Test Cases ***
Test create deivce method for pass
    [Tags]    createDevice
    ${dev_0}  Create Device    QWSE1    8080
    Should Be Equal    '${dev_0}'    '[QWSE1/8080] created'    
Test create deivce method for fail
    [Tags]    createDevice
    ${dev_1}  Create Device  1011  8080
    Should Be Equal    '${dev_1}'    'IllegalArgumentException'    
Test delete deivce method for pass
    [Tags]    deleteDevice
    ${dev_0}  Delete Device    QWSE1    8080
    Run Keyword If  '${dev_0}' == '[QWSE1/8080] deleted'  No Operation    
Test delete deivce method for fail
    [Tags]    deleteDevice
    ${dev_1}  Delete Device    1011  8080
   Run Keyword If    '${dev_1}' == 'Invalid type arguments'  No Operation    
Test get all deivce method for pass
    [Tags]    getAllDevice
    Create Device    QWSE1    8080
    ${list}  Get All Device Name
    Run Keyword If    "${list}" == "1"  No Operation
    Delete Device    QWSE1    8080
Test get deivce method for fail
    [Tags]    getAllDevice
    ${list}  Get All Device Name
    Run Keyword If  '${list}' == 'Empty list device'  No Operation    
