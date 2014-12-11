package play.sports

class MundialController {
	def key = "c443b85924f49874e88abb9aa116747a"

    def grupos() {

    }

    def consultarGrupo() {
    	def ligaId = 136
        def liga = Liga.findByIdentificador(ligaId)
        def objResultado
        def grupo = params.grupo
        try { 
            withHttp(uri: "http://www.resultados-futbol.com") {
                objResultado = get(path : '/scripts/api/api.php', query : [key: key, format: 'json', req: 'tables', league: ligaId, group: grupo]) 
            }  
        }catch(Exception e) {
            objResultado = "Hay problemas con la conexión a Internet"
        }
        if(objResultado == "Hay problemas con la conexión a Internet") {
            render objResultado    
        } else {
            render template: "posiciones", model: [tabla: objResultado["table"], liga: liga, grupo: "Grupo ${grupo} - Mundial Brasil 2014"]       
        }
    }

    def calendario() {

    }

    def obtenerPartidos() {
        def objResultado
        def liga
        def grupo
        def partidos = []
        try { 
            def ligaId = 136
            liga = Liga.findByIdentificador(ligaId)
            grupo = params.grupo
            for(int i = 1; i <= 3; i++) {
                withHttp(uri: "http://www.resultados-futbol.com") {
                    objResultado = get(path : '/scripts/api/api.php', query : [key: key, format: 'json', req: 'matchs', league: liga.identificador, group: grupo, round: i]) 
                    partidos << objResultado["match"]                    
                }      
            }
            
        }catch(Exception e) {
            objResultado = "Hay problemas con la conexión a Internet"
        }
        if(objResultado == "Hay problemas con la conexión a Internet") {
            render objResultado    
        } else {
            render template: "partidos", model :[partidos: partidos]
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
}
