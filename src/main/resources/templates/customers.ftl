<#import "parts/common.ftl" as c>
<@c.page>
    <div>
        <table border="1">
            <tr>
                <th>id</th>
                <th>Имя и фамилия арендатора</th>
            </tr>
            <#list messages as message>
                <tr>
                    <td>${message.id}</td>
                    <td><span>${message.fullName}</span></td>
                </tr>
            <#else> No message
            </#list>
        </table>
    </div>
</@c.page>
