' use strict';
angular.module('smartWebApp',['base64'])
    .controller('loginCtrl', function ($scope,$base64,$window,$http) {

    $scope.login = function (username,password){
          console.log(window.btoa(username+password));
          console.log(""+username);
          console.log(""+password);

          $http({
            method: 'POST',
            url: '/',
            headers: {'Authorization': window.btoa(username+password)}
          }).then(function successCallback(response) {
                            $window.location.href='/';
                        }, function errorCallback(response) {
                            alert("User not authorized.");
                        });

    }

    });