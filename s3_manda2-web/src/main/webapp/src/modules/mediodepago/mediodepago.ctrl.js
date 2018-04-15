(function (ng){
    var mod = ng.module('mediodepagoModule');
    mod.controller('mediodepagoCtrl', ['$scope', '$http', 'mediodepagoContext', '$state',
    function($scope, $http, mediodepagoContext, $state){
        if(($state.params.billeteraId !== undefined) && ($state.params.billeteraId !== null)){
        $http.get('data/billeteras').then(function(response){
            $scope.billeteraActual = response.data;
        });
    }
    }]);
})(window.angular);