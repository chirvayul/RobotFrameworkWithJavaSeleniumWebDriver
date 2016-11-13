*** Settings ***
Resource            KeyWords.robot

Library     Keywords
Library     Selenium2Library

*** Testcases ***
End-to-end test case

    Войти в личный кабинет                               email       chirvayul+@gmail.com           aA123456
    Очистить список ранее просмотренных товаров
    Считать детали товара                                http://rozetka.com.ua/crocs_15840_4bm_c8/p1769102/
    Считать детали товара                                http://rozetka.com.ua/chicco_010.54683_800_8055344523113/p6547048/
    Считать детали товара                                http://rozetka.com.ua/jerden_proff_4823085609571/p4909981/
    Считать список просмотренных товаров
    Сравнение                                            http://rozetka.com.ua/chicco_010.54683_800_8055344523113/p6547048/

