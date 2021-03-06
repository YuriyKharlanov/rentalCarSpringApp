<#import "parts/common.ftl" as c>
<#import "parts/inputFormTemplate.ftl" as a>
<@c.page>
    <div>
        <@a.inputRentalCarsinfo />
    </div>

    <div id="resultid1">

    </div>

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
                <td><span><a href="/filter/${message.carsIdNumber}" onclick="AjaxSendURL('/filter/${message.carsIdNumber}');return false;">${message.carsId}</a></span></td>
                <td><i>${message.toRental?date}</i></td>
                <td><i>${message.fromRental?date}</i></td>
                <td><i>${message.customers}</i></td>
                <td><i>${message.rentalPoint}</i></td>
                <td><i>${message.govNumber}</i></td>
            </tr>
            <#else>
            <td colspan="7">No message</td>
                </#list>
            <#--${averTime}-->
        </table>
    </div>
</@c.page>
