<g:set var="entityName" value="${message(code: 'equipo.label', default: 'Equipo')}" />
<div class="panel panel-default">
  <div class="panel-heading">
    <g:if test="${edit}">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
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
  
      <div class="form-group ${hasErrors(bean:equipoInstance, field:'nombre','has-error' )}">
        <label for="nombre" class="control-label">
          <g:message code="equipo.nombre.label" default="Nombre" />
          
        </label>
        <g:textField class="form-control" name="nombre" value="${equipoInstance?.nombre}"/>

        <g:hasErrors bean="${equipoInstance}" field="nombre">
          <g:eachError bean="${equipoInstance}" field="nombre">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:equipoInstance, field:'logo','has-error' )}">
        <label for="logo" class="control-label">
          <g:message code="equipo.logo.label" default="Logo" />
          
        </label>
        <g:textField class="form-control" name="logo" value="${equipoInstance?.logo}"/>

        <g:hasErrors bean="${equipoInstance}" field="logo">
          <g:eachError bean="${equipoInstance}" field="logo">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:equipoInstance, field:'identificador','has-error' )}">
        <label for="identificador" class="control-label">
          <g:message code="equipo.identificador.label" default="Identificador" />
          <span class="required-indicator">*</span>
        </label>
        <g:field class="form-control" name="identificador" type="number" value="${equipoInstance?.identificador}" required=""/>

        <g:hasErrors bean="${equipoInstance}" field="identificador">
          <g:eachError bean="${equipoInstance}" field="identificador">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:equipoInstance, field:'liga','has-error' )}">
        <label for="liga" class="control-label">
          <g:message code="equipo.liga.label" default="Liga" />
          <span class="required-indicator">*</span>
        </label>
        <g:select class="form-control" id="liga" name="liga.id" from="${play.sports.Liga.list()}" optionKey="id" required="" value="${equipoInstance?.liga?.id}"/>

        <g:hasErrors bean="${equipoInstance}" field="liga">
          <g:eachError bean="${equipoInstance}" field="liga">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <g:if test="${edit}">
      <g:hiddenField name="id" value="${equipoInstance?.id}" />
      <g:hiddenField name="version" value="${equipoInstance?.version}" />
      <g:submitToRemote class="btn btn-primary" url="[action: 'update']" update="[success:'form', failure:'form']" name="update" value="${message(code: 'default.button.update.label', default: 'Update')}" before="\$('form').find('.loading').show()" onComplete="\$('.loading').hide();" onSuccess="${remoteFunction(action:'list', update:'list', method:'GET')}"/>
      <g:field class="btn btn-default" type="reset" name="reset" value="${message(code: 'default.button.reset.label', default: 'Reset')}"/>
      <g:remoteLink class="btn btn-success" action="create" update="form" method="GET" before="\$('form').find('.loading').show()" onComplete="\$('.loading').hide();"><g:message code="default.button.new.label" default="New"/></g:remoteLink>
      </g:if>
      <g:else>
      <g:submitToRemote class="btn btn-primary" url="[action: 'save']" update="[success:'form', failure:'form']" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}" before="\$('form').find('.loading').show()" onComplete="\$('.loading').hide();" onSuccess="${remoteFunction(action:'list', update:'list', method:'GET')}"/>
      <g:field class="btn btn-default" type="reset" name="reset" value="${message(code: 'default.button.reset.label', default: 'Reset')}"/>
      </g:else>
      <span class="loading">
        <span class="glyphicon glyphicon-refresh spinner"/>
      </span>
    </form>
  </div>
</div>
