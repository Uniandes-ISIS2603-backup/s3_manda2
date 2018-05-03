(function (ng) {

    var mod = ng.module("empleadoModule", ['ui.router']);
    mod.constant("empleadoContext", "api/empleados");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/empleados/';
            $stateProvider.state('empleados', {
                url: '/empleados',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'empleados.html',
                        controller: 'empleadoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('empleadosList', {

                url: 'list',
                parent: 'empleados',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'empleados.list2.html',
                        controller: 'empleadoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('empleadoDetail', {
                url: '/{empleadoId:int}/detail',
                parent: 'empleados',
                param: {
                    empleadoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'empleados.list2.html',
                        controller: 'empleadoCtrl',
                        controllerAs: 'ctrl'
                    },
                    'mainView': {
                        templateUrl: basePath + 'empleado.detail.html',
                        controller: 'empleadoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('empleadoDetail2', {
                url: 'datospersonales',
                parent:'empleado',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'empleado.detail.html',
                        controller: 'empleadoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('empleadoSubDetail', {
                url: '/detail/datosPersonales',
                parent: 'empleadoDetail',
                views: {
                    'empleadoView': {
                        templateUrl: basePath + 'empleado.Subdetail.html',
                        controller: 'empleadoDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            });
            $stateProvider.state('empleadoCreate', {
                url: '/create',
                parent:'empleados',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'create/empleados.create.html',
                        controller: 'empleadoNewCtrl',
                        controllerAs: 'ctrl'

                    }
                }
            });
            $stateProvider.state('borrarEmpleado', {
                url: '/delete/{empleadoId:int}',
                parent:'empleados',
                param: {
                    empleadoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'delete/empleado.delete.html',
                        controller: 'empleadoDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('updateEmpleado',{
               url: '/update/{empleadoId:int}',
                parent:'empleados',
                param: {
                    empleadoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'create/empleados.create.html',
                        controller: 'empleadoUpdateCtrl',
                        controllerAs: 'ctrl'
                    }
                } 
            });
        }]);
})(window.angular);
