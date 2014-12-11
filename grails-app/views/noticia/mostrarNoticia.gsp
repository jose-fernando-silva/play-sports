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
                <div class="col-sm-8 col-sm-offset-2" style="margin-top: 10px;">
                    <g:render template="noticia" model="[noticia: noticia]"/>
                </div>
            </div>
        </div>
    </body>
</html>
