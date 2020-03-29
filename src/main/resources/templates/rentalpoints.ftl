<#import "parts/common.ftl" as c>
<@c.page>
    <div>
        <table border="1">
            <tr>
                <th>id</th>
                <th>Пункт проката</th>
            </tr>
            <#list messages as message>
                <tr>
                    <td>${message.id}</td>
                    <td><span>${message.pointName}</span></td>
                </tr>
            <#else> No message
            </#list>
        </table>
    </div>
</@c.page>
