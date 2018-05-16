(function(ng){
    var mod = ng.module('tarjetacreditoModule');
    mod.constant('tarjetacreditoContext', 'api/tarjetascreditos');
    mod.controller('tarjetacreditoListCtrl', ['$scope', '$http', 'tarjetacreditoContext', 
        function($scope, $http, tarjetacreditoContext){
            $http.get(tarjetacreditoContext).then(function(response){
                $scope.tarjetacreditoRecords = response.data;
            });
        }
    ]);
})(window.angular);
