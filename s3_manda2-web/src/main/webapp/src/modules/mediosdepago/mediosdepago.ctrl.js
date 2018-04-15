(function (ng){
    var mod = ng.module('mediodepagoModule');
    mod.controller('mediodepagoCtrl', ['$scope', '$http', 'mediosdepagoContext', '$state',
    function($scope, $http, mediosdepagoContext, $state){
        if(($state.params.billeteraId !== undefined) && ($state.params.billeteraId !== null)){
        $http.get('data/billeteras').then(function(response){
            $scope.billeteraActual = response.data;
        });
    }
    }]);
})(window.angular)