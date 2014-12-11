package play.sports

class EstadisticasController {
    def key = "c443b85924f49874e88abb9aa116747a"
    def index() {
        def ligas = Liga.list([sort: "name", order: "asc"])         
        [ligas: ligas]
    }

    def posiciones() {
        def ligaId = params.ligaId
        def liga = Liga.findByIdentificador(ligaId)
        def objResultado
        try { 
            withHttp(uri: "http://www.resultados-futbol.com") {
                objResultado = get(path : '/scripts/api/api.php', query : [key: key, format: 'json', req: 'tables', league: ligaId]) 
            }  
        }catch(Exception e) {
            objResultado = "Hay problemas con la conexión a Internet"
        }
        if(objResultado == "Hay problemas con la conexión a Internet") {
            render objResultado    
        } else {
            render template: "posiciones", model: [tabla: objResultado["table"], liga: liga]       
        }
    }

    def formCalendario() {
        def ligas = Liga.list([sort: "name", order: "asc"])         
        [ligas: ligas]   
    }

    def calendario() {
        def objResultado
        def liga
        def jornada
        try { 
            def ligaId = params.ligaId
            liga = Liga.findByIdentificador(ligaId)
            jornada = params.jornada
            withHttp(uri: "http://www.resultados-futbol.com") {
                objResultado = get(path : '/scripts/api/api.php', query : [key: key, format: 'json', req: 'matchs', league: liga.identificador, round: jornada]) 
            }  
        }catch(Exception e) {
            objResultado = "Hay problemas con la conexión a Internet"
        }
        if(objResultado == "Hay problemas con la conexión a Internet") {
            render objResultado    
        } else {
            render template: "partidos", model: [partidos: objResultado["match"], jornada: jornada, liga: liga]
        }
    }

    def numeroJornadas() {
        if(params.identificador != "null") {
            def liga = Liga.findByIdentificador(params.identificador)
            render template: "jornadas", model: [liga: liga]
        } else {
            render ""
        }
    }

    def detalles() {
        def equipo 
        try {
            equipo = Equipo.findByNombre(params.equipo)
            render template: "detalles", model: [equipo: equipo, detalles: params]
        } catch(Exception e) {
            render "nada"
        }
    }
}