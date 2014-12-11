package play.sports

class LigaMXController {
    def key = "c443b85924f49874e88abb9aa116747a"
    def posiciones() { 
    	def ligaId = 141
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
            [tabla: objResultado["table"], liga: liga]       
        }
    }

    def calendario() {
    	def ligaMx = Liga.findByIdentificador(141)
    	[liga: ligaMx]
    }

    def verPartidos() {
    	def objResultado
        def liga
        def jornada
        try { 
            def ligaId = 141
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
            render template: "partidos", model: [partidos: objResultado["match"], jornada: jornada, liga: liga, mensaje: "Partidos de la jornada ${jornada} del Torneo Clausura"]
        }	
    }

    def detalles() {
        def equipo 
        try {
            equipo = Equipo.findByNombre(params.equipo)
            render template: "detalles", model: [equipo: equipo, detalles: params]
        } catch(Exception e) {
            render ""
        }
    }

    def liguilla() {
                       
    }

    def procesarFase() {
        def objResultado
        def liga
        def ronda

        try { 
            def ligaId = 600
            ronda = params.ronda as int
            liga = Liga.findByIdentificador(ligaId)

            withHttp(uri: "http://www.resultados-futbol.com") {
                objResultado = get(path : '/scripts/api/api.php', query : [key: key, format: 'json', req: 'matchs', league: liga.identificador, round: ronda]) 
            }  
        }catch(Exception e) {
            objResultado = "Hay problemas con la conexión a Internet"
        }
        if(objResultado == "Hay problemas con la conexión a Internet") {
            render objResultado    
        } else {
            def mensajes = ["Cuartos de Final", "Semifinal", "Final"]
            render template: "partidos", model: [partidos: objResultado["match"], mensaje: mensajes[ronda-1]]
        }
    }
}
