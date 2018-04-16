(function(ng){
    var mod = ng.module('mediodepagoModule');
    
    mod.controller('mediodepagoDetailCtrl', ['$scope', '$http', 'paypalContext', '$state'],
    function($scope, $http, paypalContext, $state){
        $http.get("data/billeteras").then(function(response){
            
        });
    });
})(window.angular);