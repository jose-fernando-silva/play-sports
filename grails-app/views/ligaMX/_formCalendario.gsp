<div class="panel panel-danger">
	<div class="panel-heading">
		<h2>Jornada <small><span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span></small></h2>
	</div>
  	<div class="panel-body">
        <g:set var="minimo" value="${1}"/>
        <g:set var="maximo" value="${liga.total_rounds}"/>

  		<g:formRemote role="form" name="formLiga" update="partidos" url="[controller: 'ligaMX', action:'verPartidos']" before="\$(document).find('.loading').show()" onComplete="\$(document).find('.loading').hide()">
            <div class="form-group" id="jornada">
                <label for="jornada">Elija una jornada: </label>
                <g:select name="jornada" from="${minimo..maximo}" class="form-control"/>
            </div>
    		<g:submitButton name="btnEnviar" value="Ver" class="btn btn-info"/>
		</g:formRemote>
  	</div>
</div>

