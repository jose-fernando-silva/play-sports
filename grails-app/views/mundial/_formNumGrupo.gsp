<div class="panel panel-info">
	<div class="panel-heading">
		<h2>Grupos <small><span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span></small></h2>
	</div>
  	<div class="panel-body">
  		<g:formRemote role="form" name="formGrupo" update="informacion" url="[controller: 'mundial', action:'consultarGrupo']" before="\$(document).find('.loading').show()" onComplete="\$(document).find('.loading').hide()">
  			<div class="form-group">
		    	<label for="grupo">Elija un grupo: </label>
    			<g:select name="grupo" from="${1..8}" class="form-control"/>
  			</div>
    		<g:submitButton name="btnEnviar" value="Ver" class="btn btn-info"/>
    	</g:formRemote>
  	</div>
</div>
