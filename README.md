# rentalCarSpringApp
Учебно-тренировочное Java-приложение с web-интерфейсом на Spring-boot c фронтом на Bootstrap + Vui.js + freemaker. Частично реализован RESTapi как демонстрация возможностей spring-boot.

Более подробная информация в СoverNote.txt

Проект написан на java 1.8 и Spring-Boot. Используются Spring Web MVC, Spring Security и другие модули. Зависимости подтянуты с помощью Maven. Для оформления используется Bootstrap. В качестве обработчика шаблонов Freemarker. В проекте на фронте подгружается таблица по конкретной машине с помощью AJAX сиспользованием библиотеки jQuery.
Есть демонстрация получения данных с помощью REST.

База данных была использована PostgreSQL, управление через JPA Hibernate. 

В папке backupDB лежит DUMP DB и выгрузка в виде одного SQL файла и три таблицы по отдельности, а так же Description_ShemaDB.html с описанием схемы DB и связей.
