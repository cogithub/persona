package persona

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PasantiasController {

    PasantiasService pasantiasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pasantiasService.list(params), model:[pasantiasCount: pasantiasService.count()]
    }

    def show(Long id) {
        respond pasantiasService.get(id)
    }

    def create() {
        respond new Pasantias(params)
    }

    def save(Pasantias pasantias) {
        if (pasantias == null) {
            notFound()
            return
        }

        try {
            pasantiasService.save(pasantias)
        } catch (ValidationException e) {
            respond pasantias.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pasantias.label', default: 'Pasantias'), pasantias.id])
                redirect pasantias
            }
            '*' { respond pasantias, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pasantiasService.get(id)
    }

    def update(Pasantias pasantias) {
        if (pasantias == null) {
            notFound()
            return
        }

        try {
            pasantiasService.save(pasantias)
        } catch (ValidationException e) {
            respond pasantias.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pasantias.label', default: 'Pasantias'), pasantias.id])
                redirect pasantias
            }
            '*'{ respond pasantias, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pasantiasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pasantias.label', default: 'Pasantias'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pasantias.label', default: 'Pasantias'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
