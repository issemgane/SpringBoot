'use strict';

gestionApp.factory('appService', function ($resource) {
    return $resource(':resource/:path/:param1/:param2', {resource:'@resource',path:'@path'}, {
        'query': {method: 'GET', isArray: true},
        'get': {
            method: 'GET',
            transformResponse: function (data) {
               
                if(data!==undefined)
                {
                     data = angular.fromJson(data);
                }
               
                return data;
            }
        },
        'getItem': {
            method: 'GET', transformRespons: function (data) {
                return {content: data};
            }
        },
        'save': {// redefine save action defaults
            method: 'POST',
            transformRequest: function (data, headers) {
                headers = angular.extend({}, headers, {'Content-Type': 'application/json'});
                return data // this will go in the body request
            }
        }, 
        'queryPost': {// redefine save action defaults
            method: 'POST',
            transformRequest: function (data, headers) {
                headers = angular.extend({}, headers, {'Content-Type': 'application/json'});
                return data;// this will go in the body request
            }
        },
        'queryJSON': {// redefine save action defaults
            method: 'POST', isArray: true,
            transformRequest: function (data, headers) {
                headers = angular.extend({}, headers, {'Content-Type': 'application/json'});

                return data; // this will go in the body request
            }
        },
        'update': {method: 'PUT'}

    });
});