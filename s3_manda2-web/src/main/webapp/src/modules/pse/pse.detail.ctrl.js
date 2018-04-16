(function (ng) {
    var mod = ng.module("pseModule");
    mod.constant("pseContext", "api/pses");
    mod.controller('pseDetailCtrl', ['$scope', '$http', 'pseContext', '$state',
    function($scope, $http, pseContext, $state){
        $http.get("data/billeteras.json").then(function(response){
            billetera = response.data;
            $scope.pseData = billetera.pse;
        });
    }]);
})(window.angular);