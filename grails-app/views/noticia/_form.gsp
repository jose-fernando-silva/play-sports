<g:set var="entityName" value="${message(code: 'noticia.label', default: 'Noticia')}" />
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
  
      <div class="form-group ${hasErrors(bean:noticiaInstance, field:'titulo','has-error' )}">
        <label for="titulo" class="control-label">
          <g:message code="noticia.titulo.label" default="Titulo" />
          
        </label>
        <g:textField class="form-control" placeholder="Ingrese título de la noticia" name="titulo" maxlength="100" value="${noticiaInstance?.titulo}"/>

        <g:hasErrors bean="${noticiaInstance}" field="titulo">
          <g:eachError bean="${noticiaInstance}" field="titulo">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:noticiaInstance, field:'fechaPublicacion','has-error' )}">
        <label for="fechaPublicacion" class="control-label">
          <g:message code="noticia.fechaPublicacion.label" default="Fecha Publicacion" />
          <span class="required-indicator">*</span>
        </label>
        <g:datePicker name="fechaPublicacion" precision="day"  value="${noticiaInstance?.fechaPublicacion}"  />

        <g:hasErrors bean="${noticiaInstance}" field="fechaPublicacion">
          <g:eachError bean="${noticiaInstance}" field="fechaPublicacion">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:noticiaInstance, field:'redactor','has-error' )}">
        <label for="redactor" class="control-label">
          <g:message code="noticia.redactor.label" default="Redactor" />
          
        </label>
        <g:textField class="form-control" placeholder="Ingrese nombre del redactor de la noticia" name="redactor" maxlength="70" value="${noticiaInstance?.redactor}"/>

        <g:hasErrors bean="${noticiaInstance}" field="redactor">
          <g:eachError bean="${noticiaInstance}" field="redactor">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:noticiaInstance, field:'contenido','has-error' )}">
        <label for="contenido" class="control-label">
          <g:message code="noticia.contenido.label" default="Contenido" />
          
        </label>
        <g:textArea class="form-control" placeholder="Ingrese el contenido de la noticia" name="contenido" cols="40" rows="5" maxlength="1000" value="${noticiaInstance?.contenido}"/>

        <g:hasErrors bean="${noticiaInstance}" field="contenido">
          <g:eachError bean="${noticiaInstance}" field="contenido">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:noticiaInstance, field:'imagen','has-error' )}">
        <label for="imagen" class="control-label">
          <g:message code="noticia.imagen.label" default="Imagen" />
          
        </label>
        <g:field class="form-control" placeholder="Ingrese el url de la imagen de la noticia" type="url" name="imagen" value="${noticiaInstance?.imagen}"/>

        <g:hasErrors bean="${noticiaInstance}" field="imagen">
          <g:eachError bean="${noticiaInstance}" field="imagen">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:noticiaInstance, field:'categoria','has-error' )}">
        <label for="categoria" class="control-label">
          <g:message code="noticia.categoria.label" default="Categoria" />
          <span class="required-indicator">*</span>
        </label>
        <g:select class="form-control" id="categoria" name="categoria.id" from="${play.sports.Categoria.list()}" optionKey="id" required="" value="${noticiaInstance?.categoria?.id}"/>

        <g:hasErrors bean="${noticiaInstance}" field="categoria">
          <g:eachError bean="${noticiaInstance}" field="categoria">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <g:if test="${edit}">
      <g:hiddenField name="id" value="${noticiaInstance?.id}" />
      <g:hiddenField name="version" value="${noticiaInstance?.version}" />
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
