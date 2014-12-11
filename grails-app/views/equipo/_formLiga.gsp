<div class="panel panel-default">
	<div class="panel-heading">
		<h2>Ligas <small><span class="loading" id="load"><span class="glyphicon glyphicon-refresh spinner"/></span></small></h2>
	</div>
  	<div class="panel-body">
  		<g:formRemote role="form" name="formLiga" update="cont" url="[controller: 'equipo', action:'cargarEquipos']" before="\$('#load').show()" onComplete="\$('#load').hide()">
  			<div class="form-group">
		    	<label for="ligaId">Eliga una liga: </label>
    			<g:select name="ligaId" from="${ligas}" optionKey="identificador" class="form-control"/>    
  			</div>
    		<g:submitButton name="btnEnviar" value="Cargar Equipos" class="btn btn-info"/>
		</g:formRemote>
  	</div>
</div>

