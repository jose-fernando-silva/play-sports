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
        <div>
            <g:render template="nacional" model="${[noticiasNacionales: noticiasNacionales]}"/>
        </div>
        <div>
            <g:render template="internacional" model="${[noticiasInternacionales: noticiasInternacionales]}"/>
        </div>
        <div>
            <g:render template="mundial" model="${[noticiasMundial: noticiasMundial]}"/>
        </div>
        <div>
            <g:render template="seleccion" model="${[noticiasSeleccion: noticiasSeleccion]}"/>
        </div>
    </body>
</html>
