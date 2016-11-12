*** Settings ***
Documentation  A resource file containing the application specific keywords
Library     TC_1
Library     Selenium2Library


*** Testcases ***
Войти в личный кабинет

	Sign In  kizkoyuliya@ukr.net    2c35aba5
	Close All Browsers
