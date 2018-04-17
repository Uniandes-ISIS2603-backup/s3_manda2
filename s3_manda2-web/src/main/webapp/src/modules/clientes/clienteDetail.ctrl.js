(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clienteContext", "api/clientes");
    mod.controller('clienteDetailCtrl', ['$scope', '$http', 'clienteContext',
        function ($scope, $http, clienteContext) {
            $http.get('data/clienteDetail.json').then(function (response) {
                $scope.clienteDetailRecords = response.data;
            });
        }
    ]);
}
)(window.angular);