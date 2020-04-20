var messageApi = Vue.resource('/rest{/id}');

Vue.component('message-row', {
    props: ['message'],
    template: '<div><i>({{ message.id }})</i> {{ message.fullName }}</div>'
});

Vue.component('messages-list', {
    props: ['messages'],
    template:
        '<div>' +
            '<message-row v-for="message in messages" :key="message.id" :message="message" />' +
        '</div>',
    created: function () {
        messageApi.get().then(result =>
            /*console.log(result)*/
            result.json().then(data =>
                    /*console.log(data)*/
                data.forEach(message => this.messages.push(message))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages" />',
    data: {
        messages: []
    }
});
