<!-- Check_VIN -->
<br />
<div align="center">
  <h3 align="center">Check VIN</h3>
</div>


<!-- ABOUT THE PROJECT -->
## О проекте

Проект предоставляет сервис по проверке VIN-номера автомобилей BMW моделей 1991-2010 годов выпуска.

Пользователь взаимодействует с сервисом через Telegram бота, вводя VIN-номер и получая информацию по автомобилю.
Доступная информация об автомобиле через VIN: изготовитель, модель автомобиля и когда выпускался, сборочный завод,
производственный номер изделия и валидность VIN-номера.

Проверка валидности VIN-номера осуществляется по определённому математическому алгоритму, который вычисляет
контрольную цифру и сравнивает с контрольной цифрой, содержащейся в VIN-номере. Если они не совпадают,
тогда VIN-номер считается не валидным.


## Перед тем, как запустить

Необходимо указать token и botUserName своего Telegram бота
в свойствах по пути Bot_Telegram/src/main/resources/config.properties


### Built With

- Telegram Bot API
- Maven
