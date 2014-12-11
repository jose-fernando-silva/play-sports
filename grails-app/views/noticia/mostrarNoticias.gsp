<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Play - Sports</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${resource(plugin:'optimus', dir: 'css', file: 'bootstrap.min.css')}" type="text/css" media="screen">
        <link rel="stylesheet" href="${resource(plugin:'optimus', dir: 'css', file: 'main.css')}" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12"><h2>${categoria}</h2></div>
                <div class="col-sm-12" style="margin-top: 10px;">
                    <div class="row">
                        <g:each in="${noticias}" var="noticia">
                            <g:render template="miniatura" model="[noticia: noticia, categoria: categoria]"/>
                        </g:each>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
