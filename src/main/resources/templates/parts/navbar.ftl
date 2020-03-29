<#import "loginTemplate.ftl" as l>

<#include "security.ftl">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Cars Rental Spring app project</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main">Прокат автомобилей</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/carstable">Список автомобилей</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/rentalpoints">Список пунктов проката</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customers">Список арендаторов</a>
                </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3">Пользователь: ${name} </div><#if isAdmin> <@l.logout /></#if>
    </div>
</nav>