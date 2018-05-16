(function (ng) {
    var mod = ng.module('vueltaModule');
    mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
    mod.controller('vueltaDeleteCtrl', ['$scope', '$http', 'vueltaContext', '$state',
        function ($scope, $http, vueltaContext, $state) {
            var idVuelta = $state.params.idVuelta;

            $scope.deleteVuelta = function () {
                $http.delete(vueltaContext + '/' + idVuelta, {}).then(function (response) {
                    $state.go('vueltacondemoraList', {idVuelta: response.id}, {reload: true});
                });
            };
        }]);
})(window.angular);