package persona

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EstudioController {

    EstudioService estudioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond estudioService.list(params), model:[estudioCount: estudioService.count()]
    }

    def show(Long id) {
        respond estudioService.get(id)
    }

    def create() {
        respond new Estudio(params)
    }

    def save(Estudio estudio) {
        if (estudio == null) {
            notFound()
            return
        }

        try {
            estudioService.save(estudio)
        } catch (ValidationException e) {
            respond estudio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'estudio.label', default: 'Estudio'), estudio.id])
                redirect estudio
            }
            '*' { respond estudio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond estudioService.get(id)
    }

    def update(Estudio estudio) {
        if (estudio == null) {
            notFound()
            return
        }

        try {
            estudioService.save(estudio)
        } catch (ValidationException e) {
            respond estudio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'estudio.label', default: 'Estudio'), estudio.id])
                redirect estudio
            }
            '*'{ respond estudio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        estudioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'estudio.label', default: 'Estudio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'estudio.label', default: 'Estudio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
