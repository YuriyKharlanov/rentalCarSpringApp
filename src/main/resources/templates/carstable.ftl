<#import "parts/common.ftl" as c>
<@c.page>
    <div>
    <table border="1">
        <tr>
            <th>id</th>
            <th>Производитель / модель</th>
            <th>Гос. номер</th>
        </tr>
        <#list messages as message>
            <tr>
                <td>${message.id}</td>
                <td><span>${message.vendorModelName}</span></td>
                <td><i>${message.governNumber}</i></td>
            </tr>
        <#else> No message
        </#list>
    </table>
    </div>
</@c.page>
