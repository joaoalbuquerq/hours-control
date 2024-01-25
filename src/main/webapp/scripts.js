document.addEventListener('DOMContentLoaded', function() {
      var maskedInputs = document.querySelectorAll('#masked-time');

      maskedInputs.forEach(function(input) {
        input.addEventListener('input', function(event) {
          var inputValue = event.target.value.replace(/\D/g, '');

          if (inputValue.length > 4) {
            inputValue = inputValue.substr(0, 4);
          }

          if (inputValue.length >= 2) {
            inputValue = inputValue.replace(/(\d{2})(\d{2})/, '$1:$2');
          }

          event.target.value = inputValue;
        });
     });
});
    

function limparHorarioMarcacao(){
    var inputEntrada = document.getElementsByName('marcacaoEntrada')[0];
    var inputSaida = document.getElementsByName('marcacaoSaida')[0];
    
    inputEntrada.value = "";
    inputSaida.value = "";
	
}
function limparHorariosPadrao(){
    var inputEntrada = document.getElementsByName('horarioEntrada')[0];
    var inputSaida = document.getElementsByName('horarioSaida')[0];
    
    inputEntrada.value = "";
    inputSaida.value = "";
}
    