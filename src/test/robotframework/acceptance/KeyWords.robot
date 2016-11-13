*** Settings ***
Library     Keywords
Library     Selenium2Library


*** Keywords ***
Войти в личный кабинет
     [Arguments]               ${type}                ${login}        ${password}
     Sign In                   ${type}                ${login}        ${password}
     Sleep                     2s

Считать детали товара
    [Arguments]                ${url}
    Get Product Details        ${url}
    Sleep                      1s

Считать список просмотренных товаров
    Go To Personal Account
    Recently Viewed

Очистить список ранее просмотренных товаров
    Go To Personal Account
    Recently Viewed
    Delete All Recently Viewed

Сравнение
    [Arguments]         ${url}
    Assertion           ${url}