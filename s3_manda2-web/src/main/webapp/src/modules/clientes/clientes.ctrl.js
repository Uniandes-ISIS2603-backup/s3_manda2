(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clienteContext", "api/clientes");
    mod.controller('clienteCtrl', ['$scope', '$http', 'clienteContext',
        function ($scope, $http, clienteContext) {
            $http.get('http://localhost:8080/s3_manda2-web/api/clientes').then(function (response) {
                $scope.clientesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);