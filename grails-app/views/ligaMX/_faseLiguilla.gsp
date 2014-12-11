<div class="panel panel-danger">
	<div class="panel-heading">
		<h2>Fase <small><span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span></small></h2>
	</div>
  	<div class="panel-body">
  		<g:formRemote role="form" name="formLiga" update="fase" url="[controller: 'ligaMX', action:'procesarFase']" before="\$(document).find('.loading').show()" onComplete="\$(document).find('.loading').hide()">
            <div class="form-group" id="jornada">
                <label for="jornada">Elija una fase de liguilla: </label>
                <select name="ronda" class="form-control">
                  <option value="1">Cuartos de final</option>
                  <option value="2">Semifinal</option>
                  <option value="3">Final</option>
                </select>
            </div>
    		<g:submitButton name="btnEnviar" value="Ver" class="btn btn-info"/>
		</g:formRemote>
  	</div>
</div>

