package persona

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException
import spock.lang.*

class EstudioControllerSpec extends Specification implements ControllerUnitTest<EstudioController>, DomainUnitTest<Estudio> {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * list(_) >> []
            1 * count() >> 0
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        !model.estudioList
        model.estudioCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
        controller.create()

        then:"The model is correctly created"
        model.estudio!= null
    }

    void "Test the save action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.save(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/estudio/index'
        flash.message != null
    }

    void "Test the save action correctly persists"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * save(_ as Estudio)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        populateValidParams(params)
        def estudio = new Estudio(params)
        estudio.id = 1

        controller.save(estudio)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/estudio/show/1'
        controller.flash.message != null
    }

    void "Test the save action with an invalid instance"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * save(_ as Estudio) >> { Estudio estudio ->
                throw new ValidationException("Invalid instance", estudio.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def estudio = new Estudio()
        controller.save(estudio)

        then:"The create view is rendered again with the correct model"
        model.estudio != null
        view == 'create'
    }

    void "Test the show action with a null id"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.show(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the show action with a valid id"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * get(2) >> new Estudio()
        }

        when:"A domain instance is passed to the show action"
        controller.show(2)

        then:"A model is populated containing the domain instance"
        model.estudio instanceof Estudio
    }

    void "Test the edit action with a null id"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.edit(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the edit action with a valid id"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * get(2) >> new Estudio()
        }

        when:"A domain instance is passed to the show action"
        controller.edit(2)

        then:"A model is populated containing the domain instance"
        model.estudio instanceof Estudio
    }


    void "Test the update action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/estudio/index'
        flash.message != null
    }

    void "Test the update action correctly persists"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * save(_ as Estudio)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        populateValidParams(params)
        def estudio = new Estudio(params)
        estudio.id = 1

        controller.update(estudio)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/estudio/show/1'
        controller.flash.message != null
    }

    void "Test the update action with an invalid instance"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * save(_ as Estudio) >> { Estudio estudio ->
                throw new ValidationException("Invalid instance", estudio.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(new Estudio())

        then:"The edit view is rendered again with the correct model"
        model.estudio != null
        view == 'edit'
    }

    void "Test the delete action with a null instance"() {
        when:"The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then:"A 404 is returned"
        response.redirectedUrl == '/estudio/index'
        flash.message != null
    }

    void "Test the delete action with an instance"() {
        given:
        controller.estudioService = Mock(EstudioService) {
            1 * delete(2)
        }

        when:"The domain instance is passed to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:"The user is redirected to index"
        response.redirectedUrl == '/estudio/index'
        flash.message != null
    }
}






