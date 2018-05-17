(function (ng) {
    var mod = ng.module('vueltaModule');
    mod.constant("vueltaContext", 'api/vueltascondemoraenoficina');
    mod.controller('vueltasDetailCtrl', ['$scope', '$http', "vueltaContext", '$state',
        function ($scope, $http, vueltaContext, $state) {
            
            if (($state.params.entregaId !== undefined) && ($state.params.entregaId !== null)) {


            $http.get(vueltaContext + '/' + $state.params.vueltaId).then(function (response) {
                $scope.vueltaActual = response.data;
            });
        }
        }
    ]);
})(window.angular);

