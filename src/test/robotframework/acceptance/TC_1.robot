*** Settings ***
Documentation  A resource file containing the application specific keywords
Library     TC_1
Library     Selenium2Library

*** Testcases ***

Войти в личный кабинет	 Sign In                 chirvayul+@gmail.com              aA12345678

Считать детали товара    Get Product Details     http://rozetka.com.ua/brateck_lpa52_446/p9212592/
