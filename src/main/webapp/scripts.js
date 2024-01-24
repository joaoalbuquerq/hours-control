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