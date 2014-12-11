<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><g:layoutTitle default="Grails"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${resource(plugin:'optimus', dir: 'css', file: 'bootstrap.min.css')}" type="text/css" media="screen">
        <link rel="stylesheet" href="${resource(plugin:'optimus', dir: 'css', file: 'main.css')}" type="text/css">
        <g:layoutHead/>
        <r:layoutResources />
        <style type="text/css">
            body {
                background-color: #909890;
                margin-top: 50px;
            }
            footer {
                background-color: #2c3e50;
                color: #fff;
                min-height: 100px;
                text-shadow: 1px 1px 2px #888;
                font-weight: bolder;
                font-size: 1.2em;
            }
            #nacional,#mundial {
                background-color: #ee3a45;
            }
            #internacional, #seleccion {
                background-color: #08c;
            }
        </style>
    </head>
    <body>
        <div>
            <g:render template="/header"/>
        </div>
        <div id="contenido">
            <g:layoutBody/>
        </div>
            <g:render template="/footer"/>
        <div>
        </div>
        <script src="${resource(dir: 'js', file: 'jquery.js')}"></script>
        <script src="${resource(dir: 'js', file: 'bootstrap.js')}"></script>
    </body>
</html>