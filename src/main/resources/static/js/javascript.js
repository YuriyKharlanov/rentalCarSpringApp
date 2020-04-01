
function AjaxSendURL(to) {
    //alert( 'обратились к скрипту' );
    jQuery.ajax({
        //url: "http://192.168.2.22/calls/callback.phtml", //Адрес подгружаемой страницы
        url: to,
        type: "GET", //Тип запроса
        dataType: "html", //Тип данных
        //data: "to=" + to, //.serialize(),
        success: function (response) { //Если все нормально
            document.getElementById(resultid1).innerHTML = response;
        },
        error: function (response) { //Если ошибка
            document.getElementById(resultid1).innerHTML = "Ошибка при отправке формы";
        }
    });
}