(function (ng) {
    var mod = ng.module("paypalModule");
    mod.constant("paypalContext", "api/paypals");
    mod.controller('paypalDetailCtrl', ['$scope', '$http', 'paypalContext', '$state',
    function($scope, $http, paypalContext, $state){
        $http.get("data/billeteras.json").then(function(response){
            billetera = response.data;
            $scope.paypalData = billetera.paypal;
        });
    }]);
})(window.angular);