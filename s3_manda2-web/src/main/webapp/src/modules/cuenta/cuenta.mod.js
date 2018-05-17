(function (ng) {

    var mod = ng.module("cuentaModule", ['ui.router']);
    mod.constant("cuentaContext", "api/cuenta");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/cuenta/';

            $stateProvider.state('cuentaDetalle', {
                url: '/cuenta',
                views: {
                    'cuentaView': {
                        templateUrl: basePath + 'cuenta1.html',
                        controller: ['$scope', '$http', 'cuentaContext', '$state', 
                            function ($scope, $http, cuentaContext, $state) {
                                alert(123);
                                $scope.usuarioActual = undefined;

                                $http.get('api/clientes/1000').then(function (response) {
                                    console.log(1);
                                    $scope.usuarioActual = response.data;
                                    console.log(response.data);
                                });

                            }
                        ],
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
