package play.sports

class LibreriaTagLib {
    //static defaultEncodeAs = 'html'
    //static encodeAsForTags = [tagName: 'raw']

    def mostrarFecha = {attr, body ->
    	Date fecha = attr.fecha
    	out << fecha.format('dd/MM/yy')
    }

    def restarHora = {attr, body ->
    	try{
    		def hora = Integer.parseInt(attr.hora)
    		hora += 17;
    		if(hora > 24) 
    			hora -= 24
    		out << hora
    	} catch(Exception e) {
    		out<<attr.hora
    	}
    }

    def juegosJugados = {attr, body ->
        def g = attr.wins
        def e = attr.draws
        def p = attr.losses
        try {
            out << g+e+p
        } catch(NumberFormatException ee) {
            out << "0"
        }
    }
}
