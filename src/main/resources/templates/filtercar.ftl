<#import "parts/common.ftl" as c>
<#import "parts/inputFormTemplate.ftl" as a>
<@c.page>
    <div>
        <table class="mt-2 mb-5" border="">
            <tr>
                <th>id</th>
                <th>Производитель и модель автомобиля</th>
                <th>Дата начала аренды</th>
                <th>Дата возврата из аренды</th>
                <th>Арендатор</th>
                <th>Точка возврата</th>
                <th>Гос. номер автомобиля</th>
            </tr>
            <#list messages as message>
            <tr>
                <td>${message.id}</td>
                <#--<td><span><a href="/filter/${message.carsIdNumber}">${message.carsId}</a></span></td>-->
                <td><span>${message.carsId}</span></td>
                <td><i>${message.toRental?date}</i></td>
                <td><i>${message.fromRental?date}</i></td>
                <td><i>${message.customers}</i></td>
                <td><i>${message.rentalPoint}</i></td>
                <td><i>${message.govNumber}</i></td>
            </tr>
            <#else>
            <td colspan="7">No message</td>
                </#list>
            <#--<span><a href="/main" onclick="AjaxSendURL('/main');return false;">Вернуться в "Прокат автомобилей"</a></span>-->
            <span><a href="/main">Вернуться в "Прокат автомобилей"</a></span>
            Среднее время аренды автомобиля (дней часов:минут): ${averTime?if_exists}
            // TODO (переделать чтобы вывело по каждой точке)
        </table>
    </div>
</@c.page>
