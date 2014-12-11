package play.sports
import grails.converters.*

class Liga {
	Integer year
	Integer group_code
	Integer playoff
	String name
	String country
	Integer current_round
	Integer total_group
	Integer total_rounds
	String flag
	String phase
	Integer identificador

    static constraints = {
		year nullable: false
		group_code nullable: false
		playoff nullable: false
		name nullable: false
		country nullable: false
		current_round nullable: false
		total_group nullable: false
		total_rounds nullable: false
		flag nullable: true
		phase nullable: true
		identificador nullable: false
    }

    def guardarRegistro(obj) {
    	def objJSON = JSON.parse(obj); 
      	this.properties = objJSON

      	try {
        	this.identificador = Integer.parseInt(objJSON.id)
      	} catch(Exception e) {
      		this.identificador = 0
      	}
      	this.save()
    }

    String toString() {
    	name
    }
}