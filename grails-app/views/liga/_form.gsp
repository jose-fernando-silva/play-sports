<g:set var="entityName" value="${message(code: 'liga.label', default: 'Liga')}" />
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
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'year','has-error' )}">
        <label for="year" class="control-label">
          <g:message code="liga.year.label" default="Year" />
          <span class="required-indicator">*</span>
        </label>
        <g:field class="form-control" name="year" type="number" value="${ligaInstance?.year}" required=""/>

        <g:hasErrors bean="${ligaInstance}" field="year">
          <g:eachError bean="${ligaInstance}" field="year">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'group_code','has-error' )}">
        <label for="group_code" class="control-label">
          <g:message code="liga.group_code.label" default="Groupcode" />
          <span class="required-indicator">*</span>
        </label>
        <g:field class="form-control" name="group_code" type="number" value="${ligaInstance?.group_code}" required=""/>

        <g:hasErrors bean="${ligaInstance}" field="group_code">
          <g:eachError bean="${ligaInstance}" field="group_code">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'playoff','has-error' )}">
        <label for="playoff" class="control-label">
          <g:message code="liga.playoff.label" default="Playoff" />
          <span class="required-indicator">*</span>
        </label>
        <g:field class="form-control" name="playoff" type="number" value="${ligaInstance?.playoff}" required=""/>

        <g:hasErrors bean="${ligaInstance}" field="playoff">
          <g:eachError bean="${ligaInstance}" field="playoff">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'name','has-error' )}">
        <label for="name" class="control-label">
          <g:message code="liga.name.label" default="Name" />
          
        </label>
        <g:textField class="form-control" placeholder="Ingrese nombre de la liga" name="name" value="${ligaInstance?.name}"/>

        <g:hasErrors bean="${ligaInstance}" field="name">
          <g:eachError bean="${ligaInstance}" field="name">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'country','has-error' )}">
        <label for="country" class="control-label">
          <g:message code="liga.country.label" default="Country" />
          
        </label>
        <g:textField class="form-control" placeholder="Ingrese país de la liga" name="country" value="${ligaInstance?.country}"/>

        <g:hasErrors bean="${ligaInstance}" field="country">
          <g:eachError bean="${ligaInstance}" field="country">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'current_round','has-error' )}">
        <label for="current_round" class="control-label">
          <g:message code="liga.current_round.label" default="Currentround" />
          <span class="required-indicator">*</span>
        </label>
        <g:field class="form-control" name="current_round" type="number" value="${ligaInstance?.current_round}" required=""/>

        <g:hasErrors bean="${ligaInstance}" field="current_round">
          <g:eachError bean="${ligaInstance}" field="current_round">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'total_group','has-error' )}">
        <label for="total_group" class="control-label">
          <g:message code="liga.total_group.label" default="Totalgroup" />
          <span class="required-indicator">*</span>
        </label>
        <g:field class="form-control" name="total_group" type="number" value="${ligaInstance?.total_group}" required=""/>

        <g:hasErrors bean="${ligaInstance}" field="total_group">
          <g:eachError bean="${ligaInstance}" field="total_group">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'total_rounds','has-error' )}">
        <label for="total_rounds" class="control-label">
          <g:message code="liga.total_rounds.label" default="Totalrounds" />
          <span class="required-indicator">*</span>
        </label>
        <g:field class="form-control" name="total_rounds" type="number" value="${ligaInstance?.total_rounds}" required=""/>

        <g:hasErrors bean="${ligaInstance}" field="total_rounds">
          <g:eachError bean="${ligaInstance}" field="total_rounds">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'flag','has-error' )}">
        <label for="flag" class="control-label">
          <g:message code="liga.flag.label" default="Flag" />
          
        </label>
        <g:textField class="form-control" placeholder="Ingrese la bandera de la liga" name="flag" value="${ligaInstance?.flag}"/>

        <g:hasErrors bean="${ligaInstance}" field="flag">
          <g:eachError bean="${ligaInstance}" field="flag">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'phase','has-error' )}">
        <label for="phase" class="control-label">
          <g:message code="liga.phase.label" default="Phase" />
          
        </label>
        <g:textField class="form-control"  name="phase" value="${ligaInstance?.phase}"/>

        <g:hasErrors bean="${ligaInstance}" field="phase">
          <g:eachError bean="${ligaInstance}" field="phase">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:ligaInstance, field:'identificador','has-error' )}">
        <label for="identificador" class="control-label">
          <g:message code="liga.identificador.label" default="Identificador" />
          <span class="required-indicator">*</span>
        </label>
        <g:field class="form-control" name="identificador" type="number" value="${ligaInstance?.identificador}" required=""/>

        <g:hasErrors bean="${ligaInstance}" field="identificador">
          <g:eachError bean="${ligaInstance}" field="identificador">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <g:if test="${edit}">
      <g:hiddenField name="id" value="${ligaInstance?.id}" />
      <g:hiddenField name="version" value="${ligaInstance?.version}" />
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
