# language: ru
@Test
Функция: Создание персонажа
  Предыстория:
    Дано Создаем данные для отправки

  Сценарий: Успешное создание и замена информации
    Когда Делаем запрос на создание юзера, меняем данные
    Тогда Сверяем пришедший ответ с ожидаемым