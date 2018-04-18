(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clienteContext2", "api/clientes");
    mod.controller('clienteDetailCtrl', ['$scope', '$http', 'clienteContext2',
        function ($scope, $http, clienteContext2) {
            $http.get('data/clienteDetail.json').then(function (response) {
                $scope.clienteDetailRecords = response.data;
            });
        }
    ]);
}
)(window.angular);