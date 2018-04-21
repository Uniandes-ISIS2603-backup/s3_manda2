(function(ng){
    var mod = ng.module('paypalModule');
    mod.constant('paypalContext', 'api/paypals');
    mod.controller('paypalDeleteCtrl', ['$scope', '$http', 'paypalContext', '$state',
    function($scope, $http, paypalContext, $state){
        var idPaypal = $state.params.idPaypal;
        
        $scope.deletePaypal = function(){
            $http.delete(paypalContext + '/' + idPaypal, {}).then(function(response){
                $state.go('paypalList', {idPaypal: response.data.id}, {reload:true});
            });
        };
    }]);
})(window.angular);