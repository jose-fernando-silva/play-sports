<g:set var="minimo" value="${1}"/>
<g:set var="maximo" value="${liga.total_rounds}"/>

<label for="jornada">Elija una jornada: </label>
<g:select name="jornada" from="${minimo..maximo}" class="form-control"/>
