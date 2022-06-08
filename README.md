## Запуск тестов
mvn clean test

## Построение отчетов локально
mvn allure:serve

## Удалить последнюю локальную сборку
mvn clean

## Входные данные
задаются в файле application.properties

## Запуск одного теста
mvn clean -Dtest=ClassName#TestName test,
где TestName - имя класса, в котором лежит нужный тест, а TestName - имя метода теста

## Входные данные
Задаются в файле application.properties

#### Изменений в помнике не совершал


