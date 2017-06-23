*** Settings ***
Test Setup    Open Browser To Specify URL
Test Teardown    Close Browser And Testing
Library  Selenium2Library    
Library  OperatingSystem
Resource    user_data.robot
*** Variables ***
${BROWSER}  Chrome
${GOOGLE}   https://google.com
${SEARCH_KEY}    youtube

*** Test Cases ***
Automation web tetings with Selenium2Library
    [Tags]  webTesting
    Login Gmail
    Search Youtube
    Playing Song On Youtube
*** Keywords ***
Open Browser To Specify URL
    Set Environment Variable    webdriver.chrome.driver    ${EXECDIR}/src/test/resources/robotframework/library/chromedriver.exe
    Open Browser  ${GOOGLE}  ${BROWSER}
    Maximize Browser Window
Close Browser And Testing
    Sleep  2s
    Close Browser
Login Gmail
    Click Element    id=gb_70
    #Input Text    id=identifierId    ${EMAIL}
    Input Text    xpath=//input[@type='email']    ${EMAIL}
    Click Element    id=identifierNext
    Sleep  2s
    Input Password    xpath=//input[@name='password']  ${PASSWORD}
    Click Element    xpath=//*[@id="passwordNext"]/content/span
    Sleep  2s
Search Youtube 
    Go To    ${GOOGLE}
    Input Text    id=lst-ib    ${SEARCH_KEY}
    Sleep  1s
    #Press enter for first result search
    Press Key     xpath=//*[@id="rso"]/div/div/div[1]/div/div/h3/a   \\13
Playing Song On Youtube    
    #Click my music list on youtube home
    Click Element    xpath=//*[@id="VLPLiPopaJ6ym29aFgpkHX6LoAYYtU-nvIop-guide-item"]/a/span/span[2]/span 
    Sleep  2s
    #Click song with name="Có em chờ"
    Click Element    xpath=//*[@id="pl-load-more-destination"]/tr[1]/td[4]/a
    Sleep  20s
    #Click song with name="Đấp mộ cuộc tình"
    Click Element    xpath=//*[@id="playlist-autoscroll-list"]/li[8]/a/div/h4
    Sleep  20s      