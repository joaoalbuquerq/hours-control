<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Controle de Horas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<main class="container-sm">
    <h1 class="text-center">Horários de Trabalho</h1>
    <form action="/hoursControl/calcular" method="post">
    	<div class="row">
	      <div class="col-md-2 mb-3">
	        <label for="horarioEntrada" class="form-label">Horário Entrada: </label>
	        <input id="masked-time" placeholder="hh:mm" type="text" class="form-control" id="horarioEntrada" name="horarioEntrada" maxlength="5" value=${horarioPadraoEntrada}>
	      </div>
	      
	      <div class="col-md-2 mb-3">
	      	<label for="horarioSaida" class="form-label">Horário Saída: </label>
	        <input id="masked-time" placeholder="hh:mm" type="text" class="form-control" id="horarioSaida" name="horarioSaida" maxlength="5" value=${horarioPadraoSaida}>
	      </div>
	      
	      <div>
	   	  	<button type="button" class="btn btn-warning" onClick="limparHorariosPadrao()">Limpar</button>
	   	  </div>
      	</div>

      <h1 class="text-center">Marcações Feitas</h1>
      <table class="table table-hover">
  		<thead>
		    <tr>
		      <th scope="col">Horário Entrada</th>
		      <th scope="col">Horário Saída</th>
		      <th scope="col">Extra</th>
		      <th scope="col">Atraso</th>
		      <th scope="col">Ações</th>
		    </tr>
  		</thead>
  		<tbody>
  			<tr>
  				
				<td class="col-md-1">
					<input id="masked-time" type="text" class="form-control" id="marcacaoEntrada" name="marcacaoEntrada" maxlength="5" placeholder="hh:mm" value=${horarioMarcacaoEntrada}>
			    </td>
			    
			    <td class="col-md-1"> 
			    	<input id="masked-time" type="text" class="form-control" id="marcacaoSaida"  name="marcacaoSaida" maxlength="5" placeholder="hh:mm" value=${horarioMarcacaoSaida}>
			    </td>
			    
			    <td class="col-md-1"> 
			    	<input type="text" class="form-control" name="extra" maxlength="5" disabled value=${extra}>
			    </td>
			    
			    <td class="col-md-1"> 
			    	<input type="text" class="form-control" name="atraso" maxlength="5" disabled value=${atraso}>
			    </td>
			    
			    <td class="col-md-2"> 
			    	<button type="submit" class="btn btn-success">Calcular</button>
			    	<button type="button" class="btn btn-warning" onClick="limparHorarioMarcacao()">Limpar</button>
			    </td>
    		</tr>
    		
  		</tbody>
	</table>
      </form>
  </main>
  
  <script src="scripts.js"></script>
</body>
</html>