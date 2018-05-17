(function (ng) {
    var mod = ng.module("cuentaModule");
    mod.constant("cuentaContext", "api/cuenta");
    mod.controller('cuentaCtrl1', ['$scope', '$http', 'cuentaContext','$state','currentUser',
        function ($scope, $http, cuentaContext, $state, currentUser) {
            alert(123);
            $scope.usuarioActual =undefined;
           
                $http.get('clientes/1000').then(function (response) {
                    console.log(1);
                    $scope.usuarioActual = response.data;
                    console.log(response.data);
                });
            
        }
    ]);
}
)(window.angular);