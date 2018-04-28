(function (ng) {
    let mod = ng.module('billeteraModulo');
    mod.constant("billeteraContext", 'api/billeteras');
    mod.controller('billeteraCtrl', ['$scope', '$http', "billeteraContext",
        function ($scope, $http, billeteraContext) {
            $http.get(billeteraContext).then(function (response) {
                $scope.billeterasRecords = response.data;
            });
        }

    ]);
})(window.angular);