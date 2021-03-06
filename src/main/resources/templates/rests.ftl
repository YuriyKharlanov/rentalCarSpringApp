<#import "parts/common.ftl" as c>

<@c.page>
    <p>На этой странице демонстрируется пример REST API способ получения данных таблицы "Список арендаторов" (Customers)
        с помощью обращения к серверу по адресу <a href="/rest">/rest</a>. Сервер отдает JSON и данные показываются в виде
        удобочитаемого списка из исходных данных с помощью Vue.js.<br>
        Функционал предусматривает и изменение данных по REST API (отключено) </p>
    <div id="app">
    </div>
    <script src="/js/main.js"></script>
</@c.page>