package play.sports

class AdministradorController {

    def index() { 
    	render view: "index"
    }

    def admin() {
    	render template: "admin"
    }
}
