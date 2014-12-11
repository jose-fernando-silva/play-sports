<div class="panel panel-primary">
	<div class="panel-heading">
		<h2>Ligas <small><span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span></small></h2>
	</div>
  	<div class="panel-body">
  		<g:formRemote role="form" name="formLiga" update="partidos" url="[controller: 'estadisticas', action:'calendario']" before="\$(document).find('.loading').show()" onComplete="\$(document).find('.loading').hide()">
  			<div class="form-group">
		    	<label for="ligaId">Elija una liga: </label>
    			<g:select name="ligaId" from="${ligas}" optionKey="identificador" class="form-control" noSelection="${['null':'Eliga una liga']}" onchange="${remoteFunction(controller: 'estadisticas', action: 'numeroJornadas', update: 'jornada', params: '\'identificador=\' + this.value')}"/>    
  			</div>
        <div class="form-group" id="jornada">
        </div>
    		<g:submitButton name="btnEnviar" value="Ver" class="btn btn-info"/>
		</g:formRemote>
  	</div>
</div>

