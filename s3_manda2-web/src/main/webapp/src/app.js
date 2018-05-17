(function (ng) {
    var app = ng.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        // Internal modules dependencies       
        'clienteModule',
        'empleadoModule',
        'reclamoModule',
        'inicioModule',
        'compraModule',
        'compraModule',
        'vueltaModule',
        'paypalModule',
        'pseModule',
        'tarjetacreditoModule',
        'pagoModulo',
        'billeteraModulo',
        'entregaModule',
        'reservasModule',
        'articulosModule',
        'cuentaModule',
        'loginModule'
    ]);
    app.config(['$qProvider', function ($qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
    }]);

    app.controller('ScrollController', ['$scope', '$location', '$anchorScroll', '$state','$rootScope',
        function ($scope, $location, $anchorScroll, $state,$rootScope) {
            $scope.gotoAnchor = function (estado, ancla) {
                $location.hash(ancla);
                $anchorScroll();
                $state.go(estado, {}, {})
            };

            $scope.currentUser = 'hola  ';
        }
    ]);


    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

        $transitions.onSuccess({to: '*'}, function (trans) {

            var $state = trans.router.stateService;
//            var requireLogin = $state.current.data.requireLogin
            var roles = $state.current.data.roles


            /**
             * @ngdoc function
             * @name isAuthenticated
             * @methodOf mainApp.module:mainApp
             * @description Esta función define si el usuario se encuentra
             * dentro de su cuenta.
             * @returns {Boolean} Verdadero si está dentro de su cuenta.
             */
            $rootScope.isAuthenticated = function () {

                if (sessionStorage.getItem("username") != null) {
                    $rootScope.currentUser = sessionStorage.getItem("name");
                    return true;
                } else {
                    return false;
                }
            };

            /**
             * @ngdoc function
             * @name hasPermissions
             * @methodOf mainApp.module:mainApp
             * @description Esta función define si el usuario tiene permisos
             * para acceder a la aplicación.
             * @returns {Boolean} Verdadero si el usuario tiene permisos.
             */
            $rootScope.hasPermissions = function () {
                if (($rootScope.isAuthenticated) && (roles.indexOf(sessionStorage.getItem("rol")) > -1)) {
                    return true;
                } else {
                    return false;
                }
            };


            if (requireLogin && (sessionStorage.getItem("username") === null)) {
                event.preventDefault();
                $state.go('login', $state.params);
            }

            $rootScope.isAdmin = function () {
                if (($rootScope.isAuthenticated) && (roles.sessionStorage.getItem("rol").equals("admin"))) {
                    return true;
                }
            };
            $rootScope.isCliente = function () {
                if (($rootScope.isAuthenticated) && (roles.sessionStorage.getItem("rol").equals("admin"))) {
                    return true;
                }
            };

            $rootScope.isEmpleado = function () {
                if (($rootScope.isAuthenticated) && (roles.sessionStorage.getItem("rol").equals("admin"))) {
                    return true;
                }
            };

            $rootScope.isUnregistred = function () {
                if (!$rootScope.isAuthenticated) {
                    return true;
                }
            };


        });

    }]);
})(window.angular);
