<#import "parts/common.ftl" as c>
<#import "parts/loginTemplate.ftl" as l>

<@c.page>
Add new user
${message}
<@l.login "/registration" />
</@c.page>