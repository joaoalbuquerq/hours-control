<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<main class="container-sm">
    <h1 class="text-center">Horários de Trabalho</h1>
    <form>
    	<div class="row">
	      <div class="col-md-2 mb-3">
	        <label for="horarioEntrada" class="form-label">Horário Entrada: </label>
	        <input type="text" class="form-control" id="horarioEntrada" maxlength="5">
	      </div>
	      
	      <div class="col-md-2 mb-3">
	      	<label for="horarioSaida" class="form-label">Horário Saída: </label>
	        <input type="text" class="form-control" id="horarioSaida" maxlength="5">
	      </div>
	      
	      <div>
	      	<button type="submit" class="btn btn-success">Salvar</button>
	   	  	<button type="submit" class="btn btn-warning">Limpar</button>
	   	  </div>
      	</div>
      
      </form>
      
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
  			<form action="/hoursControl/calcular" method="post">
  			<tr>
  				
				<td class="col-md-1">
					<input id="masked-time" type="text" class="form-control" name="marcacaoEntrada" maxlength="5" placeholder="hh:mm">
			    </td>
			    
			    <td class="col-md-1"> 
			    	<input id="masked-time" type="text" class="form-control" name="marcacaoSaida" maxlength="5" placeholder="hh:mm">
			    </td>
			    
			    <td class="col-md-1"> 
			    	<input type="text" class="form-control" name="extra" maxlength="5" disabled value=${atraso}>
			    </td>
			    
			    <td class="col-md-1"> 
			    	<input type="text" class="form-control" name="atraso" maxlength="5" disabled value=${atraso}>
			    </td>
			    
			    <td class="col-md-2"> 
			    	
			    	<button type="submit" class="btn btn-success">Calcular</button>
			    	<button type="submit" class="btn btn-warning">Limpar</button>
			    	<button type="button" class="btn btn-primary">Adicionar mais uma marcação</button>
			    </td>
    		</tr>
    		</form>
  		</tbody>
	</table>
      
  </main>
  
  <script src="scripts.js"></script>
</body>
</html>