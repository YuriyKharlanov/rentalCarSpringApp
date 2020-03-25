<#import "parts/common.ftl" as c>
<#import "parts/loginTemplate.ftl" as l>
<@c.page>
    <div>
        <@l.logout />
    </div>
<div>
    <form method="post">
        <input type="text" name="text1" placeholder="Введите сообщение" />
        <input type="text" name="tag1" placeholder="Тэг" >
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>

<div>Список сообщений</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter}">
    <button type="submit">Найти</button>
</form>
<#list messages as message>
    <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.authorName}</strong>
    </div>
    <#else> No message
</#list>
</@c.page>