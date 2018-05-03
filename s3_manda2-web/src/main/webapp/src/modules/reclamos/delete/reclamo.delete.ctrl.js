(function (ng) {
    var mod = ng.module("reclamoModule");
    mod.constant("reclamoContext", "api/reclamos");
    mod.controller('reclamoDeleteCtrl', ['$scope', '$http', 'reclamoContext', '$state',
        
        function ($scope, $http, reclamoContext, $state) {
            var id = $state.params.reclamoId;
            
            $scope.deleteReclamo = function () {
                $http.delete(reclamoContext + '/' + id, {}).then(function (response) {
                    $state.go('reclamosList', {reclamoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);