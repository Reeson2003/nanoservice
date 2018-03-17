#NanoService
##Описание

Прототип сервиса для пересылки сообщений подписчикам.

Для использования API сервиса необходимо реализовать интерфейсы:
* `Message`
* `Subscriber`
* `Topic`

В интерфейсах `NanoService` и `MessageBroker` уже реализованы методы по умолчанию.

Для работы сервиса необходимо резализовать интерфейсы:
* `MessageTransport` - для непосредственной отсылки сообщений через сеть
* `SubscriberStore` - для сохранения всей информации о подписчиках, необходимой для отсылки им сообщений

В сервисе не реализована работа с базой данных для сохранения подписчиков на топики. Есть реализация 
`InMemoryTopicSubscriberMap` которая работает в памяти. Для реализации сохранения подписчиков в базу данных
можно сделать реализацию интерфейса `TopicSubscriberMap`.

Перед использованием сервиса надо проинициализировать `ServiceLocator` метод `init`.

Пример работы с сервисом приведен в пакете `demo` все классы с префиксом `Mock`. Пример инициализации `ServiceLocator` 
в методе `main` класса `Main`

##Сборка и запуск

Для сборки проекта необходимо выполнить:

`gradlew build`

Для запуска необходимо выполнить:

`java -jar build/libs/nanoservice.jar`