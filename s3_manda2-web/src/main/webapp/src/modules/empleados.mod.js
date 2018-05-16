(function (ng) {

    var mod = ng.module("empleadoModule", ['ui.router']);
    mod.constant("empleadoContext", "api/empleados");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        var basePath = 'src/modules/empleados/';

        $stateProvider.state('empleadosList', {

            url: '/empleados/list',
            views: {
                'mainView': {
                    templateUrl: basePath + 'empleados.list2.html',
                    controller: 'empleadoCtrl',
                    controllerAs: 'ctrl'
                }
            }
        });
        $stateProvider.state('empleadoDetail', {
            url: 'empleados/{empleadoId: int}/detail',
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
            url: 'empleados/datospersonales',
            views: {
                'detailView': {
                    templateUrl: basePath + 'empleado.detail.html',
                    controller: 'empleadoDetailCtrl',
                    controllerAs: 'ctrl'
                }
            }

        });
        $stateProvider.state('empleadoSubDetail', {
            url: '/empleado/list/detail/datosPersonales',
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
            views: {
                'mainView': {
                    templateUrl: basePath + 'create/empleados.create.html',
                    controller: 'empleadoNewCtrl',
                    controllerAs: 'ctrl'

                }
            }
        });
        $stateProvider.state('borrarEmpleado', {
            url: 'delete/{empleadoId:int}',
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
    }]);
})(window.angular);
