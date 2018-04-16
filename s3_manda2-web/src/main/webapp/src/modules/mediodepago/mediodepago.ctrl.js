(function (ng) {
    var mod = ng.module('mediodepagoModule');
    mod.controller('mediodepagoCtrl', ['$scope', '$http', 'mediodepagoContext', '$state',
        function ($scope, $http, mediodepagoContext, $state) {
            if (($state.params.billeteraId !== undefined) && ($state.params.billeteraId !== null)) {
                //Busca la billetera con el id dado en las billeteras.
                $http.get('data/billeteras').then(function (response) {
                    billeteras = response.data;
                    var billeteraActual = null;
                    for (var billetera in billeteras) {
                        if (billetera.id === $state.params.idbilletera) {
                            billeteraActual = billetera;
                        }
                    }

                    //Guarda en el scope un boolean por cada posible medio de pago que pueda tener la billetera.
                    $scope.tienePayPal = billeteraActual.payPal !== null;
                    $scope.tieneTarjetaCredito = billeteraActual.tarjetaCredito !== null;
                    $scope.tienePse = billeteraActual.pse !== null;
                });
            }
        }]);
})(window.angular);