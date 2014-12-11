import play.sports.*
class BootStrap {

    def init = { servletContext ->
    	def adminRole = new Rol(authority: 'ROLE_ADMIN').save(flush: true)
      	def userRole = new Rol(authority: 'ROLE_USER').save(flush: true)

      	def testUser = new Usuario(username: 'admin', password: '12345', nombre: "José Fernando", apellidos: "Silva Hernández")
      	testUser.save(flush: true)

      	UsuarioRol.create testUser, adminRole, true
    }
    def destroy = {
    }
}
