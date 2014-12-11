<g:set var="entityName" value="${message(code: 'categoria.label', default: 'Categoria')}" />
<div class="panel panel-default">
  <div class="panel-heading">
    <g:if test="${edit}">
    <h1>Lista Categorías</h1>
    </g:if>
    <g:else>
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
    </g:else>
  </div>
  <div class="panel-body">
    <g:if test="${flash.formMessage}">
    <div class="alert alert-info alert-dismissable" role="status"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>${flash.formMessage}</div>
    </g:if>
    <form role="form">
  
      <div class="form-group ${hasErrors(bean:categoriaInstance, field:'nombre','has-error' )}">
        <label for="nombre" class="control-label">
          <g:message code="categoria.nombre.label" default="Nombre" />
          
        </label>
        <g:textField class="form-control" placeholder="Ingrese nombre de la categoría" name="nombre" maxlength="50" value="${categoriaInstance?.nombre}"/>

        <g:hasErrors bean="${categoriaInstance}" field="nombre">
          <g:eachError bean="${categoriaInstance}" field="nombre">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:categoriaInstance, field:'descripcion','has-error' )}">
        <label for="descripcion" class="control-label">
          <g:message code="categoria.descripcion.label" default="Descripcion" />
          
        </label>
        <g:textArea class="form-control" placeholder="Ingrese descripción de la categoría" name="descripcion" cols="40" rows="5" maxlength="255" value="${categoriaInstance?.descripcion}"/>

        <g:hasErrors bean="${categoriaInstance}" field="descripcion">
          <g:eachError bean="${categoriaInstance}" field="descripcion">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <g:if test="${edit}">
      <g:hiddenField name="id" value="${categoriaInstance?.id}" />
      <g:hiddenField name="version" value="${categoriaInstance?.version}" />
      <g:submitToRemote class="btn btn-primary" url="[action: 'update']" update="[success:'form', failure:'form']" name="update" value="${message(code: 'default.button.update.label', default: 'Update')}" before="\$('form').find('.loading').show()" onComplete="\$('.loading').hide();" onSuccess="${remoteFunction(action:'list', update:'list', method:'GET')}"/>
      <g:field class="btn btn-default" type="reset" name="reset" value="${message(code: 'default.button.reset.label', default: 'Limpiar')}"/>
      <g:remoteLink class="btn btn-success" action="create" update="form" method="GET" before="\$('form').find('.loading').show()" onComplete="\$('.loading').hide();"><g:message code="default.button.new.label" default="Nuevo"/></g:remoteLink>
      </g:if>
      <g:else>
      <g:submitToRemote class="btn btn-primary" url="[action: 'save']" update="[success:'form', failure:'form']" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}" before="\$('form').find('.loading').show()" onComplete="\$('.loading').hide();" onSuccess="${remoteFunction(action:'list', update:'list', method:'GET')}"/>
      <g:field class="btn btn-default" type="reset" name="reset" value="${message(code: 'default.button.reset.label', default: 'Limpiar')}"/>
      </g:else>
      <span class="loading">
        <span class="glyphicon glyphicon-refresh spinner"/>
      </span>
    </form>
  </div>
</div>
